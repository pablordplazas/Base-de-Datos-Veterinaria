package com.veterinaria.api_veterinaria.controller;

import com.veterinaria.api_veterinaria.model.Propietario;
import com.veterinaria.api_veterinaria.service.PropietarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @GetMapping
    public ResponseEntity<List<Propietario>> listarTodos() {
        return ResponseEntity.ok(propietarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(propietarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Propietario> guardar(@Valid @RequestBody Propietario propietario) {
        return ResponseEntity.ok(propietarioService.guardar(propietario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Propietario> actualizar(@PathVariable Long id, @Valid @RequestBody Propietario propietario) {
        return ResponseEntity.ok(propietarioService.actualizar(id, propietario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        propietarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}