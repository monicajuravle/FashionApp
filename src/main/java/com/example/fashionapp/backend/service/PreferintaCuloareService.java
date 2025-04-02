package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.Culoare;
import com.example.fashionapp.backend.model.PreferintaCuloare;
import com.example.fashionapp.backend.model.Profil;
import com.example.fashionapp.backend.repository.PreferintaCuloareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferintaCuloareService {

    @Autowired
    private PreferintaCuloareRepository preferintaCuloareRepository;

    // Metodă pentru a obține toate preferințele de culoare
    public List<PreferintaCuloare> getAllPreferinte() {
        return preferintaCuloareRepository.findAll();
    }

    // Metodă pentru a crea o preferință de culoare
    public PreferintaCuloare createPreferintaCuloare(PreferintaCuloare preferintaCuloare) {
        return preferintaCuloareRepository.save(preferintaCuloare);
    }
    public PreferintaCuloare creation(Culoare culoare, Profil profil) {
        return preferintaCuloareRepository.save(new PreferintaCuloare(profil,culoare));
    }
}
