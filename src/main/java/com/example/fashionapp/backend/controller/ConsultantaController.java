package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.Consultanta;
import com.example.fashionapp.backend.service.ConsultantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultanta")
public class ConsultantaController {

    private final ConsultantaService consultantaService;

    @Autowired
    public ConsultantaController(ConsultantaService consultantaService) {
        this.consultantaService = consultantaService;
    }

    // Creare consultanta
    @PostMapping("/create")
    public ResponseEntity<Consultanta> createConsultanta(@RequestBody Consultanta consultanta) {
        Consultanta createdConsultanta = consultantaService.createConsultanta(consultanta);
        return new ResponseEntity<>(createdConsultanta, HttpStatus.CREATED);
    }

    // Obținerea consultanțelor pentru utilizator
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Consultanta>> getConsultanteByUser(@PathVariable Long id) {
        List<Consultanta> consultante = consultantaService.getConsultanteByUser(id);
        return new ResponseEntity<>(consultante, HttpStatus.OK);
    }
}
