package com.example.fashionapp.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recenzie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecenzie;

    @ManyToOne
    @JoinColumn(name = "idUtilizator")
    private Utilizator utilizator;

    @ManyToOne
    @JoinColumn(name = "idConsultanta")
    private Consultanta consultanta;

    private String continut;
    private int rating; // 1-5
}
