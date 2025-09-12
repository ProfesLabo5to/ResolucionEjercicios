import java.util.HashSet;

public class BeneficioTrago extends Beneficio{


    public BeneficioTrago(String nombre, Creador creador, HashSet<Producto> tragos) {
        super(nombre, creador, tragos);
    }

    @Override
    public int calcularPrecioFinal(Producto p) {
        return p.getPrecio();
    }
}
