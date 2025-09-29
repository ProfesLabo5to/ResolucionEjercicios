package com.example.demo.service;

import com.example.demo.model.Especialidad;
import com.example.demo.repository.EspecialidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EspecialidadService {
    private EspecialidadRepository repo;

    public EspecialidadService(EspecialidadRepository repo) {
        this.repo = repo;
    }

    public Especialidad crear(Especialidad nueva) throws Exception {
        if (nueva.getDetalle() == null || nueva.getDetalle().isBlank()) {
            throw new Exception("El detalle no puede estar vacío.");
        }

        boolean yaExiste = repo.findAll().stream()
                .anyMatch(e -> e.getDetalle().equalsIgnoreCase(nueva.getDetalle()));

        if (yaExiste) {
            throw new Exception("Ya existe una especialidad con ese nombre.");
        }

        return repo.save(nueva);
    }

    public Especialidad actualizar(Long id, Especialidad actualizada) throws Exception {
        Especialidad existente = repo.findById(id).orElse(null);

        if (existente == null) {
            throw new Exception("No se encontró la especialidad con ID " + id);
        }

        if (actualizada.getDetalle() == null || actualizada.getDetalle().isBlank()) {
            throw new Exception("El detalle no puede estar vacío.");
        }

        existente.setDetalle(actualizada.getDetalle());
        return repo.save(existente);
    }

    public void eliminar(Long id) throws Exception {
        if (!repo.existsById(id)) {
            throw new Exception("No existe la especialidad con ID " + id);
        }

        repo.deleteById(id);
    }

    public HashMap<Character, ArrayList<Especialidad>> agruparPorLetraInicial() {
        ArrayList<Especialidad> todas = (ArrayList<Especialidad>) repo.findAll();
        HashMap<Character, ArrayList<Especialidad>> agrupadas = new HashMap<>();

        for (Especialidad esp : todas) {
            if (esp.getDetalle() == null || esp.getDetalle().isEmpty()) continue;
            char letra = Character.toUpperCase(esp.getDetalle().charAt(0));

            if (!agrupadas.containsKey(letra)) {
                agrupadas.put(letra, new ArrayList<>());
            }
            agrupadas.get(letra).add(esp);
        }

        return agrupadas;
    }

    public List<Especialidad> filtrarPorLetraInicial(char letra) {
        return  repo.findAll().stream()
                .filter(e -> e.getDetalle() != null && !e.getDetalle().isBlank())
                .filter(e -> Character.toUpperCase(e.getDetalle().charAt(0)) == Character.toUpperCase(letra))
                .toList();
    }
    public HashMap<Character, Integer> contarPorInicial() {
        ArrayList<Especialidad> todas = (ArrayList<Especialidad>) repo.findAll();
        HashMap<Character, Integer> conteo = new HashMap<>();

        for (Especialidad esp : todas) {
            if (esp.getDetalle() == null || esp.getDetalle().isEmpty()) continue;
            char letra = Character.toUpperCase(esp.getDetalle().charAt(0));
            conteo.put(letra, conteo.getOrDefault(letra, 0) + 1);
        }

        return conteo;
    }
}
