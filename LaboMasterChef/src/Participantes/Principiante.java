package Participantes;
import Entidades.*;
import Enumerables.*;
import Excepciones.NoPuedeCocinarException;
import Interfaces.Entrada;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import Platos.PlatoE;


public class Principiante extends Participante implements Entrada {
    private HashSet<String> ingredientesProhibidos;

    public Principiante(String nombre, String apellido, LocalDate fechaNacimiento, String localidad, Color equipo, HashSet<String> ingredientesProhibidos) {
        super(nombre, apellido, fechaNacimiento, localidad, equipo);
        this.ingredientesProhibidos = ingredientesProhibidos;
    }

    public HashSet<String> getIngredientesProhibidos() {
        return ingredientesProhibidos;
    }

    public void setIngredientesProhibidos(HashSet<String> ingredientesProhibidos) {
        this.ingredientesProhibidos = ingredientesProhibidos;
    }

    @Override
    public void prepararLugarDeTrabajo() {
        System.out.println("Ya guarde todos los elementos prohibidos y no voy a usar: ");
        for (String ingrediente : ingredientesProhibidos){
            System.out.println(ingrediente);
        }
    }

    @Override
    public PlatoE cocinarEntrada(PlatoE plato) throws NoPuedeCocinarException {
        for (Map.Entry <String, Integer> ingrediente : plato.getIngredientesNecesarios().entrySet()) {
            if (ingredientesProhibidos.contains(ingrediente.getKey())) {
                throw new NoPuedeCocinarException("Tiene un ingrediente que no puedo usar (Esta prohibido): " + ingrediente);
            }
        }
        System.out.println("Cocinando entrada...");
        return plato;
    }

    @Override
    public PlatoE servirEntrada(PlatoE plato) {
        System.out.println("Sirviendo plato...");
        return plato;
    }
}
