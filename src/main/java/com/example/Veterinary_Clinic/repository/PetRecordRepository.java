package com.example.Veterinary_Clinic.repository;

import com.example.Veterinary_Clinic.entity.PetRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRecordRepository extends JpaRepository<PetRecord, Long> {
}
