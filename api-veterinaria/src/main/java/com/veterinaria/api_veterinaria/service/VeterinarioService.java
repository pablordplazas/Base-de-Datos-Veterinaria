package com.veterinaria.api_veterinaria.service;

import com.veterinaria.api_veterinaria.model.Veterinario;
import java.util.List;

public interface VeterinarioService {
    List<Veterinario> listarTodos();
    Veterinario buscarPorId(Long id);
    Veterinario guardar(Veterinario veterinario);
    Veterinario actualizar(Long id, Veterinario veterinario);
    void eliminar(Long id);
}