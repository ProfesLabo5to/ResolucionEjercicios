package Platos;

import Entidades.Plato;

import java.util.HashMap;

public class PlatoP extends Plato {
    public PlatoP(String nombre, HashMap<String, Integer> ingredientesNecesarios, int tiempoPreparacion) {
        super(nombre, tiempoPreparacion, ingredientesNecesarios);
    }
}
