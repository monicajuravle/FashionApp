package com.example.fashionapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodReducere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCodReducere;

    private String cod; // Codul de reducere
    private String descriere; // Descrierea reducerii

    @ManyToOne
    @JoinColumn(name = "idUtilizator") // Se leagă de Utilizator
    private Utilizator utilizator;
}
