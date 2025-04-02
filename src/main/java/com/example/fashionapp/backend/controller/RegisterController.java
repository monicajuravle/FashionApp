package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.Utilizator;
import com.example.fashionapp.backend.service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegisterController {

    private final UtilizatorService utilizatorService;

    @Autowired
    public RegisterController(UtilizatorService utilizatorService) {
        this.utilizatorService = utilizatorService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Utilizator utilizator) {
        try {
            utilizatorService.createUtilizator(utilizator);
            return ResponseEntity.ok("User registered successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
}
