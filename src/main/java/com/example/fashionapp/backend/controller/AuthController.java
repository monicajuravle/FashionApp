package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.dto.LoginRequest;
import com.example.fashionapp.backend.dto.LoginResponse;
import com.example.fashionapp.backend.model.TipUtilizator;
import com.example.fashionapp.backend.model.Utilizator;
import com.example.fashionapp.backend.model.UtilizatorDTO;
import com.example.fashionapp.backend.repository.UtilizatorRepository;
import com.example.fashionapp.backend.service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    private UtilizatorService utilizatorService;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.getRole());
        // Verificăm dacă există utilizatorul cu email-ul respectiv
        UtilizatorDTO utilizatorDTO = utilizatorService.findByEmail(loginRequest.getEmail(),loginRequest.getRole());

        if (utilizatorDTO!=null) {
            System.out.println("das"+utilizatorDTO.getIdUtilizator());
            // Verificăm dacă parola se potrivește (fără criptare)
            if (loginRequest.getPassword().equals(utilizatorDTO.getParola())) {
                // Dacă parolele se potrivesc, trimitem răspunsul cu rolul utilizatorului
                return ResponseEntity.ok(new LoginResponse(TipUtilizator.valueOf(loginRequest.getRole().toUpperCase()),utilizatorDTO.getIdUtilizator()));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
