package com.example.Veterinary_Clinic.controller;

import com.example.Veterinary_Clinic.entity.Appointment;
import com.example.Veterinary_Clinic.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService service;


    @PostMapping
    public Appointment create(@RequestBody Appointment appointment) {
        return service.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Appointment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}/treatments")
    public Appointment updateTreatments(
            @PathVariable Long id,
            @RequestBody Set<Long> treatmentIds) {

        return service.updateTreatments(id, treatmentIds);
    }
}
