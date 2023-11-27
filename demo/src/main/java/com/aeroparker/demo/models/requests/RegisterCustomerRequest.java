package com.aeroparker.demo.models.requests;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.Date;



@Data
@Builder(builderClassName = "Builder", setterPrefix = "with", toBuilder = true)
public class RegisterCustomerRequest {

    @Temporal(TemporalType.TIMESTAMP)
    private Date registered;
    @NotEmpty
    @Email(message = "This email is  not a valid email", regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String emailAddress;

    @NotEmpty(message = "can not be empty")
    @Size(max = 5)
    private String title;
    @NotEmpty
    @Size(max = 50)
    private String first_Name;
    @NotEmpty
    @Size(max = 50)
    private String last_Name;
    @NotEmpty
    @Size(max = 255)
    private String address_line_1;
    @Size(max = 255)
    private String address_line_2;
    @Size(max = 255)
    private String city;
    @NotEmpty
    @Size(max = 10)
    private String postcode;
    @Size(max = 20)
    private String phoneNumber;



}
