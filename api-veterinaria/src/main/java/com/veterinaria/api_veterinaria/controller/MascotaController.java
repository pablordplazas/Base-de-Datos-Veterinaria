package com.veterinaria.api_veterinaria.controller;

import com.veterinaria.api_veterinaria.model.Mascota;
import com.veterinaria.api_veterinaria.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.buscarPorId(id));
    }

    // Requiere el ID del propietario en el request param o path para asociarla
    @PostMapping("/propietario/{propietarioId}")
    public ResponseEntity<Mascota> guardar(@Valid @RequestBody Mascota mascota, @PathVariable Long propietarioId) {
        return ResponseEntity.ok(mascotaService.guardar(mascota, propietarioId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizar(@PathVariable Long id, @Valid @RequestBody Mascota mascota) {
        return ResponseEntity.ok(mascotaService.actualizar(id, mascota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mascotaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/propietario/{propietarioId}")
    public ResponseEntity<List<Mascota>> buscarPorPropietario(@PathVariable Long propietarioId) {
        return ResponseEntity.ok(mascotaService.buscarPorPropietario(propietarioId));
    }

    @PostMapping("/{mascotaId}/veterinario/{veterinarioId}")
    public ResponseEntity<Mascota> asignarVeterinario(@PathVariable Long mascotaId, @PathVariable Long veterinarioId) {
        return ResponseEntity.ok(mascotaService.asignarVeterinario(mascotaId, veterinarioId));
    }
}