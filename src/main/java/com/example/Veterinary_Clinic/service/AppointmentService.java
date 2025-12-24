package com.example.Veterinary_Clinic.service;

import com.example.Veterinary_Clinic.entity.*;
import com.example.Veterinary_Clinic.repository.*;
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
    private final PetRepository petRepository;
    private final VetRepository vetRepository;

    public Appointment save(Appointment appointment) {

        if (appointment.getPet() != null && appointment.getPet().getId() != null) {
            Pet pet = petRepository.findById(appointment.getPet().getId())
                    .orElseThrow(() -> new RuntimeException("Pet not found"));
            appointment.setPet(pet);
        }

        if (appointment.getVet() != null && appointment.getVet().getId() != null) {
            Vet vet = vetRepository.findById(appointment.getVet().getId())
                    .orElseThrow(() -> new RuntimeException("Vet not found"));
            appointment.setVet(vet);
        }

        appointment.setTreatments(new HashSet<>());

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public Appointment getById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> getByPet(Long petId) {
        return appointmentRepository.findByPetId(petId);
    }

    public List<Appointment> getByVet(Long vetId) {
        return appointmentRepository.findByVetId(vetId);
    }

    public List<Appointment> getCancelledAppointments() {
        return appointmentRepository.findByStatus(AppointmentStatus.CANCELLED);
    }

    public Long countByVet(Long vetId) {
        return appointmentRepository.countAppointmentsByVet(vetId);
    }

    public List<Appointment> getUpcoming() {
        return appointmentRepository.findUpcomingAppointments();
    }

    public Set<Treatment> getTreatmentsByAppointment(Long appointmentId) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        return appointment.getTreatments();
    }

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
