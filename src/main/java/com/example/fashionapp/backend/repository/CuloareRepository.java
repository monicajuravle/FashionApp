package com.example.fashionapp.backend.repository;

import com.example.fashionapp.backend.model.Culoare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CuloareRepository extends JpaRepository<Culoare, Long> {
    @Query("Select c.numeCuloare FROM Culoare c join PreferintaCuloare pc on pc.culoare=c join Profil p on p=pc.profil where p.utilizator.idUtilizator=:idUtilizator")
    List<String> findCuloriPreferate(Long idUtilizator);
    // Poți adăuga metode personalizate aici, dacă ai nevoie
}
