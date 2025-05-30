
//Realizar un sistema que registre las llamadas entre empleados de una empresa. Cada empleado tiene nombre, apellido, DNI, país y teléfono. Para realizar una llamada, se introduce el número destino; al finalizar, se registra la duración. El sistema debe almacenar: empleado origen, empleado destino, fecha y duración de cada llamada, y debe ser capaz de generar un listado de llamadas por empleado y un ranking de empleados que más tiempo llamaron al exterior.

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Empleado juan = new Empleado("Juan", "Pérez", "123", "Argentina", "1111");
        Empleado ana = new Empleado("Ana", "López", "456", "Argentina", "2222");
        Empleado maria = new Empleado("María", "Silva", "789", "Uruguay", "3333");

        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(juan);
        empleados.add(ana);
        empleados.add(maria);

        RegistroLlamada registro = new RegistroLlamada();

        registro.registrarLlamada(juan, ana, 60);
        registro.registrarLlamada(juan, maria, 120);
        registro.registrarLlamada(ana, maria, 200);
        registro.registrarLlamada(maria, juan, 150);

        registro.mostrarLlamadasDe(juan);
        registro.rankingExterior(empleados);
    }
}