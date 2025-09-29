package com.example.demo.service;

import com.example.demo.dto.MedicoConEspecialidadesDTO;
import com.example.demo.model.EspecialidadPorMedico;
import com.example.demo.repository.EspecialidadPorMedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EspecialidadPorMedicoService {

    private final EspecialidadPorMedicoRepository repository;

    public EspecialidadPorMedicoService(EspecialidadPorMedicoRepository repository) {
        this.repository = repository;
    }

    public List<EspecialidadPorMedico> obtenerPorIdMedico(Long idMedico) {
        return repository.findByMedicoId(idMedico);
    }

    public void asignarEspecialidadAMedico(EspecialidadPorMedico relacion) {
        if (relacion.getMedico() == null || relacion.getEspecialidad() == null) {
            throw new IllegalArgumentException("La relación debe tener médico y especialidad.");
        }
        repository.save(relacion);
    }

    public Map<String, Integer> contarEspecialidadesPorMedico() {
        Map<String, Integer> conteo = new HashMap<>();
        List<EspecialidadPorMedico> relaciones = repository.findAll();

        for (EspecialidadPorMedico epm : relaciones) {
            String nombre = epm.getMedico().getNombre() + " " + epm.getMedico().getApellido();
            conteo.put(nombre, conteo.getOrDefault(nombre, 0) + 1);
        }

        return conteo;
    }

    public List<MedicoConEspecialidadesDTO> obtenerMedicosConEspecialidades() {
        Map<Long, MedicoConEspecialidadesDTO> resultado = new HashMap<>();

        for (EspecialidadPorMedico epm : repository.findAll()) {
            Long id = epm.getMedico().getId();
            resultado.putIfAbsent(id, new MedicoConEspecialidadesDTO(
                    epm.getMedico().getNombre(),
                    epm.getMedico().getApellido(),
                    new ArrayList<>())
            );
            resultado.get(id).getEspecialidades().add(epm.getEspecialidad().getDetalle());
        }

        return new ArrayList<>(resultado.values());
    }
}

