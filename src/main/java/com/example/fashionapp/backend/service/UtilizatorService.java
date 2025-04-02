package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.*;
import com.example.fashionapp.backend.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilizatorService {

    @Autowired
    private UtilizatorRepository utilizatorRepository;

    // Metoda pentru a obține toți utilizatorii
    public List<Utilizator> getAllUtilizatori() {
        return utilizatorRepository.findAll();
    }

    // Metoda pentru a obține un utilizator după id
    public Optional<Utilizator> getUtilizatorById(Long id) {
        return utilizatorRepository.findById(id);
    }

    // Metoda pentru a crea un utilizator
    public Utilizator createUtilizator(Utilizator utilizator) {
        return utilizatorRepository.save(utilizator);
    }

    public ResponseData retrieveData(Long utilizatorId)
    {
        Utilizator utilizator=utilizatorRepository.retrieveData(utilizatorId);
        Profil profil=utilizatorRepository.retrieveDataProfil(utilizatorId);
        if(utilizator!=null && profil!=null)
        {
            System.out.println("yes");
            return new ResponseData(
                    utilizator.getNume(),
                    utilizator.getPrenume(),
                    utilizator.getEmail(),
                    utilizator.getParola(),
                    profil.getInaltime(),
                    profil.getGreutate()
            );

        }
        return null;

    }

    // Metoda pentru a actualiza un utilizator
    public void updateUtilizator( UtilizatorDTO utilizator) {
        // Verificăm dacă utilizatorul există deja
        Optional<Utilizator> existingUtilizator = utilizatorRepository.findById(utilizator.getIdUtilizator());
        if (existingUtilizator.isPresent()) {
            // Dacă utilizatorul există, actualizăm câmpurile necesare și îl salvăm
            Utilizator existing = existingUtilizator.get();

            // Actualizează câmpurile necesare (folosește metodele setter ale obiectului 'existing')
            existing.setNume(utilizator.getNume());
            existing.setPrenume(utilizator.getPrenume());
            existing.setEmail(utilizator.getEmail());
            existing.setParola(utilizator.getParola());


            utilizatorRepository.save(existing); // Ensure you save the updated entity


            // Salvează utilizatorul actualizat
        }
    }

    // Metoda pentru a șterge un utilizator
    public boolean deleteUtilizator(Long id) {
        if (utilizatorRepository.existsById(id)) {
            utilizatorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UtilizatorDTO findByEmail(String email,String role)
    {
        Utilizator utilizator=utilizatorRepository.findByEmail(email).orElse(null);
        utilizator.setRole(role);
        if(utilizator!=null)
        {
            return new UtilizatorDTO(
                    utilizator.getIdUtilizator(),
                    utilizator.getNume(),
                    utilizator.getPrenume(),
                    utilizator.getEmail(),
                    utilizator.getParola(),
                    utilizator.getActive()
            );
        }
        return null;
    }
}
