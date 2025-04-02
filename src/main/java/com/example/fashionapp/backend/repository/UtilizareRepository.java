package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.Utilizare;
import com.example.fashionapp.backend.model.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UtilizareRepository extends JpaRepository<Utilizare, Long> {

    // Găsește toate utilizările pentru un utilizator care au fost făcute după o dată specifică
    List<Utilizare> findByUtilizatorAndDataUtilizareAfter(Utilizator utilizator, LocalDateTime startDate);

    // Numără câte utilizări a făcut un utilizator după o dată specifică
    long countByUtilizatorAndDataUtilizareAfter(Utilizator utilizator, LocalDateTime startDate);
}
