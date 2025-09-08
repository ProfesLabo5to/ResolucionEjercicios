package Campania;
import Dominio.Dispositivo;
import Dominio.Mensajero;
import Dominio.CompaniaTelefonica;

public class TelefonoMovil extends Dispositivo implements Mensajero {
    private CompaniaTelefonica compania;
    private String numeroCelular;
    private boolean tieneCredito;

    public TelefonoMovil(String numeroSerie, String fabricante, String modelo, CompaniaTelefonica compania, String numeroCelular, boolean encendido, boolean tieneCredito) {
        super(numeroSerie, fabricante, modelo, encendido);
        this.compania = compania;
        this.numeroCelular = numeroCelular;
        this.tieneCredito = tieneCredito;
    }

    public CompaniaTelefonica getCompania() {
        return compania;
    }

    public void setCompania(CompaniaTelefonica compania) {
        this.compania = compania;
    }

    public boolean isTieneCredito() {
        return tieneCredito;
    }

    public void setTieneCredito(boolean tieneCredito) {
        this.tieneCredito = tieneCredito;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    @Override
    public String enviarMensajeCampania(String texto) {
        if (!(super.getEncendido() && tieneCredito)) return "Al telefono le falta credito o esta apagado.";
        return "Conectando con la antena más cercana: " + texto;
    }
}