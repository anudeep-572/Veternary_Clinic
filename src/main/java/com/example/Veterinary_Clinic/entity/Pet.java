package com.example.Veterinary_Clinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("pet")
    @ToString.Exclude
    private PetRecord petRecord;
}