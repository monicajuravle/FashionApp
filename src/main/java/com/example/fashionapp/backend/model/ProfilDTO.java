package com.example.fashionapp.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfilDTO {

    private Long idProfil;

    private Long idUtilizator; // Referencing the user by ID instead of the full object

    private int inaltime; // Height in cm

    private int greutate; // Weight in kg

    private List<Long> culoriPreferateIds; // List of IDs for preferred colors
}
