package Interfaces;
import Excepciones.NoPuedeCocinarException;
import Platos.PlatoP;

public interface Principal {
    PlatoP cocinarPrincipal(PlatoP plato) throws NoPuedeCocinarException;
    PlatoP servirPrincipal(PlatoP plato);
}
