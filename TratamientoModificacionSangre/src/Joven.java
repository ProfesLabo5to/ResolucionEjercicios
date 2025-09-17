import java.time.LocalDate;
import java.util.HashSet;

public class Joven extends Paciente implements Tratamiento{
    private static int EDAD_MIN = 20;
    private static int EDAD_MAX = 30;
    private HashSet<String> actividades;

    public Joven(String nombre, String apellido, LocalDate fechaNacimiento, String genero, TipoSangre tipoSangre, HashSet<String>actividades) {
        super(nombre, apellido, fechaNacimiento, genero, tipoSangre);
        this.actividades = actividades;
        actividades.add("Fútbol");
        actividades.add("Natación");
        actividades.add("Correr");
    }

    public HashSet<String> getActividades() {
        return actividades;
    }

    public void setActividades(HashSet<String> actividades) {
        this.actividades = actividades;
    }

    private boolean esImpar(int elemento){
        return elemento % 2 != 0;
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

        if (esImpar(anio)) {
            return mes * 760000;
        } else {
            return dia * 145400;
        }
    }

    @Override
    public boolean puedeRecibirTratamiento() {
        int tiempoRestante = EDAD_MAX - super.getEdad();
        if (esImpar(actividades.size()) && tiempoRestante <= 2) {
            System.out.println("Lamentamos comunicarte que tu sangre aún no va a poder ser modificada");
            return false;
        } else {
            System.out.println("Será un tratamiento costoso, pero lo vamos a lograr");
            return true;
        }
    }
}
