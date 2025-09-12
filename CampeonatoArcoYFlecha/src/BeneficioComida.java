import java.util.HashSet;

public class BeneficioComida extends Beneficio implements BenefAcumulables{

    public BeneficioComida(String nombre, Creador creador, HashSet<Producto> comidas) {
        super(nombre, creador, comidas);
    }

    @Override
    public int aplicarDescuentoExtra() {
        return 4500;
    }
    @Override
    public int calcularPrecioFinal(Producto p) {
        return p.getPrecio() - aplicarDescuentoExtra();
    }
}
