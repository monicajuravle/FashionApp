package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.*;
import com.example.fashionapp.backend.repository.CosProdusRepository;
import com.example.fashionapp.backend.repository.CosRepository;
import com.example.fashionapp.backend.repository.ProdusRepository;
import com.example.fashionapp.backend.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cos_produs")
public class CosProdusController {

    private final CosRepository cosRepository;
    private final ProdusRepository produsRepository;
    private final UtilizatorRepository utilizatorRepository;
    private final CosProdusRepository cosProdusRepository;

    @Autowired
    public CosProdusController(CosRepository cosRepository, ProdusRepository produsRepository,
                               UtilizatorRepository utilizatorRepository, CosProdusRepository cosProdusRepository) {
        this.cosRepository = cosRepository;
        this.produsRepository = produsRepository;
        this.utilizatorRepository = utilizatorRepository;
        this.cosProdusRepository = cosProdusRepository;
    }
//this is wrong
    /*@PostMapping("/adauga")
    public ResponseEntity<String> adaugaInCos(@RequestBody CosRequest cosRequest) {
        // Căutăm utilizatorul după ID
        Utilizator utilizator = utilizatorRepository.findById(cosRequest.getIdUtilizator()).orElse(null);
        if (utilizator == null) {
            return ResponseEntity.badRequest().body("Utilizatorul nu a fost găsit.");
        }

        // Căutăm produsul după ID
        Produs produs = produsRepository.findById(cosRequest.getIdProdus()).orElse(null);
        if (produs == null) {
            return ResponseEntity.badRequest().body("Produsul nu a fost găsit.");
        }

        // Găsim sau creăm coșul utilizatorului
        Cos cos = cosRepository.findByUtilizatorId(utilizator.getIdUtilizator());
        if (cos == null) {
            cos = new Cos();
            cos.setUtilizator(utilizator);
            cosRepository.save(cos);
        }

        // Căutăm produsul în coș
        CosProdus cosProdus = cosProdusRepository.findByCosAndProdus(cos, produs).orElse(null);

        if (cosProdus != null) {
            // Dacă produsul există, actualizăm cantitatea
            cosProdus.setCantitate(cosProdus.getCantitate() + 1);
        } else {
            // Dacă produsul nu există, îl adăugăm
            cosProdus = new CosProdus();
            cosProdus.setCos(cos);
            cosProdus.setProdus(produs);
            cosProdus.setCantitate(1);
        }

        // Salvăm produsul în coș
        cosProdusRepository.save(cosProdus);

        return ResponseEntity.ok("Produsul a fost adăugat în coș cu succes!");
    }*/

}
