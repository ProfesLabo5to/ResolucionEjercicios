public class PacienteTratamiento {
    public Tratamiento paciente;
    public int diasTratamiento;

    public PacienteTratamiento(Tratamiento paciente) {
        this.paciente = paciente;
        this.diasTratamiento = 0;
    }

    public Tratamiento getPaciente() {
        return paciente;
    }

    public void setPaciente(Tratamiento paciente) {
        this.paciente = paciente;
    }

    public int getDiasTratamiento() {
        return diasTratamiento;
    }

    public void setDiasTratamiento(int diasTratamiento) {
        this.diasTratamiento = diasTratamiento;
    }
}
