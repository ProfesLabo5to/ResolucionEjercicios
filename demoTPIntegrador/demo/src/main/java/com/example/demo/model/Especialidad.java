package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "especialidad", schema = "stock")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEspecialidad")
    private Long id;

    @Column(name = "detalle")
    private String detalle;

    public Especialidad() {}

    public Especialidad(String detalle) {
        this.detalle = detalle;
    }

    public Long getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
