package com.veterinaria.api_veterinaria.repository;

import com.veterinaria.api_veterinaria.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}