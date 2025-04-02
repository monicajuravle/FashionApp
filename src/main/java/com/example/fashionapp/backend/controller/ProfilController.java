package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.dto.SetProfile;
import com.example.fashionapp.backend.model.Culoare;
import com.example.fashionapp.backend.model.PreferintaCuloare;
import com.example.fashionapp.backend.model.Profil;
import com.example.fashionapp.backend.repository.CuloareRepository;
import com.example.fashionapp.backend.repository.PreferintaCuloareRepository;
import com.example.fashionapp.backend.repository.UtilizatorRepository;
import com.example.fashionapp.backend.service.PreferintaCuloareService;
import com.example.fashionapp.backend.service.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfilController {

    @Autowired
    private ProfilService profilService;
    @Autowired
    private UtilizatorRepository utilizatorRepository;
    @Autowired
    private CuloareRepository culoareRepository;
    @Autowired
    private PreferintaCuloareService preferintaCuloareService;

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(@RequestBody Profil profil) {
        try {
            profilService.updateProfil(profil);
            return ResponseEntity.ok("Profile updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/profile")
    public ResponseEntity<?> createProfile(@RequestBody SetProfile setProfile) {
        try {
            Profil newProfil = new Profil();
            profilService.createProfile(newProfil);
            newProfil.setUtilizator(utilizatorRepository.findById(setProfile.getIdUtilizator()).get());
            newProfil.setGreutate(setProfile.getGreutate());
            newProfil.setInaltime(setProfile.getInaltime());
            List<PreferintaCuloare> colors=new ArrayList<>();
            for (Long id:setProfile.getIdColors()) {
                Culoare color=culoareRepository.findById(id).orElse(null);
                colors.add(preferintaCuloareService.creation(color,newProfil));


            }
            newProfil.setCuloriPreferate(colors);
            return ResponseEntity.status(201).body(newProfil);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
