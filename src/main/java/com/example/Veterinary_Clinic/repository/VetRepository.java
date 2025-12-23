package com.example.Veterinary_Clinic.repository;

import com.example.Veterinary_Clinic.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
