package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.Utilizator;
import com.example.fashionapp.backend.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private UtilizatorRepository utilizatorRepository;

    // Metoda pentru a șterge un utilizator inactiv
    public boolean deleteUtilizatorInactiv(Long id) {
        Optional<Utilizator> utilizator = utilizatorRepository.findById(id);

        // Verificăm dacă utilizatorul există și dacă este inactiv
        if (utilizator.isPresent()) {
            Utilizator user = utilizator.get();

            // Dacă utilizatorul este inactiv, îl ștergem
            if (!user.getActive()) { // Presupunem că există o metodă `isActive` care verifică dacă utilizatorul este activ
                utilizatorRepository.deleteById(id);
                return true;
            }
        }

        return false; // Dacă utilizatorul nu este găsit sau nu este inactiv
    }
}
