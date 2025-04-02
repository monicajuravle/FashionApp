package com.example.fashionapp.backend.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


public class ResponseData {
    private String nume;
    private String prenume;
    private String email;
    private String parola;
    private int inaltime;
    private int greutate;

    public ResponseData(String nume, String prenume, String email, String parola, int inaltime, int greutate) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.inaltime = inaltime;
        this.greutate = greutate;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getEmail() {
        return email;
    }

    public String getParola() {
        return parola;
    }

    public int getInaltime() {
        return inaltime;
    }

    public int getGreutate() {
        return greutate;
    }


    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

}
