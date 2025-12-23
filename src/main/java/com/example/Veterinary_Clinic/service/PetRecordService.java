package com.example.Veterinary_Clinic.service;

import com.example.Veterinary_Clinic.entity.PetRecord;
import com.example.Veterinary_Clinic.repository.PetRecordRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PetRecordService {

    private final PetRecordRepository repository;

    public PetRecord save(PetRecord petRecord) {
        return repository.save(petRecord);
    }
}


