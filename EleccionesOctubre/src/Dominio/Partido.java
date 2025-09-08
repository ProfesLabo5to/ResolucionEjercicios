package Dominio;

import java.util.HashSet;

public class Partido {
    private String nombre;
    private String direccionOficinaCentral;
    private int cantidadAfiliados;
    private HashSet<Mensajero> mensajeros;

    public Partido(String nombre, String direccionOficinaCentral, int cantidadAfiliados) {
        this.nombre = nombre;
        this.direccionOficinaCentral = direccionOficinaCentral;
        this.cantidadAfiliados = cantidadAfiliados;
        this.mensajeros = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionOficinaCentral() {
        return direccionOficinaCentral;
    }

    public void setDireccionOficinaCentral(String direccionOficinaCentral) {
        this.direccionOficinaCentral = direccionOficinaCentral;
    }

    public HashSet<Mensajero> getMensajeros() {
        return mensajeros;
    }

    public void setMensajeros(HashSet<Mensajero> mensajeros) {
        this.mensajeros = mensajeros;
    }

    public int getCantidadAfiliados() {
        return cantidadAfiliados;
    }

    public void setCantidadAfiliados(int cantidadAfiliados) {
        this.cantidadAfiliados = cantidadAfiliados;
    }

    public boolean agregarMensajero(Mensajero mensajero){
        return mensajeros.add(mensajero);
    }

    public void hacerCampania(){
        String texto = "Vote por el partido para un mejor futuro";
        for(Mensajero m : mensajeros){
            m.enviarMensajeCampania(texto);
        }
    }
}