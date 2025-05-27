import java.util.ArrayList;

public class Estanteria {
    private int numeroEstanteria;
    private ArrayList<Pelicula> peliculas;

    public Estanteria() {
        this.numeroEstanteria = -1;
        this.peliculas = new ArrayList<>();
    }
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

    //Lo uso como método auxiliar del punto b y retorna la pelicula de mayor duracion en esa estanteria
    public Pelicula peliculaMayorDuracion(){
        Pelicula peliculaMayorDuracion = new Pelicula();
        for (Pelicula p: peliculas){
            if(p.getDuracion()>=peliculaMayorDuracion.getDuracion()){
                peliculaMayorDuracion = p;
            }
        }
        return peliculaMayorDuracion;
    }

    //punto d: directores que están en más de una pelicula
    public ArrayList<Persona> directoresRepetidosEnPeliculas(){
        ArrayList<Persona> directoresTotales = new ArrayList<>();
        ArrayList<Persona> directoresRepetidos = new ArrayList<>();
        for(Pelicula p:peliculas){
            //agrego los directores de cada pelicula a directores totales
            for(Persona director : p.getDirectores() ){
                //Si ya lo recorri una vez y todavia no lo marqué como repetido, es un director repetido
                if(directoresTotales.contains(director) && !directoresRepetidos.contains(director)){
                    directoresRepetidos.add(director);
                }else { //es la primera vez que veo ese director
                    directoresTotales.add(director);
                }
            }
        }
        return directoresRepetidos;
    }

    //auxiliar para el punto f que me dice la pelicula de duracion menor a 90 minutos en la estantteria
    public ArrayList<Pelicula> peliculasMenorAUnaDUracion(int duracion){
        ArrayList<Pelicula> peliculasMenorAUnaDUracion= new ArrayList<>();
        for(Pelicula p: peliculas){
            if(p.getDuracion()<duracion){
                peliculasMenorAUnaDUracion.add(p);
            }
        }
        return  peliculasMenorAUnaDUracion;
    }

    public ArrayList<Pelicula> peliculasDeUnGeneroDeterminado(String genero){
        ArrayList<Pelicula> peliculasDeUnGenero = new ArrayList<>();
        for(Pelicula p: peliculas){
            if(p.getGenero().equals(genero)){
                peliculasDeUnGenero.add(p);
            }
        }
        return peliculasDeUnGenero;
    }
}
