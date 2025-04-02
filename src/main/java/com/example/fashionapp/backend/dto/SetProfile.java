package com.example.fashionapp.backend.dto;

import lombok.Getter;

import java.util.List;


@Getter
public class SetProfile {
    private Long idUtilizator;
    private int inaltime; // Înălțimea utilizatorului în cm
    private int greutate;
    private List<Long> idColors;
}
