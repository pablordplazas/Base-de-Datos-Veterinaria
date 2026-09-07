package com.veterinaria.api_veterinaria.controller;

import com.veterinaria.api_veterinaria.model.HistoriaClinica;
import com.veterinaria.api_veterinaria.service.HistoriaClinicaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historias-clinicas")
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }

    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> listarTodos() {
        return ResponseEntity.ok(historiaClinicaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(historiaClinicaService.buscarPorId(id));
    }

    @PostMapping("/mascota/{mascotaId}")
    public ResponseEntity<HistoriaClinica> crear(@Valid @RequestBody HistoriaClinica historia, @PathVariable Long mascotaId) {
        return ResponseEntity.ok(historiaClinicaService.crear(historia, mascotaId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriaClinica> actualizar(@PathVariable Long id, @Valid @RequestBody HistoriaClinica historia) {
        return ResponseEntity.ok(historiaClinicaService.actualizar(id, historia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historiaClinicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}