package com.example.fashionapp.backend.controller;

import com.example.fashionapp.backend.model.Culoare;
import com.example.fashionapp.backend.model.PreferintaCuloare;
import com.example.fashionapp.backend.model.Produs;
import com.example.fashionapp.backend.model.Profil;
import com.example.fashionapp.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.prefs.PreferencesFactory;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produs")
public class ProdusController {

    private final ProdusRepository produsRepository;
    private final ProfilRepository profilRepository;
    private final PreferintaCuloareRepository preferintaCuloareRepository;
    private final CuloareRepository culoareRepository;
    @Autowired
    public ProdusController(ProdusRepository produsRepository, ProfilRepository profilRepository, PreferintaCuloareRepository preferintaCuloareRepository,CuloareRepository culoareRepository) {
        this.produsRepository = produsRepository;
        this.profilRepository = profilRepository;
        this.preferintaCuloareRepository = preferintaCuloareRepository;
        this.culoareRepository=culoareRepository;
    }

    @PostMapping("/adaugare")
    public ResponseEntity<Produs> adaugaProdus(
            @RequestParam String descriere,
            @RequestParam("imagine") MultipartFile imagine,
            @RequestParam String numeProdus,
            @RequestParam Double pret,
            @RequestParam String urlProvenienta,
            @RequestParam String ocazie,
            @RequestParam String culoare) {

        if (imagine.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        try {
            // Logica pentru salvarea fișierului imagine
            String fileName = imagine.getOriginalFilename();
            Path path = Paths.get("C:/Users/Admin/Desktop/upload", fileName);
            Files.write(path, imagine.getBytes());

            // Crearea și salvarea obiectului Produs
            Produs produs = new Produs(numeProdus, descriere, pret, urlProvenienta, fileName, ocazie, culoare);
            Produs savedProdus = produsRepository.save(produs);

            // Răspuns cu obiectul Produs salvat
            return ResponseEntity.ok(savedProdus);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/allProducts")
    public List<Produs> getAllProducts() {
        return produsRepository.findAll();
    }

    @GetMapping("/ocazie/{ocazie}/{idUtilizator}")
    public List<Produs> getProductsByOccasion(@PathVariable String ocazie,@PathVariable Long idUtilizator) {
        // Filtrăm produsele pe baza ocaziei
        List<Produs> produse = produsRepository.findByOcazie(ocazie);
        List<String> culoriPreferate = culoareRepository.findCuloriPreferate(idUtilizator);
        Iterator<Produs> iterator = produse.iterator();
        while (iterator.hasNext()) {
            Produs p = iterator.next();
            if (!culoriPreferate.contains(p.getCuloare())) {
                iterator.remove(); // Safely remove product if its color is not in preferred colors
            }
        }
        return produse;

    }

    @GetMapping("/ocazie/{ocazie}")
    public List<Produs> getProductsByOccasionOnly(@PathVariable String ocazie) {
        // Filtrăm produsele doar pe baza ocaziei
        return produsRepository.findByOcazie(ocazie);
    }



}
