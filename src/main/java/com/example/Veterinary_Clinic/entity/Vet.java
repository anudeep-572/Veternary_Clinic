package com.example.Veterinary_Clinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "vet")
    @JsonIgnore
    private List<Appointment> appointments;
}
