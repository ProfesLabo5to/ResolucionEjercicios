import java.time.LocalDateTime;

public class Venta {
    private Persona cliente;
    private Computadora computadora;
    private MetodoPago pago;

    public Venta(Persona cliente, Computadora computadora, MetodoPago pago) {
        this.cliente = cliente;
        this.computadora = computadora;
        this.pago = pago;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Computadora getComputadora() {
        return computadora;
    }

    public void setComputadora(Computadora computadora) {
        this.computadora = computadora;
    }

    public MetodoPago getPago() {
        return pago;
    }

    public void setPago(MetodoPago pago) {
        this.pago = pago;
    }

    public double calcularTotalConMedioDePago() {
        double base = computadora.calcularPrecioNeto();
        return pago.precioFinal(base);
    }

    public void actualizarStock(){
        computadora.actualizarStock();
    }
}
