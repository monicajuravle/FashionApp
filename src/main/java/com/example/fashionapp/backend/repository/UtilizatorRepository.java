package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.Profil;
import com.example.fashionapp.backend.model.ResponseData;
import com.example.fashionapp.backend.model.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UtilizatorRepository extends JpaRepository<Utilizator, Long> {
    Optional<Utilizator> findByEmail(String email);

    @Query("Select u from Utilizator u where u.idUtilizator=:idUtilizator")
    Utilizator retrieveData(Long idUtilizator);

    @Query("Select p from Profil p where p.utilizator.idUtilizator=:idUtilizator")
    Profil retrieveDataProfil(Long idUtilizator);



}
