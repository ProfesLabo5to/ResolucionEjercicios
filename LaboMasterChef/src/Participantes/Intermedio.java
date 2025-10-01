package Participantes;
import Entidades.*;
import Enumerables.*;
import Excepciones.NoPuedeCocinarException;
import Interfaces.Principal;
import Platos.PlatoP;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Intermedio extends Participante implements Principal {
    private HashMap<String, Integer> stockIngredientes;

    public Intermedio(String nombre, String apellido, LocalDate fechaNacimiento, String localidad, Color equipo, HashMap<String, Integer> stockIngredientes) {
        super(nombre, apellido, fechaNacimiento, localidad, equipo);
        this.stockIngredientes = stockIngredientes;
    }

    public HashMap<String, Integer> getStockIngredientes() {
        return stockIngredientes;
    }

    public void setStockIngredientes(HashMap<String, Integer> stockIngredientes) {
        this.stockIngredientes = stockIngredientes;
    }

    @Override
    public void prepararLugarDeTrabajo() {
        System.out.print("Mi stock a utilizar es de: ");
        for(String ingrediente : stockIngredientes.keySet()){
            if (stockIngredientes.get(ingrediente) > 1){
                System.out.println(ingrediente);
            }
        }
    }

    @Override
    public PlatoP cocinarPrincipal(PlatoP plato) throws NoPuedeCocinarException {
        for (Map.Entry <String, Integer> ingrediente : plato.getIngredientesNecesarios().entrySet()) {
            if (!stockIngredientes.containsKey(ingrediente.getKey()) || stockIngredientes.get(ingrediente.getKey()) <= 0) {
                throw new NoPuedeCocinarException("No te alcanza");
            }
        }
        // Descontar del stock
        for (Map.Entry<String, Integer> ingrediente : plato.getIngredientesNecesarios().entrySet()) {
            String nombreIngrediente = ingrediente.getKey();
            int cantidadNecesaria = ingrediente.getValue();

            stockIngredientes.put(nombreIngrediente, stockIngredientes.get(nombreIngrediente) - cantidadNecesaria);
        }
        System.out.println("Cocinando plato principal...");
        return plato;
    }

    @Override
    public PlatoP servirPrincipal(PlatoP plato){
        System.out.println("Sirviendo plato...");
        return plato;
    }
}
