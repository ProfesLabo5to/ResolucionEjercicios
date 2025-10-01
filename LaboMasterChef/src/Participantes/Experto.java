package Participantes;
import Entidades.*;
import Enumerables.*;
import Excepciones.NoPuedeCocinarException;
import Interfaces.Entrada;
import Interfaces.Principal;
import Platos.PlatoP;
import Platos.PlatoE;

import java.time.LocalDate;

public class Experto extends Participante implements Entrada, Principal {
    private static int tiempoLimite = 80; //En minutos
    private int tiempoActual;

    public Experto(String nombre, String apellido, LocalDate fechaNacimiento, String localidad, Color equipo) {
        super(nombre, apellido, fechaNacimiento, localidad, equipo);
        tiempoActual = tiempoLimite;
    }

    public static int getTiempoLimite() {
        return tiempoLimite;
    }

    public static void setTiempoLimite(int tiempoLimite) {
        Experto.tiempoLimite = tiempoLimite;
    }

    @Override
    public void prepararLugarDeTrabajo() {
        tiempoActual -= 5;
        System.out.println("Perdi 5 minutos preparando la mesa por lo que mi tiempo restante es: " + tiempoActual + " min");
    }

    @Override
    public PlatoE cocinarEntrada(PlatoE plato) throws NoPuedeCocinarException {
        if (plato.getTiempoPreparacion() > tiempoActual) {
            throw new NoPuedeCocinarException("Tiempo insuficiente para preparar el plato.");
        }
        tiempoActual -= plato.getTiempoPreparacion();
        System.out.println("Cocinando entrada...");
        return plato;
    }

    @Override
    public PlatoE servirEntrada(PlatoE plato) {
        System.out.println("Sirviendo plato...");
        return plato;
    }

    @Override
    public PlatoP cocinarPrincipal(PlatoP plato) throws NoPuedeCocinarException {
        if (plato.getTiempoPreparacion() > tiempoActual) {
            throw new NoPuedeCocinarException("Tiempo insuficiente para preparar el plato.");
        }
        tiempoActual -= plato.getTiempoPreparacion();
        System.out.println("Cocinando plato principal...");
        return plato;
    }

    @Override
    public PlatoP servirPrincipal(PlatoP plato){
        System.out.println("Sirviendo plato...");
        return plato;
    }
}
