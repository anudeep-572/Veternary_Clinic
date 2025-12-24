package com.example.Veterinary_Clinic.repository;

import com.example.Veterinary_Clinic.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByOwnerId(Long ownerId);

    // Repository Interface
    @Query("""
    SELECT DISTINCT p
    FROM Pet p
    LEFT JOIN FETCH p.petRecord
    LEFT JOIN FETCH p.appointments a
    LEFT JOIN FETCH a.treatments
    WHERE p.id = :petId
""")
    Optional<Pet> findFullPetRecord(@Param("petId") Long petId);


    @Query("""
SELECT DISTINCT a.pet 
FROM Appointment a 
JOIN a.treatments t 
WHERE t.id = :treatmentId
""")
    List<Pet> findPetsByTreatment(@Param("treatmentId") Long treatmentId);



}
