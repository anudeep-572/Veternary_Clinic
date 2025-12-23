package com.example.Veterinary_Clinic.controller;

import com.example.Veterinary_Clinic.entity.Owner;
import com.example.Veterinary_Clinic.service.OwnerService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService service;

    @PostMapping
    public Owner create(@RequestBody Owner owner) {
        return service.save(owner);
    }

    @GetMapping
    public List<Owner> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Owner getById(@PathVariable Long id) {
        return service.getbyId(id);
    }
}
