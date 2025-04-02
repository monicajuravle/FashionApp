package com.example.fashionapp.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Utilizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilizator;

    private String nume;
    private String prenume;
    @Getter
    private String email;
    private String parola;

    @Column(nullable = false)
    private boolean active;

    @Enumerated(EnumType.STRING)
    private TipUtilizator tipUtilizator;  // ENUM pentru tipul utilizatorului (client sau administrator)

    @OneToOne(mappedBy = "utilizator")
    private Cos cos;

    @OneToMany(mappedBy = "utilizator")
    private List<Recenzie> recenzii;

    @OneToMany(mappedBy = "utilizator")
    private List<Consultanta> consultante;

    @OneToMany(mappedBy = "utilizator")
    private List<CodReducere> coduriReducere;

    // Câmpul de urmărire a ultimei activități
    private LocalDateTime ultimaActivitate;

    // Verifică dacă utilizatorul este inactiv (nu a fost activ în ultimele 6 luni)
    public boolean isInactiv() {
        if (this.ultimaActivitate == null) {
            return true; // Utilizatorul nu a avut niciodată activitate
        }

        LocalDateTime now = LocalDateTime.now();
        long monthsInactive = java.time.temporal.ChronoUnit.MONTHS.between(this.ultimaActivitate, now);
        return monthsInactive > 6; // Utilizatorul este inactiv dacă nu a fost activ în ultimele 6 luni
    }

    public Long getId() {
        return idUtilizator;
    }

    public void setId(Long id) {
        this.idUtilizator = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return parola;
    }

    public void setPassword(String password) {
        this.parola = password;
    }

    public TipUtilizator getRole() {
        return tipUtilizator;
    }

    public void setRole(String role) {
        this.tipUtilizator = TipUtilizator.valueOf(role.toUpperCase());
    }
    public Boolean getActive(){
        return this.active;
    }

}
