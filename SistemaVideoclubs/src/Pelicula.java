import java.util.ArrayList;

public class Pelicula {
    private String nombre;
    private String genero;
    private int duracion;
    private ArrayList<Persona> directores;
    private ArrayList<Persona> actores;
    private ArrayList<Persona> idiomasDisponibles;

    public Pelicula() {
        this.nombre = "";
        this.genero = "";
        this.duracion = 0;
        this.directores = new ArrayList<>();
        this.actores = new ArrayList<>();
        this.idiomasDisponibles = new ArrayList<>();
    }
    public Pelicula(String nombre, String genero, int duracion, ArrayList<Persona> directores, ArrayList<Persona> actores, ArrayList<Persona> idiomasDisponibles) {
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.directores = directores;
        this.actores = actores;
        this.idiomasDisponibles = idiomasDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public ArrayList<Persona> getDirectores() {
        return directores;
    }

    public void setDirectores(ArrayList<Persona> directores) {
        this.directores = directores;
    }

    public ArrayList<Persona> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Persona> actores) {
        this.actores = actores;
    }

    public ArrayList<Persona> getIdiomasDisponibles() {
        return idiomasDisponibles;
    }

    public void setIdiomasDisponibles(ArrayList<Persona> idiomasDisponibles) {
        this.idiomasDisponibles = idiomasDisponibles;
    }
}
