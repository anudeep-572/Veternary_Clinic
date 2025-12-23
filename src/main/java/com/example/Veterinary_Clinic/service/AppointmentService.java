package com.example.Veterinary_Clinic.service;

import com.example.Veterinary_Clinic.entity.Appointment;
import com.example.Veterinary_Clinic.entity.Treatment;
import com.example.Veterinary_Clinic.repository.AppointmentRepository;
import com.example.Veterinary_Clinic.repository.TreatmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final TreatmentRepository treatmentRepository;

    // CREATE appointment (no treatments)
    public Appointment save(Appointment appointment) {
        appointment.setTreatments(new HashSet<>());
        return appointmentRepository.save(appointment);
    }

    // READ ALL (safe JOIN FETCH)
    public List<Appointment> getAll() {
        return appointmentRepository.findAllWithRelations();
    }

    // READ BY ID
    public Appointment getById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    // DELETE
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    // UPDATE treatments later using PUT
    public Appointment updateTreatments(Long appointmentId, Set<Long> treatmentIds) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Set<Treatment> managedTreatments = new HashSet<>();

        for (Long tid : treatmentIds) {
            Treatment treatment = treatmentRepository.findById(tid)
                    .orElseThrow(() -> new RuntimeException("Treatment not found: " + tid));
            managedTreatments.add(treatment);
        }

        appointment.setTreatments(managedTreatments);

        return appointmentRepository.save(appointment);
    }
}
