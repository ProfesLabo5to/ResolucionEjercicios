package com.example.demo.controller;

import com.example.demo.model.Especialidad;
import com.example.demo.repository.EspecialidadRepository;
import com.example.demo.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especialidades")
@CrossOrigin(origins = "*") // para permitir llamados desde cualquier frontend
public class EspecialidadController {

    private EspecialidadRepository repo;
    private EspecialidadService servicio;

    public EspecialidadController(EspecialidadRepository repo, EspecialidadService servicio) {
        this.repo = repo;
        this.servicio = servicio;
    }

    // GET - listar todas
    @GetMapping
    public List<Especialidad> listar() {
        return repo.findAll();
    }

    //  GET - obtener por id
    @GetMapping("/{id}")
    public Especialidad obtenerPorId(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // Esto de aca abajo esta hecho sin ninguna verificación
    /*
    // POST - crear nueva
    @PostMapping
    public Especialidad crear(@RequestBody Especialidad especialidad) {
        return repo.save(especialidad);
    }

    // PUT - actualizar
    @PutMapping("/{id}")
    public Especialidad actualizar(@PathVariable Long id, @RequestBody Especialidad actualizada) {
        Optional<Especialidad> existente = repo.findById(id);
        if (existente.isPresent()) {
            Especialidad e = existente.get();
            e.setDetalle(actualizada.getDetalle());
            return repo.save(e);
        }
        return null;
    }

    //  DELETE - eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }*/

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Especialidad especialidad) {
        try {
            return ResponseEntity.ok(servicio.crear(especialidad));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Especialidad especialidad) {
        try {
            return ResponseEntity.ok(servicio.actualizar(id, especialidad));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            servicio.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/letra/{letra}")
    public ResponseEntity<?> filtrarPorLetra(@PathVariable char letra) {
        try {
            return ResponseEntity.ok(servicio.filtrarPorLetraInicial(letra));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al filtrar: " + e.getMessage());
        }
    }

    @GetMapping("/agrupadas")
    public HashMap<Character, ArrayList<Especialidad>> agrupadas() {
        return servicio.agruparPorLetraInicial();
    }

    @GetMapping("/cantidad-por-letra")
    public HashMap<Character, Integer> contar() {
        return servicio.contarPorInicial();
    }
}
