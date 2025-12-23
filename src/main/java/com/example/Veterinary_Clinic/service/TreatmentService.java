package com.example.Veterinary_Clinic.service;

import com.example.Veterinary_Clinic.entity.Treatment;
import com.example.Veterinary_Clinic.repository.TreatmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TreatmentService {

    private final TreatmentRepository repository;

    public Treatment save(Treatment treatment) {
        return repository.save(treatment);
    }

    public List<Treatment> getAll() {
        return repository.findAll();
    }

    public Treatment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treatment not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
