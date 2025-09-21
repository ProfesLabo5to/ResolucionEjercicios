import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class Joven extends Paciente implements Tratamiento{
    private static final int EDAD_MIN = 20;
    private static final int EDAD_MAX = 30;
    private HashSet<String> actividades;
    private int tiempoRestante;

    public Joven(String nombre, String apellido, LocalDate fechaNacimiento, String genero, TipoSangre tipoSangre, HashSet<String>actividades) {
        super(nombre, apellido, fechaNacimiento, genero, tipoSangre);
        this.actividades = actividades;
        tiempoRestante = EDAD_MAX - super.getEdad();
    }

    public HashSet<String> getActividades() {
        return actividades;
    }

    public void setActividades(HashSet<String> actividades) {
        this.actividades = actividades;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    private boolean esImpar(){
        return actividades.size() % 2 != 0;
    }

    @Override
    public boolean esCandidatoATratamiento(){
        return true;
    }

    @Override
    public int calcularCosto() {
        int anio = super.getFechaNacimiento().getYear();
        int mes = super.getFechaNacimiento().getMonthValue();
        int dia = super.getFechaNacimiento().getDayOfMonth();

        if (anio % 2 != 0) {
            return mes * 760000;
        } else {
            return dia * 145400;
        }
    }

    @Override
    public boolean puedeRecibirTratamiento() {
        if (esImpar() && tiempoRestante <= 2) {
            System.out.println("Lamentamos comunicarte que tu sangre aún no va a poder ser modificada");
            return false;
        } else {
            System.out.println("Será un tratamiento costoso, pero lo vamos a lograr");
            return true;
        }
    }
}
