import java.util.ArrayList;

public class BancoNacion {
    private String direccion;
    private boolean tieneCajerosAutomaticos; //acá va lo que quieran. En el main no especificaba
    private boolean tieneAscensor; //acá va lo que quieran. En el main no especificaba

    private ArrayList<Persona> trabajadores;

    public BancoNacion(String direccion, boolean tieneCajerosAutomaticos, boolean tieneAscensor) {
        this.direccion = direccion;
        this.tieneCajerosAutomaticos = tieneCajerosAutomaticos;
        this.tieneAscensor = tieneAscensor;
        this.trabajadores = new ArrayList<>(); //Importante definirlo vacio. Quiere decir que al crear un banco no tengo ningún trabajador
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isTieneCajerosAutomaticos() {
        return tieneCajerosAutomaticos;
    }

    public void setTieneCajerosAutomaticos(boolean tieneCajerosAutomaticos) {
        this.tieneCajerosAutomaticos = tieneCajerosAutomaticos;
    }

    public boolean isTieneAscensor() {
        return tieneAscensor;
    }

    public void setTieneAscensor(boolean tieneAscensor) {
        this.tieneAscensor = tieneAscensor;
    }

    public ArrayList<Persona> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Persona> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public void agregarTrabajador(Persona trabajador){
        trabajadores.add(trabajador);
    }

    public void cantidadTrabajadores(){
        System.out.println("La cantidad de trabajadores es: "+trabajadores.size());
    }

    public Persona empleadoMayorAntiguedad(){
        Persona trabajadorMayorAntiguedad = new Persona(); //Esto lo puedo usar teniendo en cuenta que en el constructor por defecto le pongo de fecha de ingreso hoy, por ende, la antiguedad va a ser 0
        for (Persona trabajador: trabajadores) {
            // (trabajador.antiguedad() > trabajadorMayorAntiguedad.antiguedad()) ? trabajadorMayorAntiguedad = trabajador;
           if (trabajador.antiguedad() >= trabajadorMayorAntiguedad.antiguedad()){ //Ahora les pregunto a ustedes, por qué el >=? Es lo mismo que este el igual o no? Cambia algo?
               trabajadorMayorAntiguedad = trabajador;
           }
        }
        return trabajadorMayorAntiguedad;
    }
}
