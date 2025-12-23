package com.example.Veterinary_Clinic.repository;

import com.example.Veterinary_Clinic.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query("select o from Owner o where size(o.pets) > 1")
    List<Owner> findOwnersWithMultiplePets();
}
