import Entidades.Participante;
import Entidades.Plato;
import Enumerables.Color;
import Excepciones.NoPuedeCocinarException;
import Participantes.Experto;
import Participantes.Intermedio;
import Participantes.Principiante;
import Platos.PlatoE;
import Platos.PlatoP;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class MasterChefApp {
    private HashSet<Participante> chefs;
    private HashSet<Plato> platos;

    public MasterChefApp(HashSet<Participante> chefs, HashSet<Plato> platos){
        this.chefs=chefs;
        this.platos=platos;
    }

    public HashSet<Participante> getChefs() {
        return chefs;
    }

    public void setChefs(HashSet<Participante> chefs) {
        this.chefs = chefs;
    }

    public HashSet<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(HashSet<Plato> platos) {
        this.platos = platos;
    }

    public static void main(String[] args) throws NoPuedeCocinarException {
        // Resolución del ejercicio con base del de Negri y Melgarejo.
        MasterChefApp sistema = new MasterChefApp(new HashSet<>(), new HashSet<>());

        String ingredienteLechuga = "Lechuga";
        String ingredienteTomate = "Tomate";
        String ingredienteZapallo = "Zapallo";

        Principiante p1 = new Principiante("Juancito", "Carlos", LocalDate.now(), "acá", Color.ROJO, new HashSet<>());
        p1.getIngredientesProhibidos().add(ingredienteZapallo);

        Intermedio i1 = new Intermedio("Carlitos", "Balá", LocalDate.now(), "Allá", Color.AZUL, new HashMap<>());
        i1.getStockIngredientes().put(ingredienteLechuga, 2);
        i1.getStockIngredientes().put(ingredienteTomate, 2);
        i1.getStockIngredientes().put(ingredienteZapallo, 2);

        Experto e1 = new Experto("Luciana", "Wahi", LocalDate.now(), "Allí", Color.VERDE);

        PlatoE plato1 = new PlatoE("Ensalada", new HashMap<>(), 80);
        PlatoP plato2 = new PlatoP("Plato prohibido", new HashMap<>(), 100);
        PlatoP plato3 = new PlatoP("Zapallo", new HashMap<>(), 20);

        plato1.getIngredientesNecesarios().put(ingredienteLechuga, 1);
        plato1.getIngredientesNecesarios().put(ingredienteTomate, 1);
        plato2.getIngredientesNecesarios().put(ingredienteZapallo, 1);
        plato3.getIngredientesNecesarios().put(ingredienteZapallo, 3);

        p1.prepararLugarDeTrabajo();
        i1.prepararLugarDeTrabajo();
        e1.prepararLugarDeTrabajo();

        try {
            System.out.println(p1.cocinarEntrada(plato1).getNombre());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            System.out.println(i1.cocinarPrincipal(plato2).getNombre());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            System.out.println(e1.cocinarEntrada(plato1).getNombre());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            System.out.println(e1.cocinarPrincipal(plato2).getNombre());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(i1.cocinarPrincipal(plato3).getNombre());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}