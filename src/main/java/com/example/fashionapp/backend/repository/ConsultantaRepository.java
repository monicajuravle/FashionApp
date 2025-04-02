package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.Consultanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultantaRepository extends JpaRepository<Consultanta, Long> {

    // Găsirea consultanțelor unui utilizator
    List<Consultanta> findByUtilizator_IdUtilizator(Long idUtilizator);
}
