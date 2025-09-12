import java.util.HashSet;

public abstract class Beneficio {
    private String nombre;
    private Creador creador;

    private HashSet<Producto> productos;

    public Beneficio(String nombre, Creador creador, HashSet<Producto>productos) {
        this.nombre = nombre;
        this.creador = creador;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Creador getCreador() {
        return creador;
    }
    public void setCreador(Creador creador) {
        this.creador = creador;
    }

    public abstract int calcularPrecioFinal(Producto p);

    public void conocerPrecioConBeneficio(){
        for (Producto p : productos){
            System.out.println(p + " Precio con descuento: "+ calcularPrecioFinal(p));
        }
    }
}
