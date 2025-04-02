package com.example.fashionapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Utilizare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilizare;

    @ManyToOne
    @JoinColumn(name = "id_utilizator")
    private Utilizator utilizator;

    private LocalDateTime dataUtilizare; // Data utilizării aplicației
}
