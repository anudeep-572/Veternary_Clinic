package com.example.Veterinary_Clinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode; // <--- Import this
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    @JsonIgnoreProperties("appointments")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "vet_id", nullable = false)
    @JsonIgnoreProperties("appointments")
    private Vet vet;


    @ManyToMany
    @JoinTable(
            name = "appointment_treatment",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id")
    )
    @JsonIgnoreProperties("appointments")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude // <--- FIX: Stop the HashCode loop here
    private Set<Treatment> treatments = new HashSet<>();


}