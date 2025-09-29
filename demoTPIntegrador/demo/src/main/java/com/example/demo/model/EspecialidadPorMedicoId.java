package com.example.demo.model;

import com.fasterxml.jackson.datatype.jsr310.deser.key.YearMothKeyDeserializer;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EspecialidadPorMedicoId implements Serializable {

    @Column(name = "medico_id_medico")
    private Long medicoId;

    @Column(name = "especialidad_id_especialidad")
    private Long especialidadId;

    public EspecialidadPorMedicoId() {}

    public EspecialidadPorMedicoId(Long medicoId, Long especialidadId) {
        this.medicoId = medicoId;
        this.especialidadId = especialidadId;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public Long getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(Long especialidadId) {
        this.especialidadId = especialidadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EspecialidadPorMedicoId)) return false;
        EspecialidadPorMedicoId that = (EspecialidadPorMedicoId) o;
        return Objects.equals(medicoId, that.medicoId) &&
                Objects.equals(especialidadId, that.especialidadId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicoId, especialidadId);
    }
}

