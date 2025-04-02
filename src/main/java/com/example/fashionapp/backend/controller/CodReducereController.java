package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.CodReducere;
import com.example.fashionapp.backend.service.CodReducereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/codReducere")
public class CodReducereController {

    private final CodReducereService codReducereService;

    @Autowired
    public CodReducereController(CodReducereService codReducereService) {
        this.codReducereService = codReducereService;
    }

    // Creare cod de reducere
    @PostMapping("/create")
    public ResponseEntity<CodReducere> createCodReducere(@RequestBody CodReducere codReducere) {
        CodReducere createdCod = codReducereService.createCodReducere(codReducere);
        return new ResponseEntity<>(createdCod, HttpStatus.CREATED);
    }
}
