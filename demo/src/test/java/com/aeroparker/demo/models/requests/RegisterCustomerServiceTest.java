package com.aeroparker.demo.services;

import com.aeroparker.demo.models.requests.RegisterCustomerRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.aeroparker.demo.services.RegisterCustomerService;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class RegisterCustomerServiceTest {

    private RegisterCustomerService registerCustomerService;

    @Test
    void isValidShouldReturnTrueWhenRequestIsValid() {
        // Arrange
        RegisterCustomerRequest validRequest = RegisterCustomerRequest.builder()
                .withFirst_Name("John")
                .withEmailAddress("john@example.com")
                .build();
        // Act
        boolean result = registerCustomerService.isValid(validRequest);

        // Assert
        assertTrue(result);
    }

    @Test
    void isValidShouldReturnFalseWhenRequestIsNull() {
        // Act
        boolean result = registerCustomerService.isValid(null);

        // Assert
        assertFalse(result);
    }

    @Test
    void isValidShouldReturnFalseWhenFirstNameIsNullOrEmpty() {
        // Arrange

        RegisterCustomerRequest invalidRequest = RegisterCustomerRequest.builder()
                .withFirst_Name(null)
                .build();

        // Act
        boolean result = registerCustomerService.isValid(invalidRequest);

        // Assert
        assertFalse(result);
    }

    @Test
    void isValidShouldReturnFalseWhenEmailAddressIsNullOrEmpty() {
        // Arrange
        RegisterCustomerRequest invalidRequest = RegisterCustomerRequest.builder()
                .withFirst_Name("John")
                .withEmailAddress(null)
                .build();

        // Act
        boolean result = registerCustomerService.isValid(invalidRequest);

        // Assert
        assertFalse(result);
    }
}
