package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.Ocazie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcazieRepository extends JpaRepository<Ocazie, Long> {
    // Poți adăuga metode personalizate aici, dacă ai nevoie
}
