package Campania;
import Dominio.Ave;
import Dominio.Mensajero;

public class PalomaMensajera extends Ave implements Mensajero {
    private boolean aprendioMapa;

    public PalomaMensajera(String color, String nombre, String especie, boolean aprendioMapa) {
        super(color, nombre, especie);
        this.aprendioMapa = aprendioMapa;
    }

    public boolean isAprendioMapa() {
        return aprendioMapa;
    }

    public void setAprendioMapa(boolean aprendioMapa) {
        this.aprendioMapa = aprendioMapa;
    }

    @Override
    public String enviarMensajeCampania(String texto) {
        if (!aprendioMapa) return "No se puede enviar el mensaje porque la paloma no aprendio el mapa.";
        return "Lanzando un papelito que dice: " + texto;
    }
}
