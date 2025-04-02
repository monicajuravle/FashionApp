package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.Recenzie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecenzieRepository extends JpaRepository<Recenzie, Long> {

    // Găsirea recenziilor unui utilizator
    List<Recenzie> findByUtilizator_IdUtilizator(Long idUtilizator);
}
