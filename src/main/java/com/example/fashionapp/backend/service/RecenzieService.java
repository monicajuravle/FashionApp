package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.Recenzie;
import com.example.fashionapp.backend.repository.RecenzieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecenzieService {

    private final RecenzieRepository recenzieRepository;

    @Autowired
    public RecenzieService(RecenzieRepository recenzieRepository) {
        this.recenzieRepository = recenzieRepository;
    }

    // Adăugare recenzie
    public Recenzie addRecenzie(Recenzie recenzie) {
        return recenzieRepository.save(recenzie);
    }
}
