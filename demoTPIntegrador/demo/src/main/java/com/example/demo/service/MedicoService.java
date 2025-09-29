package com.example.demo.service;

import com.example.demo.dto.MedicoConEspecialidadesDTO;
import com.example.demo.model.Medico;
import com.example.demo.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicoService {
    private MedicoRepository medicoRepo;

    public MedicoService(MedicoRepository medicoRepo) {
        this.medicoRepo = medicoRepo;
    }


}

