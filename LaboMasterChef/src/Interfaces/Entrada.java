package Interfaces;
import Excepciones.NoPuedeCocinarException;
import Platos.PlatoE;

public interface Entrada {
    PlatoE cocinarEntrada(PlatoE plato) throws NoPuedeCocinarException;
    PlatoE servirEntrada(PlatoE plato);
}