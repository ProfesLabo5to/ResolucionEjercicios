import java.util.ArrayList;

public class Estanteria {
    private int numeroEstanteria;
    private ArrayList<Pelicula> peliculas;

    public Estanteria(int numeroEstanteria) {
        this.numeroEstanteria = numeroEstanteria;
        this.peliculas = new ArrayList<>();
    }
    public Estanteria(int numeroEstanteria, ArrayList<Pelicula> peliculas) {
        this.numeroEstanteria = numeroEstanteria;
        this.peliculas = peliculas;
    }

    public int getNumeroEstanteria() {
        return numeroEstanteria;
    }

    public void setNumeroEstanteria(int numeroEstanteria) {
        this.numeroEstanteria = numeroEstanteria;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    //punto a: ABM peliculas
    public void altaPelicula(Pelicula pelicula){
        peliculas.add(pelicula);
    }
    public void bajaPelicula(Pelicula pelicula){
        peliculas.remove(pelicula);
    }
    public void modificarPelicula(Pelicula peliculaVieja, Pelicula peliculaNueva){
        bajaPelicula(peliculaVieja);
        altaPelicula(peliculaNueva);
    }
}
