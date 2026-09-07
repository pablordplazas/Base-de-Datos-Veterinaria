package com.veterinaria.api_veterinaria.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "mascota")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // Oculta el ID en los formularios de creación (POST)
    private Long id;

    @NotBlank
    private String nombre;

    private String especie;
    private String raza;
    private Integer edad;
    private Double peso;

    // Relación: Una mascota pertenece a un único propietario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propietario_id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // Oculta el propietario en el JSON ya que se envía por la URL
    private Propietario propietario;

    // Relación: Una mascota tiene una única historia clínica
    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // Oculta la historia clínica al crear la mascota
    private HistoriaClinica historiaClinica;

    // Relación: Una mascota puede ser atendida por varios veterinarios
    @ManyToMany
    @JoinTable(
            name = "mascota_veterinario",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns = @JoinColumn(name = "veterinario_id")
    )
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // Oculta los veterinarios en la entrada inicial
    private Set<Veterinario> veterinarios;
}