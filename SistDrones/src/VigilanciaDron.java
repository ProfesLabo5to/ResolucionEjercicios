import java.time.LocalDate;

public class VigilanciaDron extends Dron {
    private int espacioAlmacenamiento;
    private static int espacioFoto=12;
    public VigilanciaDron(String modelo, LocalDate fechaAdquisicion, Bateria cargaBateria, Estado estado, int espacioAlmacenamiento) {
        super(modelo, fechaAdquisicion, cargaBateria, estado);
        this.espacioAlmacenamiento=espacioAlmacenamiento;
    }

    @Override
    public boolean ejecutarMision(double latitudDestino, double longitudDestino) {
        double distancia = Distancia.calcularDistancia(Dron.getLatitudOrigen(),Dron.getLongitudOrigen(),latitudDestino,longitudDestino);
        double cantFotosASacar = distancia / 2;
        double almacenamientoNecesario = cantFotosASacar*espacioFoto;
        return almacenamientoNecesario<=espacioAlmacenamiento;
    }
}
