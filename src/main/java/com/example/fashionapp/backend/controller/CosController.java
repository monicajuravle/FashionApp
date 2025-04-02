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
@RequestMapping("/api/cos")
public class CosController {

    private final CosRepository cosRepository;
    private final UtilizatorRepository utilizatorRepository;
    private final ProdusRepository produsRepository;
    private final CosProdusRepository cosProdusRepository;

    @Autowired
    public CosController(CosRepository cosRepository, UtilizatorRepository utilizatorRepository,
                         ProdusRepository produsRepository, CosProdusRepository cosProdusRepository) {
        this.cosRepository = cosRepository;
        this.utilizatorRepository = utilizatorRepository;
        this.produsRepository = produsRepository;
        this.cosProdusRepository = cosProdusRepository;
    }

    @PostMapping("/adauga")
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

        if (cosProdus == null) {
            cosProdus = new CosProdus();
            cosProdus.setCos(cos);
            cosProdus.setProdus(produs);
            cosProdus.setCantitate(1);
        } else {
            cosProdus.setCantitate(cosProdus.getCantitate() + 1);

        }

        // Salvăm produsul în coș
        cosProdusRepository.save(cosProdus);

        return ResponseEntity.ok("Produsul a fost adăugat în coș cu succes!");
    }

    @GetMapping("/vizualizeaza/{idUtilizator}")
    public ResponseEntity<?> vizualizeazaCos(@PathVariable Long idUtilizator) {
        // Căutăm coșul utilizatorului
        Cos cos = cosRepository.findByUtilizatorId(idUtilizator);
        if (cos == null) {
            return ResponseEntity.badRequest().body("Coșul utilizatorului nu a fost găsit.");
        }

        // Returnăm lista produselor din coș
        return ResponseEntity.ok(cos);
    }

    @DeleteMapping("/sterge/{idUtilizator}/{idProdus}")
    public ResponseEntity<String> stergeDinCos(@PathVariable Long idUtilizator, @PathVariable Long idProdus) {
        // Căutăm coșul utilizatorului
        Cos cos = cosRepository.findByUtilizatorId(idUtilizator);
        if (cos == null) {
            return ResponseEntity.badRequest().body("Coșul utilizatorului nu a fost găsit.");
        }

        // Căutăm produsul în coș
        Produs produs = produsRepository.findById(idProdus).orElse(null);
        if (produs == null) {
            return ResponseEntity.badRequest().body("Produsul nu a fost găsit.");
        }

        CosProdus cosProdus = cosProdusRepository.findByCosAndProdus(cos, produs).orElse(null);
        if (cosProdus == null) {
            return ResponseEntity.badRequest().body("Produsul nu este în coșul utilizatorului.");
        }

        // Ștergem produsul din coș
        cosProdusRepository.delete(cosProdus);

        return ResponseEntity.ok("Produsul a fost șters din coș.");
    }
}
