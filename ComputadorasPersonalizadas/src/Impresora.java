import java.util.ArrayList;

public class Impresora extends Salida{
    private MetodoImpresion metodoImpresion;

    public Impresora(String fabricante, String modelo, double precioBase, int stock, ArrayList<String> puertos,MetodoImpresion metodoImpresion ) {
        super(fabricante, modelo, precioBase, stock, puertos);
        this.metodoImpresion = metodoImpresion;
    }

    public MetodoImpresion getMetodoImpresion() {
        return metodoImpresion;
    }

    public void setMetodoImpresion(MetodoImpresion metodoImpresion) {
        this.metodoImpresion = metodoImpresion;
    }
}
