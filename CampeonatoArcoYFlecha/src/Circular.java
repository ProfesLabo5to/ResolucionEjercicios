import java.util.HashMap;

public class Circular extends Diana{
    private Double radio;

    public Circular(String nombre, Dificultad nivel, HashMap<Integer, FranjaColor> puntaje, Double radio) {
        super(nombre, nivel, puntaje);
        this.radio = radio;
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    Double calcularArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }
}
