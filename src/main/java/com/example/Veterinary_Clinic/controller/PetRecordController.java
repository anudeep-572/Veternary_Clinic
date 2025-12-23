package com.example.Veterinary_Clinic.controller;

import com.example.Veterinary_Clinic.entity.PetRecord;
import com.example.Veterinary_Clinic.service.PetRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet-records")
@RequiredArgsConstructor
public class PetRecordController {

    private final PetRecordService service;

    @PostMapping
    public PetRecord create(@RequestBody PetRecord petRecord) {
        return service.save(petRecord);
    }
}

