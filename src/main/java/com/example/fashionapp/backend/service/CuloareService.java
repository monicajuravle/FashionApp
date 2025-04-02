package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.Culoare;
import com.example.fashionapp.backend.model.CuloareDTO;
import com.example.fashionapp.backend.repository.CuloareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuloareService {

    @Autowired
    private CuloareRepository culoareRepository;

    // Metodă pentru a obține toate culorile
    public List<CuloareDTO> getAllCulori() {
        List<Culoare> culori = culoareRepository.findAll();
        return culori.stream()
                .map(culoare -> {
                    CuloareDTO culoareDTO = new CuloareDTO();
                    culoareDTO.setIdCuloare(culoare.getIdCuloare());
                    culoareDTO.setNumeCuloare(culoare.getNumeCuloare());
                    return culoareDTO;
                })
                .collect(Collectors.toList());
    }

    // Metodă pentru a obține o culoare pe baza ID-ului
    public Optional<Culoare> getCuloareById(Long id) {
        return culoareRepository.findById(id);
    }

    // Metodă pentru a crea o culoare
    public Culoare createCuloare(Culoare culoare) {
        return culoareRepository.save(culoare);
    }

    // Metodă pentru a șterge o culoare
    public boolean deleteCuloare(Long id) {
        if (culoareRepository.existsById(id)) {
            culoareRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
