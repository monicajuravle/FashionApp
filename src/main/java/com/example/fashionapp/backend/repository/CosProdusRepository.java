package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.Cos;
import com.example.fashionapp.backend.model.CosProdus;
import com.example.fashionapp.backend.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CosProdusRepository extends JpaRepository<CosProdus, Long> {
    Optional<CosProdus> findByCosAndProdus(Cos cos, Produs produs);
}
