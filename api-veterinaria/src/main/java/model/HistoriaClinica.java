package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "historia_clinica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaApertura;

    @Column(columnDefinition = "TEXT")
    private String antecedentes;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    // Relación: Una historia clínica pertenece a una única mascota
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mascota_id", nullable = false, unique = true)
    private Mascota mascota;

}