package com.veterinaria.api_veterinaria.ServiceImpl;


import com.veterinaria.api_veterinaria.model.HistoriaClinica;
import com.veterinaria.api_veterinaria.model.Mascota;
import com.veterinaria.api_veterinaria.repository.HistoriaClinicaRepository;
import com.veterinaria.api_veterinaria.repository.MascotaRepository;
import com.veterinaria.api_veterinaria.service.HistoriaClinicaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;
    private final MascotaRepository mascotaRepository;

    public HistoriaClinicaServiceImpl(HistoriaClinicaRepository historiaClinicaRepository, MascotaRepository mascotaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public List<HistoriaClinica> listarTodos() {
        return historiaClinicaRepository.findAll();
    }

    @Override
    public HistoriaClinica buscarPorId(Long id) {
        return historiaClinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historia clínica no encontrada con ID: " + id));
    }

    @Override
    public HistoriaClinica crear(HistoriaClinica historia, Long mascotaId) {
        Mascota mascota = mascotaRepository.findById(mascotaId)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + mascotaId));
        historia.setMascota(mascota);
        return historiaClinicaRepository.save(historia);
    }

    @Override
    public HistoriaClinica actualizar(Long id, HistoriaClinica historiaDetalles) {
        HistoriaClinica historia = buscarPorId(id);
        historia.setFechaApertura(historiaDetalles.getFechaApertura());
        historia.setAntecedentes(historiaDetalles.getAntecedentes());
        historia.setObservaciones(historiaDetalles.getObservaciones());
        return historiaClinicaRepository.save(historia);
    }

    @Override
    public void eliminar(Long id) {
        HistoriaClinica historia = buscarPorId(id);
        historiaClinicaRepository.delete(historia);
    }
}