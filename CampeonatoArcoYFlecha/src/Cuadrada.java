import java.util.HashMap;

public class Cuadrada extends Diana{
    private Double lado;

    public Cuadrada(String nombre, Dificultad nivel, HashMap<Integer, FranjaColor> puntaje, Double lado) {
        super(nombre, nivel, puntaje);
        this.lado = lado;
    }

    public Double getLado() {
        return lado;
    }

    public void setLado(Double lado) {
        this.lado = lado;
    }

    @Override
    Double calcularArea() {
        return Math.pow(this.lado, 2);
    }
}
