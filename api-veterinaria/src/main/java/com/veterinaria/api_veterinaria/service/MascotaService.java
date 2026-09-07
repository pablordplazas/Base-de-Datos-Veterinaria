package com.veterinaria.api_veterinaria.service;

import com.veterinaria.api_veterinaria.model.Mascota;
import java.util.List;

public interface MascotaService {
    Mascota buscarPorId(Long id);
    Mascota guardar(Mascota mascota, Long propietarioId);
    Mascota actualizar(Long id, Mascota mascota);
    void eliminar(Long id);
    List<Mascota> buscarPorPropietario(Long propietarioId);
    Mascota asignarVeterinario(Long mascotaId, Long veterinarioId);
}