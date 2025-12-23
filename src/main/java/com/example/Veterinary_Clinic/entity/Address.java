package com.example.Veterinary_Clinic.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    private String city;
    private String state;
}
