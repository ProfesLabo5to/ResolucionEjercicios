import java.util.ArrayList;

public class RegistroLlamada {
    private ArrayList<Llamada> llamadas;
    private ArrayList<Empleado> empleados;

    public RegistroLlamada() {
        llamadas = new ArrayList<>();
        empleados = new ArrayList<>();
    }

    public RegistroLlamada(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
        llamadas = new ArrayList<>();
    }

    public void registrarLlamada(Empleado origen, Empleado destino, int duracionSegundos) {
        llamadas.add(new Llamada(origen, destino, duracionSegundos));
    }

    public void mostrarLlamadasDe(Empleado empleado) {
        System.out.println("Llamadas realizadas por " + empleado.getNombreCompleto() + ": ");
        for (Llamada l : llamadas) {
            if (l.getOrigen().equals(empleado)) {
                System.out.println("Llamo a " + l.getDestino().getNombreCompleto() + " y la llamada duro: " + l.getDuracionSegundos() + " seg.");
            }
        }
        System.out.println("\n");
    }

    private void calcularTotalesExterior(ArrayList<Empleado> listaEmpleados,
                                         ArrayList<Integer> totales) {
        for (Llamada l : llamadas) {
            if (l.esExterior()) {
                Empleado e = l.getOrigen();
                // Busco si ya existe este empleado en listaEmpleados:
                int idx = -1;
                for (int i = 0; i < listaEmpleados.size(); i++) {
                    if ( listaEmpleados.get(i).equals(e) ) {
                        idx = i;
                    }
                }
                if (idx == -1) {
                    // No estaba: lo agrego con su duración inicial
                    listaEmpleados.add(e);
                    totales.add(l.getDuracionSegundos());
                } else {
                    // Ya estaba: acumulo la duración
                    int sumaAnterior = totales.get(idx);
                    totales.set(idx, sumaAnterior + l.getDuracionSegundos());
                }
            }
        }
    }
    private void ordenarPorDuracionDesc(ArrayList<Empleado> listaEmpleados,
                                        ArrayList<Integer> totales) {
        int n = totales.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (totales.get(j) > totales.get(maxIdx)) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                // Intercambio en 'totales'
                int tempDur = totales.get(i);
                totales.set(i, totales.get(maxIdx));
                totales.set(maxIdx, tempDur);

                // Intercambio el empleado correspondiente
                Empleado tempEmp = listaEmpleados.get(i);
                listaEmpleados.set(i, listaEmpleados.get(maxIdx));
                listaEmpleados.set(maxIdx, tempEmp);
            }
        }
    }
    private void imprimirRanking(ArrayList<Empleado> listaEmpleados,
                                 ArrayList<Integer> totales) {
        System.out.println("Ranking de empleados por tiempo total de llamadas al exterior:");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado emp = listaEmpleados.get(i);
            int segundos = totales.get(i);
            System.out.println((i + 1) + ". "
                    + emp.getNombreCompleto()
                    + " (DNI: " + emp.getDni() + ") – "
                    + segundos + " seg.");
        }
    }
    public void rankingExteriorLindo() {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Integer> totales = new ArrayList<>();

        // 1) Calcular totales (empleados + tiempo)
        calcularTotalesExterior(listaEmpleados, totales);

        // Si no hay llamadas al exterior, salimos aquí
        if (listaEmpleados.isEmpty()) {
            System.out.println("No se registraron llamadas al exterior.");
            return;
        }

        // 2) Ordenar ambos ArrayList de forma paralela (descendente por segundos)
        ordenarPorDuracionDesc(listaEmpleados, totales);

        // 3) Mostrar el ranking
        imprimirRanking(listaEmpleados, totales);
    }
    public void rankingExteriorFeo() {
        // 1) Construyo listas paralelas: Por un lado los empleados que llamaron al exterior y por otro el tiempo que lo hicieron
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Integer> totales = new ArrayList<>();

        for (Llamada l : llamadas) {
            if (l.esExterior()) {
                Empleado e = l.getOrigen();
                // Busco si ya existe este empleado en listaEmpleados:
                int idx = -1;
                for (int i = 0; i < listaEmpleados.size(); i++) {
                    if ( listaEmpleados.get(i).equals(e) ) {
                        idx = i;
                    }
                }
                if (idx == -1) {
                    // No estaba: lo agrego con su duración inicial
                    listaEmpleados.add(e);
                    totales.add(l.getDuracionSegundos());
                } else {
                    // Ya estaba: acumulo la duración
                    int sumaAnterior = totales.get(idx);
                    totales.set(idx, sumaAnterior + l.getDuracionSegundos());
                }
            }
        }

        // 2) Si no hubo llamadas al exterior termino
        if (listaEmpleados.isEmpty()) {
            System.out.println("No se registraron llamadas al exterior.");
            return;
        }

        // 3) Ordeno ambas listas de forma paralela usando selection sort por totales de mayor a menor
        for (int i = 0; i < totales.size() - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < totales.size(); j++) {
                if (totales.get(j) > totales.get(maxIdx)) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                // Intercambio el valor de totales
                int tempDur = totales.get(i);
                totales.set(i, totales.get(maxIdx));
                totales.set(maxIdx, tempDur);
                // Intercambio también el empleado correspondiente
                Empleado tempEmp = listaEmpleados.get(i);
                listaEmpleados.set(i, listaEmpleados.get(maxIdx));
                listaEmpleados.set(maxIdx, tempEmp);
            }
        }

        // 4) Imprimo el ranking resultante
        System.out.println("Ranking de empleados por tiempo total de llamadas al exterior:");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado emp = listaEmpleados.get(i);
            int segundos = totales.get(i);
            System.out.println(
                    (i + 1) + ". " +
                            emp.getNombreCompleto() +
                            " (DNI: " + emp.getDni() + ") - " +
                            segundos + " seg."
            );
        }
    }
}