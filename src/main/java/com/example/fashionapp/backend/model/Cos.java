package com.example.fashionapp.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCos;

    @OneToOne
    @JoinColumn(name = "idUtilizator")
    private Utilizator utilizator;

    @OneToMany(mappedBy = "cos")
    private List<CosProdus> produse;

}
