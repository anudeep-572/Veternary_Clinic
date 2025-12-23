package com.example.Veterinary_Clinic.controller;

import com.example.Veterinary_Clinic.entity.Vet;
import com.example.Veterinary_Clinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vets")
@RequiredArgsConstructor
public class VetController {

    private final VetService service;

    @PostMapping
    public Vet create(@RequestBody Vet vet) {
        return service.save(vet);
    }

    @GetMapping
    public List<Vet> getAll() {
        return service.getAll();
    }
}
