package com.veterinaria.api_veterinaria.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "propietario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // Oculta el ID al crear registros
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    @Column(unique = true)
    private String documento;

    private String telefono;

    @Email
    private String correo;

    // Relación: Un propietario puede tener muchas mascotas
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // Oculta la lista de mascotas al enviar el POST de propietario
    private List<Mascota> mascotas;
}