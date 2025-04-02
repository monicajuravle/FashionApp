package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.PreferintaCuloare;
import com.example.fashionapp.backend.model.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PreferintaCuloareRepository extends JpaRepository<PreferintaCuloare, Long> {
    Optional<PreferintaCuloare> findById(Long id);  // Ensure this method exists in your repository
    List<PreferintaCuloare> findByProfil(Profil profil);
}
