package com.example.fashionapp.backend.model;


import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Culoare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuloare;

    private String numeCuloare; // De exemplu, roșu, albastru, etc.

    @OneToMany(mappedBy = "culoare", cascade = CascadeType.ALL)
    private List<PreferintaCuloare> preferinteCuloare;
}
