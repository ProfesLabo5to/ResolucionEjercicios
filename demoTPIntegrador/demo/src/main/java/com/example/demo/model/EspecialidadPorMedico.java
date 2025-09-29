package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "especialidadespormedico", schema = "stock")
public class EspecialidadPorMedico {

    @EmbeddedId
    private EspecialidadPorMedicoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("medicoId")
    @JoinColumn(name = "medico_id_medico")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("especialidadId")
    @JoinColumn(name = "especialidad_id_especialidad")
    private Especialidad especialidad;

    public EspecialidadPorMedico() {}

    public EspecialidadPorMedico(Medico medico, Especialidad especialidad) {
        this.medico = medico;
        this.especialidad = especialidad;
        this.id = new EspecialidadPorMedicoId(medico.getId(), especialidad.getId());
    }

    public EspecialidadPorMedicoId getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
