package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.Produs;
import com.example.fashionapp.backend.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProdusService {

    @Autowired
    private ProdusRepository produsRepository;

    // Harta care leagă ocaziile de produsele asociate acestora
    private final Map<String, List<Long>> produsePerOcazie = Map.of(
            "nunta", List.of(1L, 2L),  // id-urile produselor pentru nunta
            "intalnire", List.of(3L, 4L), // id-urile produselor pentru întâlnire
            "birou", List.of(5L, 6L) // id-urile produselor pentru birou
    );

    // Funcție care returnează produsele pentru o ocazie
    public List<Produs> getProduseForOccasion(String occasion) {
        // Verificăm dacă există ocazia în hartă
        List<Long> produseIds = produsePerOcazie.getOrDefault(occasion, List.of());

        // Returnăm produsele asociate cu ocazia respectivă
        return produsRepository.findAllById(produseIds);
    }

    public Optional<Produs> getProdusById(Long produsId) {
        return produsRepository.findById(produsId);  // Returnează Optional<Produs>
    }

        /**
         * Salvează un produs în baza de date.
         *
         * @param produs Obiectul produs care trebuie salvat.
         * @return Produsul salvat.
         */
        public Produs saveProdus(Produs produs) {
            if (produs == null) {
                throw new IllegalArgumentException("Produsul nu poate fi null");
            }

            // Validări suplimentare (opțional)
            if (produs.getPret() < 0) {
                throw new IllegalArgumentException("Prețul produsului nu poate fi negativ");
            }

            // Salvare în baza de date
            return produsRepository.save(produs);
        }
    }


