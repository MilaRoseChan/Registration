package com.aeroparker.demo.controllers;

import com.aeroparker.demo.controllers.FormController;
import com.aeroparker.demo.models.requests.RegisterCustomerRequest;
import com.aeroparker.demo.services.RegisterCustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
class FormControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RegisterCustomerService registerCustomerService;

    @InjectMocks
    private FormController formController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(formController).build();
    }

    @Test
    void registerCustomer_ValidRequest_Success() throws Exception {
        // Arrange
        RegisterCustomerRequest request = RegisterCustomerRequest.builder()
                .build();
        when(registerCustomerService.save(request))
                .thenReturn(ResponseEntity.ok("Customer saved successfully"));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Customer saved successfully"))
                .andDo(print());
    }

    @Test
    void registerCustomer_InvalidRequest_BadRequest() throws Exception {
        // Arrange
        RegisterCustomerRequest request = RegisterCustomerRequest.builder()
                .build();
        when(registerCustomerService.save(request))
                .thenReturn(ResponseEntity.badRequest().body("Invalid input. Please check your data."));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Invalid input. Please check your data."))
                .andDo(print());
    }

    // Helper method to convert an object to JSON string
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
