package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.Utilizator;
import com.example.fashionapp.backend.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/discounts")
@CrossOrigin(origins = "http://localhost:3000")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    // Endpoint pentru a obține utilizatorii eligibili
    @GetMapping("/eligible-users")
    public List<Utilizator> getEligibleUsers() {
        return discountService.getEligibleUsersForDiscount();
    }

    // Endpoint pentru a genera un cod de reducere pentru un utilizator
    @PostMapping("/generate-code")
    public String generateDiscountCode(@RequestBody Long userId) {
        // Logica pentru a genera un cod de reducere
        String discountCode = "DISCOUNT" + UUID.randomUUID().toString().substring(0, 8); // Cod unic
        // Aici ar trebui să salvezi codul de reducere în baza de date
        // Poți salva codul de reducere și în entitatea `Utilizator`, dacă vrei să asociezi codul unui utilizator
        return discountCode;
    }
}
