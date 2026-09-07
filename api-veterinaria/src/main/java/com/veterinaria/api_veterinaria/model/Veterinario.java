package com.veterinaria.api_veterinaria.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "veterinario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // Oculta el ID al crear registros
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    @Column(unique = true)
    private String tarjetaProfesional;

    private String especialidad;

    @Email
    private String correo;

    // Relación: Un veterinario puede atender a muchas mascotas
    @ManyToMany(mappedBy = "veterinarios")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // Oculta la lista de mascotas en el POST de veterinario
    private Set<Mascota> mascotas;
}