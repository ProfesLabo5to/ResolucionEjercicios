package Entidades;

import Enumerables.Color;

import java.time.LocalDate;

public abstract class Participante extends Persona{
    private String localidad;
    private Color equipo;

    public Participante(String nombre, String apellido, LocalDate fechaNacimiento, String localidad, Color equipo) {
        super(nombre, apellido, fechaNacimiento);
        this.localidad = localidad;
        this.equipo = equipo;

    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Color getEquipo() {
        return equipo;
    }

    public void setEquipo(Color equipo) {
        this.equipo = equipo;
    }

    public abstract void prepararLugarDeTrabajo();
}
