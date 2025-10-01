package Entidades;

import java.util.HashMap;

public class Plato {
    private String nombre;
    private HashMap<String, Integer> ingredientesNecesarios;
    private int tiempoPreparacion;

    public Plato(String nombre, int tiempoPreparacion, HashMap<String, Integer> ingredientesNecesarios) {
        this.nombre = nombre;
        this.tiempoPreparacion = tiempoPreparacion;
        this.ingredientesNecesarios = ingredientesNecesarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public HashMap<String, Integer> getIngredientesNecesarios() {
        return ingredientesNecesarios;
    }

    public void setIngredientesNecesarios(HashMap<String, Integer> ingredientesNecesarios) {
        this.ingredientesNecesarios = ingredientesNecesarios;
    }
}
