import java.util.HashMap;

public abstract class Diana {
    private String nombre;
    private Dificultad nivel;
    private HashMap<Integer, FranjaColor> puntaje;

    public Diana(){
        this.nombre = "";
        this.nivel = Dificultad.FACIL;
        this.puntaje = new HashMap<>();
    }

    public Diana(String nombre, Dificultad nivel, HashMap<Integer, FranjaColor> puntaje) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dificultad getNivel() {
        return nivel;
    }

    public void setNivel(Dificultad nivel) {
        this.nivel = nivel;
    }

    public HashMap<Integer, FranjaColor> getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(HashMap<Integer, FranjaColor> puntaje) {
        this.puntaje = puntaje;
    }

    public int cantPuntajes(){
        return this.puntaje.size();
    }

    abstract Double calcularArea();

    @Override
    public String toString() {
        return "Diana{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puntaje=" + puntaje +
                ", area= "+ calcularArea() +
                '}';
    }
}
