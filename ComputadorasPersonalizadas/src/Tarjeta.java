public class Tarjeta extends MetodoPago{
    private int numeroTarjeta;
    private String titular;
    private int codigoSeguridad;

    public Tarjeta(int numeroTarjeta, String titular, int codigoSeguridad) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.codigoSeguridad = codigoSeguridad;
    }
    public Tarjeta() {
        this.numeroTarjeta = 2222320;
        this.titular = "AAAAAA";
        this.codigoSeguridad = 323;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    @Override
    public double precioFinal(double montoBase) {
        return montoBase * 1.05;
    }
}
