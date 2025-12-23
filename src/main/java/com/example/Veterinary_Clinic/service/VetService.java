package com.example.Veterinary_Clinic.service;

import com.example.Veterinary_Clinic.entity.Vet;
import com.example.Veterinary_Clinic.repository.VetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VetService {

    private final VetRepository repository;

    public Vet save(Vet vet) {
        return repository.save(vet);
    }

    public List<Vet> getAll() {
        return repository.findAll();
    }
}
