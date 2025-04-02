package com.example.fashionapp.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

public class UtilizatorDTO {

    private Long idUtilizator;

    private String nume;

    private String prenume;

    private String email;
    private String parola;

    private boolean active;

    @Override
    public String toString() {
        return "UtilizatorDTO{" +
                "idUtilizator=" + idUtilizator +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                ", active=" + active +
                '}';
    }

    public UtilizatorDTO(Long idUtilizator, String nume, String prenume, String email, String parola, boolean active) {
        this.idUtilizator = idUtilizator;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.active = active;
    }

    public Long getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(Long idUtilizator) {
        this.idUtilizator = idUtilizator;
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

    public void setActive(boolean active) {
        this.active = active;
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

    public boolean isActive() {
        return active;
    }
}
