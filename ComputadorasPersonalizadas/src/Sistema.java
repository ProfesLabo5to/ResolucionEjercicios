import java.util.ArrayList;

public class Sistema {
    private ArrayList<Venta> computadorasVendidas;

    public Sistema(ArrayList<Venta> computadorasVendidas) {
        this.computadorasVendidas = computadorasVendidas;
    }
    public Sistema() {
        this.computadorasVendidas = new ArrayList<>();
    }

    public ArrayList<Venta> getComputadorasVendidas() {
        return computadorasVendidas;
    }

    public void setComputadorasVendidas(ArrayList<Venta> computadorasVendidas) {
        this.computadorasVendidas = computadorasVendidas;
    }

    public void agregarVenta(Venta v){
        computadorasVendidas.add(v);
    }
}
