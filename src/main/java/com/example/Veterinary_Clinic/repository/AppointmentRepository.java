package com.example.Veterinary_Clinic.repository;

import com.example.Veterinary_Clinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByPetId(Long petId);

    List<Appointment> findByVetId(Long vetId);

    @Query("select a from Appointment a where a.status = 'CANCELLED'")
    List<Appointment> findCancelledAppointments();

    @Query("select count(a) from Appointment a where a.vet.id = :vetId")
    long countAppointmentsPerVet(Long vetId);

    @Query("""
    SELECT DISTINCT a FROM Appointment a
    LEFT JOIN FETCH a.pet
    LEFT JOIN FETCH a.vet
    LEFT JOIN FETCH a.treatments
""")
    List<Appointment> findAllWithRelations();

}
