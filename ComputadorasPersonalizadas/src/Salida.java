import java.util.ArrayList;

public class Salida extends Periferico{
    public Salida(String fabricante, String modelo, double precioBase, int stock, ArrayList<String> puertos) {
        super(fabricante, modelo, precioBase, stock, puertos);
    }
    public Salida() {
        super();
    }
}
