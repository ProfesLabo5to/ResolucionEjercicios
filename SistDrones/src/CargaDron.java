import java.time.LocalDate;

public class CargaDron extends Dron{
    private int pesoCarga;
    public CargaDron(String modelo, LocalDate fechaAdquisicion, Bateria cargaBateria, Estado estado, int pesoCarga) {
        super(modelo, fechaAdquisicion, cargaBateria, estado);
        this.pesoCarga = pesoCarga;
    }

    @Override
    public boolean ejecutarMision(double latitudDestino, double longitudDestino) {
        double distancia = Distancia.calcularDistancia(Dron.getLatitudOrigen(),Dron.getLongitudOrigen(),latitudDestino,longitudDestino);
        if(distancia <=30 && getCargaBateria().getValor()>50){
            return true;
        }
        return false;
    }
}
