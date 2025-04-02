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
public class Ocazie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOcazie;

    private String numeOcazie;
}
