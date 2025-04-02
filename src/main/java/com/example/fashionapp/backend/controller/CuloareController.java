package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.Culoare;
import com.example.fashionapp.backend.model.CuloareDTO;
import com.example.fashionapp.backend.service.CuloareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/culori")
public class CuloareController {

    @Autowired
    private CuloareService culoareService;

    // Endpoint pentru a obține toate culorile
    @GetMapping
    public List<CuloareDTO> getAllCulori() {
        return culoareService.getAllCulori();
    }

    // Endpoint pentru a obține o culoare pe baza ID-ului
    @GetMapping("/{id}")
    public ResponseEntity<Culoare> getCuloareById(@PathVariable Long id) {
        return culoareService.getCuloareById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint pentru a crea o culoare
    @PostMapping
    public ResponseEntity<Culoare> createCuloare(@RequestBody Culoare culoare) {
        Culoare newCuloare = culoareService.createCuloare(culoare);
        return ResponseEntity.status(201).body(newCuloare);
    }

    // Endpoint pentru a șterge o culoare
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuloare(@PathVariable Long id) {
        if (culoareService.deleteCuloare(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
