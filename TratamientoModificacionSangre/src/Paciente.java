import java.time.LocalDate;

public abstract class Paciente extends Persona{
    private TipoSangre tipoSangre;

    public Paciente(String nombre, String genero, LocalDate fechaNacimiento, String apellido, TipoSangre tipoSangre) {
        super(nombre, genero, fechaNacimiento, apellido);
        this.tipoSangre = tipoSangre;
    }

    public TipoSangre getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(TipoSangre tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public boolean esCandidatoATratamiento() {
        return false;
    }
}