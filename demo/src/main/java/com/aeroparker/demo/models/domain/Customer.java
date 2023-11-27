package com.aeroparker.demo.models.domain;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;


@Data
@AllArgsConstructor
@Entity
@Builder(builderClassName = "Builder", setterPrefix = "with", toBuilder = true)
public class Customer {

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   // @Column(name = "registered", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registered;
    private String email_address;
    private String title;
    private String first_name;
    private String last_name;
    private String address_line_1;
    private String address_line_2;
    private String city;
    private String postcode;
    private String phone_number;


}
