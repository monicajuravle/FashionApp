package com.example.fashionapp.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProdus;

    private String numeProdus;
    private String descriere;
    private double pret;
    private String urlProvenienta;
    private String imagine;
    private String ocazie;
    private String culoare;

    public Produs(String numeProdus, String descriere, Double pret, String urlProvenienta, String imagine, String ocazie, String culoare) {
        this.numeProdus = numeProdus;
        this.descriere = descriere;
        this.pret = pret;
        this.urlProvenienta = urlProvenienta;
        this.imagine = imagine;
        this.ocazie = ocazie;
        this.culoare = culoare;
    }
}

