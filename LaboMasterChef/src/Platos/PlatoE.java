package Platos;

import Entidades.Plato;

import java.util.HashMap;

public class PlatoE extends Plato {
    public PlatoE(String nombre, HashMap<String, Integer> ingredientesNecesarios, int tiempoPreparacion) {
        super(nombre, tiempoPreparacion, ingredientesNecesarios);
    }
}
