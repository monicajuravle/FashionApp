package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdusRepository extends JpaRepository<Produs, Long> {
    List<Produs> findAllByIdProdusIn(List<Long> ids);
    List<Produs> findByOcazie(String ocazie);
}
