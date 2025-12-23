package com.example.Veterinary_Clinic.repository;

import com.example.Veterinary_Clinic.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByOwnerId(Long ownerId);
}
