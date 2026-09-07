package com.veterinaria.api_veterinaria.repository;

import com.veterinaria.api_veterinaria.model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
}