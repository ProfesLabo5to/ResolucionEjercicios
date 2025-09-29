package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class MedicoConEspecialidadesDTO {
    private String nombre;
    private String apellido;
    private List<String> especialidades;

    public MedicoConEspecialidadesDTO(String nombre, String apellido, List<String> especialidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidades = especialidades;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }
}
