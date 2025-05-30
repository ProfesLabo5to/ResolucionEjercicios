import java.time.LocalDateTime;

public class Llamada {
    private Empleado origen;
    private Empleado destino;
    private LocalDateTime fecha;
    private int duracionSegundos;

    public Llamada(Empleado origen, Empleado destino, int duracionSegundos) {
        this.origen = origen;
        this.destino = destino;
        this.duracionSegundos = duracionSegundos;
        this.fecha = LocalDateTime.now();
    }

    public Empleado getOrigen() {
        return origen;
    }

    public Empleado getDestino() {
        return destino;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public boolean esExterior() {
        return !origen.getPais().equals(destino.getPais());
    }

}