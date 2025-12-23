package com.example.Veterinary_Clinic.repository;

import com.example.Veterinary_Clinic.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
