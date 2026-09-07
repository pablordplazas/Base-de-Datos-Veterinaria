package com.veterinaria.api_veterinaria.ServiceImpl;

import com.veterinaria.api_veterinaria.model.Veterinario;
import com.veterinaria.api_veterinaria.repository.VeterinarioRepository;
import com.veterinaria.api_veterinaria.service.VeterinarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioServiceImpl(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    @Override
    public List<Veterinario> listarTodos() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Veterinario buscarPorId(Long id) {
        return veterinarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado con ID: " + id));
    }

    @Override
    public Veterinario guardar(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public Veterinario actualizar(Long id, Veterinario veterinarioDetalles) {
        Veterinario veterinario = buscarPorId(id);
        veterinario.setNombre(veterinarioDetalles.getNombre());
        veterinario.setTarjetaProfesional(veterinarioDetalles.getTarjetaProfesional());
        veterinario.setEspecialidad(veterinarioDetalles.getEspecialidad());
        veterinario.setCorreo(veterinarioDetalles.getCorreo());
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public void eliminar(Long id) {
        Veterinario veterinario = buscarPorId(id);
        veterinarioRepository.delete(veterinario);
    }
}
