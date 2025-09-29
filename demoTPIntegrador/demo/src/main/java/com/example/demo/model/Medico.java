package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medico", schema = "stock")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedico")
    private Long id;

    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EspecialidadPorMedico> especialidades;

    public Medico(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidades = new ArrayList<>();
    }

    public Medico() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<EspecialidadPorMedico> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<EspecialidadPorMedico> especialidades) {
        this.especialidades = especialidades;
    }
}

