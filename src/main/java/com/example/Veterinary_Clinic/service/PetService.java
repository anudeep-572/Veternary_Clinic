package com.example.Veterinary_Clinic.service;

import com.example.Veterinary_Clinic.entity.Pet;
import com.example.Veterinary_Clinic.repository.PetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PetService {

    private final PetRepository repository;

    public Pet save(Pet pet) {
        return repository.save(pet);
    }

    public List<Pet> findByOwner(Long ownerId) {
        return repository.findByOwnerId(ownerId);
    }

    public List<Pet> PetAll() {
        return repository.findAll();
    }

    @Transactional
    public Pet getFullRecord(Long petId) {
        return repository.findFullPetRecord(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + petId));
    }



    public List<Pet> getPetsByTreatment(Long treatmentId) {
        return repository.findPetsByTreatment(treatmentId);
    }


}
