package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.CodReducere;
import com.example.fashionapp.backend.repository.CodReducereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodReducereService {

    private final CodReducereRepository codReducereRepository;

    @Autowired
    public CodReducereService(CodReducereRepository codReducereRepository) {
        this.codReducereRepository = codReducereRepository;
    }

    // Creare cod reducere
    public CodReducere createCodReducere(CodReducere codReducere) {
        return codReducereRepository.save(codReducere);
    }
}
