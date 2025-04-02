package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.Utilizator;
import com.example.fashionapp.backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Ștergere utilizator după inactivitate
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUtilizatorInactiv(@PathVariable Long id) {
        boolean isDeleted = adminService.deleteUtilizatorInactiv(id);
        if (isDeleted) {
            return new ResponseEntity<>("Utilizator șters cu succes", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Utilizatorul nu există sau nu este inactiv", HttpStatus.NOT_FOUND);
        }
    }
}
