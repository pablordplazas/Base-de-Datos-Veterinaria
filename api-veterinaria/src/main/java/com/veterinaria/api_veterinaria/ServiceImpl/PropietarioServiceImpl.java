package com.veterinaria.api_veterinaria.ServiceImpl;


import com.veterinaria.api_veterinaria.model.Propietario;
import com.veterinaria.api_veterinaria.repository.PropietarioRepository;
import com.veterinaria.api_veterinaria.service.PropietarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioServiceImpl(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    @Override
    public List<Propietario> listarTodos() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario buscarPorId(Long id) {
        return propietarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propietario no encontrado con ID: " + id));
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public Propietario actualizar(Long id, Propietario propietarioDetalles) {
        Propietario propietario = buscarPorId(id);
        propietario.setNombre(propietarioDetalles.getNombre());
        propietario.setDocumento(propietarioDetalles.getDocumento());
        propietario.setTelefono(propietarioDetalles.getTelefono());
        propietario.setCorreo(propietarioDetalles.getCorreo());
        return propietarioRepository.save(propietario);
    }

    @Override
    public void eliminar(Long id) {
        Propietario propietario = buscarPorId(id);
        propietarioRepository.delete(propietario);
    }
}