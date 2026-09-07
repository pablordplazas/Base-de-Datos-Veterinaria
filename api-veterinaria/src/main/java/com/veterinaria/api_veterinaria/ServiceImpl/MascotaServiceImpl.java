package com.veterinaria.api_veterinaria.ServiceImpl;

import com.veterinaria.api_veterinaria.model.Mascota;
import com.veterinaria.api_veterinaria.model.Propietario;
import com.veterinaria.api_veterinaria.model.Veterinario;
import com.veterinaria.api_veterinaria.repository.MascotaRepository;
import com.veterinaria.api_veterinaria.repository.PropietarioRepository;
import com.veterinaria.api_veterinaria.repository.VeterinarioRepository;
import com.veterinaria.api_veterinaria.service.MascotaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;
    private final VeterinarioRepository veterinarioRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository, PropietarioRepository propietarioRepository, VeterinarioRepository veterinarioRepository) {
        this.mascotaRepository = mascotaRepository;
        this.propietarioRepository = propietarioRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    @Override
    public Mascota buscarPorId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + id));
    }

    @Override
    public Mascota guardar(Mascota mascota, Long propietarioId) {
        Propietario propietario = propietarioRepository.findById(propietarioId)
                .orElseThrow(() -> new RuntimeException("Propietario no encontrado con ID: " + propietarioId));
        mascota.setPropietario(propietario);
        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota actualizar(Long id, Mascota mascotaDetalles) {
        Mascota mascota = buscarPorId(id);
        mascota.setNombre(mascotaDetalles.getNombre());
        mascota.setEspecie(mascotaDetalles.getEspecie());
        mascota.setRaza(mascotaDetalles.getRaza());
        mascota.setEdad(mascotaDetalles.getEdad());
        mascota.setPeso(mascotaDetalles.getPeso());
        return mascotaRepository.save(mascota);
    }

    @Override
    public void eliminar(Long id) {
        Mascota mascota = buscarPorId(id);
        mascotaRepository.delete(mascota);
    }

    @Override
    public List<Mascota> buscarPorPropietario(Long propietarioId) {
        return mascotaRepository.findByPropietarioId(propietarioId);
    }

    @Override
    public Mascota asignarVeterinario(Long mascotaId, Long veterinarioId) {
        Mascota mascota = buscarPorId(mascotaId);
        Veterinario veterinario = veterinarioRepository.findById(veterinarioId)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado con ID: " + veterinarioId));

        mascota.getVeterinarios().add(veterinario);
        return mascotaRepository.save(mascota);
    }
}