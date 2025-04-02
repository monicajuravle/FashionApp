package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.Profil;
import com.example.fashionapp.backend.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilService {

    // Injectăm repository-ul
    @Autowired
    private ProfilRepository profilRepository;

    // Metodă de găsire a profilului pe baza ID-ului utilizatorului
    public Profil getProfilById(Long id) {
        return profilRepository.findByUtilizator_IdUtilizator(id).orElse(null);
    }

    // Metodă pentru crearea unui profil
    public Profil createProfile(Profil profil) {
        return profilRepository.save(profil);
    }

    // Metodă pentru actualizarea profilului
    public void updateProfil(Profil profil) {
        profilRepository.save(profil); // Folosim save pentru actualizare
    }
}
