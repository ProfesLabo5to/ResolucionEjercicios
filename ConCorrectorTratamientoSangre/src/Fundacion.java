import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Fundacion {
    private HashSet<Paciente> todosLosPacientes = new HashSet<>();
    private HashMap<Tratamiento, Integer> pacientesEnTratamiento = new HashMap<>();

    public void agregarPaciente(Paciente paciente) {
        todosLosPacientes.add(paciente);
        if (paciente instanceof Tratamiento) {
            pacientesEnTratamiento.put((Tratamiento) paciente, 0);
        }
    }

    /*
        Alternativa al instanceof:
        public void agregarPaciente(Paciente paciente) {
            todosLosPacientes.add(paciente);
            if (paciente.esCandidatoATratamiento()) {
                pacientesEnTratamiento.put((Tratamiento) paciente, 0);
            }
        }
    */

    public void ejecutarTratamientosDiarios() {
        for (Tratamiento pacienteT : pacientesEnTratamiento.keySet()) {
            if (pacienteT.puedeRecibirTratamiento()) {
                pacientesEnTratamiento.put(pacienteT, pacientesEnTratamiento.get(pacienteT) + 1);
            }
        }
    }

    public int contarPacientesNoCalificados() {
        return todosLosPacientes.size() - pacientesEnTratamiento.size();
    }

    public static void main(String[] args) {
        Fundacion fundacion = new Fundacion();

        LocalDate fecha1 = LocalDate.of(2010, 6, 5);
        LocalDate fecha2 = LocalDate.of(1999, 3, 15);
        LocalDate fecha3 = LocalDate.of(1980, 1, 1);
        LocalDate fecha4 = LocalDate.of(1945, 7, 30);
        HashSet<String> actividades = new HashSet<>();
        actividades.add("Fútbol");
        actividades.add("Natación");
        actividades.add("Correr");

        Ninio ninio = new Ninio("Juan", "Pérez", fecha1, "M", TipoSangre.AB_POS, ValorTolerancia.SIETE);
        Ninio ninio2 = new Ninio("Juan", "Pérez", LocalDate.now(), "M", TipoSangre.AB_POS, ValorTolerancia.SIETE);
        Joven joven = new Joven("Lucia", "Gomez", fecha2, "F", TipoSangre.A_NEG, actividades);
        Adulto adulto = new Adulto("Carlos", "Lopez", fecha3, "M", TipoSangre.B_POS);
        Geronte geronte = new Geronte("Maria", "Rodriguez", fecha4, "F", TipoSangre.O_NEG);

        fundacion.agregarPaciente(ninio);
        fundacion.agregarPaciente(joven);
        fundacion.agregarPaciente(adulto);
        fundacion.agregarPaciente(geronte);

        ninio.puedeRecibirTratamiento();
        ninio2.puedeRecibirTratamiento();
        joven.puedeRecibirTratamiento();

        fundacion.ejecutarTratamientosDiarios();
        System.out.println("Cantidad de pacientes no calificados: " + fundacion.contarPacientesNoCalificados());
    }
}