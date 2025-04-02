package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.Ocazie;
import com.example.fashionapp.backend.repository.OcazieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcazieService {

    @Autowired
    private OcazieRepository ocazieRepository;

    // Metodă pentru a obține toate ocaziile
    public List<Ocazie> getAllOcazii() {
        return ocazieRepository.findAll();
    }

    // Metodă pentru a obține o ocazie pe baza ID-ului
    public Ocazie getOcazieById(Long id) {
        return ocazieRepository.findById(id).orElse(null);
    }

    // Metodă pentru a crea o ocazie
    public Ocazie createOcazie(Ocazie ocazie) {
        return ocazieRepository.save(ocazie);
    }

    // Metodă pentru a șterge o ocazie
    public boolean deleteOcazie(Long id) {
        if (ocazieRepository.existsById(id)) {
            ocazieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
