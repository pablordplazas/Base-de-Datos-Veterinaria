package com.veterinaria.api_veterinaria.service;

import com.veterinaria.api_veterinaria.model.HistoriaClinica;
import java.util.List;

public interface HistoriaClinicaService {
    List<HistoriaClinica> listarTodos();
    HistoriaClinica buscarPorId(Long id);
    HistoriaClinica crear(HistoriaClinica historia, Long mascotaId);
    HistoriaClinica actualizar(Long id, HistoriaClinica historia);
    void eliminar(Long id);
}