package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// ProfilRepository care extinde JpaRepository pentru operațiuni CRUD de bază
@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {

    // Dacă ai nevoie de o metodă custom, poți adăuga aici
    // De exemplu, dacă vrei să găsești un profil pe baza ID-ului utilizatorului:
    Optional<Profil> findByUtilizator_IdUtilizator(Long id);
}
