package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.PreferintaCuloare;
import com.example.fashionapp.backend.service.PreferintaCuloareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferinte-culoare")
public class PreferintaCuloareController {

    @Autowired
    private PreferintaCuloareService preferintaCuloareService;

    // Endpoint pentru a crea o preferință de culoare
    @PostMapping
    public ResponseEntity<PreferintaCuloare> createPreferintaCuloare(@RequestBody PreferintaCuloare preferintaCuloare) {
        PreferintaCuloare newPreferinta = preferintaCuloareService.createPreferintaCuloare(preferintaCuloare);
        return ResponseEntity.status(201).body(newPreferinta);
    }
}
