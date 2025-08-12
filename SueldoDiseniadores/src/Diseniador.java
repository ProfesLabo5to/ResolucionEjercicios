
import java.util.HashMap;
import java.util.Map;

public class Diseniador extends Persona {
    private Tipo tipo;

    private HashMap<Proyecto, Integer> proyectosAsignados; // valor con comision agregada

    public Diseniador() {
        super();
        this.tipo=Tipo.UI;
        this.proyectosAsignados= new HashMap<Proyecto, Integer>();
    }

    public Diseniador(String nombre, int edad, String apellido, String direccion, Tipo tipo, HashMap<Proyecto, Integer> proyectosAsignados) {
        super(nombre,  apellido, edad, direccion);
        this.tipo = tipo;
        this.proyectosAsignados = sumarComision(proyectosAsignados);
    }

    public HashMap<Proyecto, Integer> sumarComision(HashMap<Proyecto, Integer> proyectosAsignados){
        for (Map.Entry<Proyecto, Integer> p : proyectosAsignados.entrySet()) {
            p.setValue(p.getValue() + (p.getValue() * CreativoSinLimites.comisionesCreacion().get(tipo) / 100));
        }
        return proyectosAsignados;
    }
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public HashMap<Proyecto, Integer> getProyectosAsignados() {
        return proyectosAsignados;
    }
    public void agregarProyecto(Proyecto p){
        proyectosAsignados.put(p, CreativoSinLimites.agregameComision(this.tipo,p));
    }
    public void setProyectosAsignados(HashMap<Proyecto, Integer> proyectosAsignados) {
        this.proyectosAsignados = proyectosAsignados;
    }

    public int miSueldo(){
        int sueldo=0;
        for(Map.Entry<Proyecto,Integer> p:proyectosAsignados.entrySet()){
            sueldo+=p.getValue();
        }
        return sueldo;
    }
    public int cantidadDeProyectos(){
        return this.proyectosAsignados.size();
    }
    public int gananciaSinComision(Proyecto p){
        if (proyectosAsignados.containsKey(p)){
            return p.getPrecio();
        }
        return 0;
    }
    public void sueldoDiscriminado(){
        for(Map.Entry<Proyecto,Integer> p:proyectosAsignados.entrySet()){
            int comision=p.getValue()-this.gananciaSinComision(p.getKey());
            System.out.println("Nombre del proyecto: "+ p.getKey().getNombre()+ "  Cuanto ganó: "+ this.proyectosAsignados.get(p.getKey())+ " Comisión: "+ comision);
        }
    }
}
