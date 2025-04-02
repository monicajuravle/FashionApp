package com.example.fashionapp.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consultanta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultanta;

    @ManyToOne
    @JoinColumn(name = "idUtilizator")
    private Utilizator utilizator;

    @ManyToOne
    @JoinColumn(name = "idOcazie")
    private Ocazie ocazie;


    @Column(name = "dataConsultantei")
    private LocalDate dataConsultantei;
}

