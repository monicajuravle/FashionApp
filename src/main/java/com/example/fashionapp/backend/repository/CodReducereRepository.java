package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.CodReducere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodReducereRepository extends JpaRepository<CodReducere, Long> {

    // Metoda care caută reducerile unui utilizator
    List<CodReducere> findByUtilizator_IdUtilizator(Long idUtilizator);
}
