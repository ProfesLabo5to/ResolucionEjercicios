package com.example.demo.controller;

import com.example.demo.model.EspecialidadPorMedico;
import com.example.demo.service.EspecialidadPorMedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/especialidades-por-medico")
@CrossOrigin(origins = "*") // para permitir llamados desde cualquier frontend
public class EspecialidadPorMedicoController {

    private final EspecialidadPorMedicoService service;

    public EspecialidadPorMedicoController(EspecialidadPorMedicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> asignarEspecialidad(@RequestBody EspecialidadPorMedico epm) {
        try {
            service.asignarEspecialidadAMedico(epm);
            return ResponseEntity.ok("Especialidad asignada con éxito al médico.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/conteo-especialidades")
    public ResponseEntity<?> obtenerConteo() {
        return ResponseEntity.ok(service.contarEspecialidadesPorMedico());
    }

    @GetMapping("/detalle-especialidades")
    public ResponseEntity<?> obtenerDetalle() {
        return ResponseEntity.ok(service.obtenerMedicosConEspecialidades());
    }
}
