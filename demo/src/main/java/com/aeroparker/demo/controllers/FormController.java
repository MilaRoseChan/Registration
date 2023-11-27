package com.aeroparker.demo.controllers;

import com.aeroparker.demo.models.requests.RegisterCustomerRequest;
import com.aeroparker.demo.services.RegisterCustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/registration")
@RequiredArgsConstructor
public class FormController {

    private RegisterCustomerService registerCustomerService;

    @PostMapping
    public ResponseEntity<String> registerCustomer(@Valid @RequestBody RegisterCustomerRequest registerCustomerRequest){
            return registerCustomerService.save(registerCustomerRequest);
    }

}
