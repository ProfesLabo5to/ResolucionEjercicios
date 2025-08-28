// La idea de esta clase es guardar un historial así a l ahora de calcular el consumo se usa el valor del kwh en
// ese momento y no el valor actual ya que puede aumentar.
public class Consumo {
    private int consumo;
    private int precio;//va a ser precio por kw


    public Consumo(int consumo, int precio) {
        this.consumo = consumo;
        this.precio = precio;
    }
    public double getCosto(){
        double precioTotal=consumo*precio;
        return precioTotal;
    }
    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
