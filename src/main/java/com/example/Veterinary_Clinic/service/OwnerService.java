package com.example.Veterinary_Clinic.service;

import com.example.Veterinary_Clinic.entity.Owner;
import com.example.Veterinary_Clinic.repository.OwnerRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OwnerService {

    private final OwnerRepository repository;

    public Owner save(Owner owner) {
        return repository.save(owner);
    }

    public List<Owner> getAll() {
        return repository.findAll();
    }

    public Owner getbyId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
