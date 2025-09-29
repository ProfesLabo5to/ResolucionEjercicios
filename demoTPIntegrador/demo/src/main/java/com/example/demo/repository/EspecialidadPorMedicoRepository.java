package com.example.demo.repository;

import com.example.demo.model.EspecialidadPorMedico;
import com.example.demo.model.EspecialidadPorMedicoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspecialidadPorMedicoRepository extends JpaRepository<EspecialidadPorMedico, EspecialidadPorMedicoId> {
    List<EspecialidadPorMedico> findByMedicoId(Long idMedico);
}

