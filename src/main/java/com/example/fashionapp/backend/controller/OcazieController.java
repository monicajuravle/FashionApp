package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.Ocazie;
import com.example.fashionapp.backend.service.OcazieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ocazii")
public class OcazieController {

    @Autowired
    private OcazieService ocazieService;

    // Endpoint pentru a obține toate ocaziile
    @GetMapping
    public List<Ocazie> getAllOcazii() {
        return ocazieService.getAllOcazii();
    }

    // Endpoint pentru a obține o ocazie pe baza ID-ului
    @GetMapping("/{id}")
    public ResponseEntity<Ocazie> getOcazieById(@PathVariable Long id) {
        Ocazie ocazie = ocazieService.getOcazieById(id);
        if (ocazie != null) {
            return ResponseEntity.ok(ocazie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pentru a crea o ocazie
    @PostMapping
    public ResponseEntity<Ocazie> createOcazie(@RequestBody Ocazie ocazie) {
        Ocazie newOcazie = ocazieService.createOcazie(ocazie);
        return ResponseEntity.status(201).body(newOcazie);
    }

    // Endpoint pentru a șterge o ocazie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOcazie(@PathVariable Long id) {
        if (ocazieService.deleteOcazie(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
