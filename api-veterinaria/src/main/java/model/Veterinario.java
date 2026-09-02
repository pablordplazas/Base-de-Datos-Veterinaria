package model;

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
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    @Column(unique = true)
    private String tarjetaProfesional;

    private String especialidad;

    @Email
    private String correo;

    // Relación: Un veterinario puede atender varias mascotas
    @ManyToMany(mappedBy = "veterinarios")
    private Set<Mascota> mascotas;
}
