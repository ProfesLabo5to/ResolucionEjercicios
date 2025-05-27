public class Efectivo extends MetodoPago{
    @Override
    public double precioFinal(double montoBase) {
        return montoBase;
    }
}
