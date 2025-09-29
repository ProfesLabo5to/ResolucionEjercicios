package com.example.demo.controller;

import com.example.demo.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*") // para permitir llamados desde cualquier frontend
public class MedicoController {

    private final MedicoService servicio;

    public MedicoController(MedicoService servicio) {
        this.servicio = servicio;
    }


}
