import java.util.HashSet;

public class BeneficioGaseosa extends Beneficio implements BenefAcumulables{

    public BeneficioGaseosa(String nombre, Creador creador, HashSet<Producto> gaseosas) {
        super(nombre, creador, gaseosas);
    }

    @Override
    public int aplicarDescuentoExtra() {
        return 1000;
    }

    @Override
    public int calcularPrecioFinal(Producto p) {
        return p.getPrecio() - aplicarDescuentoExtra();
    }
}
