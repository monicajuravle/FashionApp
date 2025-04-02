package com.example.fashionapp.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "preferinta_culoare")
public class PreferintaCuloare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPreferinta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfil") // Relația corectă de la PreferintaCuloare la Profil
    private Profil profil; // Modificat de la Utilizator la Profil

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCuloare")
    private Culoare culoare;

    public PreferintaCuloare(Profil profil, Culoare culoare) {
        this.profil=profil;
        this.culoare=culoare;
    }
}
