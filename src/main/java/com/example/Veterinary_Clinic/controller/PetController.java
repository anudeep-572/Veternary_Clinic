package com.example.Veterinary_Clinic.controller;

import com.example.Veterinary_Clinic.entity.Pet;
import com.example.Veterinary_Clinic.service.PetService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService service;

    @PostMapping
    public Pet create(@RequestBody Pet pet) {
        return service.save(pet);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Pet> getByOwner(@PathVariable Long ownerId) {
        return service.findByOwner(ownerId);
    }

    @GetMapping
    public List<Pet> getAll() {
        return service.PetAll();
    }

    @GetMapping("/{petId}/medical-history")
    public Pet getMedicalHistory(@PathVariable Long petId) {
        return service.getFullRecord(petId);
    }


    @GetMapping("/treatment/{treatmentId}")
    public List<Pet> petsByTreatment(@PathVariable Long treatmentId) {
        return service.getPetsByTreatment(treatmentId);
    }


}
