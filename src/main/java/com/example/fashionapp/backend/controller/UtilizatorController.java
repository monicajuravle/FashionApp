package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.ResponseData;
import com.example.fashionapp.backend.model.Utilizator;
import com.example.fashionapp.backend.model.UtilizatorDTO;
import com.example.fashionapp.backend.service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilizatori")
public class UtilizatorController {

    @Autowired
    private UtilizatorService utilizatorService;

    // Endpoint pentru a obține toți utilizatorii
    @GetMapping("/all")
    public List<Utilizator> getAllUtilizatori() {
        return utilizatorService.getAllUtilizatori();
    }

    // Endpoint pentru a obține un utilizator după id
    @GetMapping("/{id}")
    public ResponseEntity<Utilizator> getUtilizatorById(@PathVariable Long id) {
        Optional<Utilizator> utilizator = utilizatorService.getUtilizatorById(id);
        return utilizator.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint pentru a crea un utilizator
    @PostMapping
    public ResponseEntity<Utilizator> createUtilizator(@RequestBody Utilizator utilizator) {
        Utilizator newUtilizator = utilizatorService.createUtilizator(utilizator);
        return ResponseEntity.status(201).body(newUtilizator);
    }

    // Endpoint pentru a actualiza un utilizator
   /* @PutMapping("/{id}")
    public ResponseEntity<Utilizator> updateUtilizator(@PathVariable Long id, @RequestBody Utilizator utilizator) {
        Optional<Utilizator> updatedUtilizator = utilizatorService.updateUtilizator(id, utilizator);
        return updatedUtilizator.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }*/

    // Endpoint pentru a șterge un utilizator
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilizator(@PathVariable Long id) {
        if (utilizatorService.deleteUtilizator(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-user-profile/{idUtilizator}")
    public ResponseEntity<ResponseData> fetchData(@PathVariable Long idUtilizator)
    {
        System.out.println(idUtilizator);
        ResponseData responseData= utilizatorService.retrieveData(idUtilizator);
        if(responseData!=null)
            return ResponseEntity.status(201).body(responseData);
        else
            return ResponseEntity.status(500).body(null);

    }

    @PostMapping("/update-personal-data")
    public ResponseEntity<UtilizatorDTO> updateUtilizator(@RequestBody UtilizatorDTO utilizator)
    {
        System.out.println("Received data: " + utilizator);
        utilizatorService.updateUtilizator(utilizator);
        return ResponseEntity.status(201).body(null);
    }
}
