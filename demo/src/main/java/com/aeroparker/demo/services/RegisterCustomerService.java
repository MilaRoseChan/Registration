package com.aeroparker.demo.services;

import com.aeroparker.demo.models.domain.Customer;
import com.aeroparker.demo.models.requests.RegisterCustomerRequest;
import com.aeroparker.demo.repositories.AeroparkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCustomerService {

    private final AeroparkerRepository aeroparkerRepository;

    public ResponseEntity<String> save(RegisterCustomerRequest registerCustomerRequest) {
        // Validate input
        if (!isValid(registerCustomerRequest)) {
            return ResponseEntity.badRequest().body("Invalid input. Please check your data.");
        }

        try {
            Customer customerToSave = Customer.builder()
                    .withRegistered(registerCustomerRequest.getRegistered())
                    .build();
            aeroparkerRepository.save(customerToSave);

            return ResponseEntity.ok("Customer saved successfully");
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();

            // Return a response indicating that save has failed
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save failed. Please try again.");
        }
    }


    public boolean isValid(RegisterCustomerRequest registerCustomerRequest) {

        return registerCustomerRequest != null;

    }
}