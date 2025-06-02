public class QR extends MetodoPago{

    public QR() {
        super();
    }
    public double precioFinal(double montoBase) {
        return montoBase * 0.5;
    }

}
