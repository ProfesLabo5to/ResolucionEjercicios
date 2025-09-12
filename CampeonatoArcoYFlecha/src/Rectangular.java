import java.util.HashMap;

public class Rectangular extends Diana{
    private Double base;
    private Double altura;

    public Rectangular(String nombre, Dificultad nivel, HashMap<Integer, FranjaColor> puntaje, Double base, Double altura) {
        super(nombre, nivel, puntaje);
        this.base = base;
        this.altura = altura;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    Double calcularArea() {
        return this.base * this.altura;
    }
}
