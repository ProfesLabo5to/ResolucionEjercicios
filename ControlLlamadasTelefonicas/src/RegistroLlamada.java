import java.util.ArrayList;

public class RegistroLlamada {
    private ArrayList<Llamada> llamadas;

    public RegistroLlamada() {
        llamadas = new ArrayList<Llamada>();
    }

    public void registrarLlamada(Empleado origen, Empleado destino, int duracionSegundos) {
        llamadas.add(new Llamada(origen, destino, duracionSegundos));
    }

    public void mostrarLlamadasDe(Empleado empleado) {
        System.out.println("Llamadas realizadas por " + empleado.getNombreCompleto() + ": ");
        for (Llamada l : llamadas) {
            if (l.getOrigen().getDni().equals(empleado.getDni())) {
                System.out.println("Llamo a " + l.getDestino().getNombreCompleto() + " y la llamada duro: " + l.getDuracionSegundos() + " seg.");
            }
        }
        System.out.println("\n");
    }

    public void rankingExterior(ArrayList<Empleado> empleados) {
        System.out.println("Ranking de empleados que más llamaron al exterior: ");

        for (Empleado e : empleados) {
            int total = 0;
            for (Llamada l : llamadas) {
                if (l.getOrigen().getDni().equals(e.getDni()) && l.esExterior()) {
                    total += l.getDuracionSegundos();
                }
            }
            System.out.println(e.getNombreCompleto() + ": " + total + " segundos al exterior.");
        }
    }
}