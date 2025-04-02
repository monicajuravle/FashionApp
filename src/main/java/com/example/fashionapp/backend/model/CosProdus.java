package com.example.fashionapp.backend.model;

import jakarta.persistence.*;

@Entity
public class CosProdus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cos", nullable = false)
    private Cos cos;

    @ManyToOne
    @JoinColumn(name = "id_produs", nullable = false)
    private Produs produs;

    private int cantitate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cos getCos() {
        return cos;
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
