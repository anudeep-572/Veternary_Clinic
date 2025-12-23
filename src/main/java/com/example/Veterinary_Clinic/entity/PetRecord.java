package com.example.Veterinary_Clinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PetRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String medicalHistory;

    @OneToOne
    @JsonIgnore
    private Pet pet;
}
