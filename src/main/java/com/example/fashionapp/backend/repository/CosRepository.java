package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.Cos;
import com.example.fashionapp.backend.model.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CosRepository extends JpaRepository<Cos, Long> {
    // Poți adăuga metode suplimentare pentru căutări personalizate aici, dacă este necesar
    Cos findByUtilizatorId(Long utilizator_id);

}
