package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.Recenzie;
import com.example.fashionapp.backend.service.RecenzieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recenzie")
public class RecenzieController {

    private final RecenzieService recenzieService;

    @Autowired
    public RecenzieController(RecenzieService recenzieService) {
        this.recenzieService = recenzieService;
    }

    // Adăugare recenzie
    @PostMapping("/add")
    public ResponseEntity<Recenzie> adaugaRecenzie(@RequestBody Recenzie recenzie) {
        Recenzie addedRecenzie = recenzieService.addRecenzie(recenzie);
        return new ResponseEntity<>(addedRecenzie, HttpStatus.CREATED);
    }
}
