package com.example.fashionapp.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfil;

    @OneToOne(cascade = CascadeType.ALL) // Establishing the one-to-one relationship
    @JoinColumn(name = "idUtilizator", referencedColumnName = "idUtilizator") // Inverse side of the relationship
    private Utilizator utilizator;

    private int inaltime; // Înălțimea utilizatorului în cm
    private int greutate; // Greutatea utilizatorului în kg



    @OneToMany(mappedBy = "profil", cascade = CascadeType.ALL)
    private List<PreferintaCuloare> culoriPreferate; // Lista de culori preferate

    public Long getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(Long idProfil) {
        this.idProfil = idProfil;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public int getInaltime() {
        return inaltime;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public List<PreferintaCuloare> getCuloriPreferate() {
        return culoriPreferate;
    }

    public void setCuloriPreferate(List<PreferintaCuloare> culoriPreferate) {
        this.culoriPreferate = culoriPreferate;
    }
}
