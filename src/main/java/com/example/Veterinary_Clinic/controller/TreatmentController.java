package com.example.Veterinary_Clinic.controller;

import com.example.Veterinary_Clinic.entity.Treatment;
import com.example.Veterinary_Clinic.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treatments")
@RequiredArgsConstructor
public class TreatmentController {

    private final TreatmentService service;

    @PostMapping
    public Treatment create(@RequestBody Treatment treatment) {
        return service.save(treatment);
    }

    @GetMapping
    public List<Treatment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Treatment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
