import java.util.ArrayList;

public class Videoclub {
    private String direccion;
    private int codigoPostal;
    private int comuna;
    private ArrayList<Estanteria>  estanterias;

    public Videoclub() {
        this.direccion = "Juramento 2390";
        this.codigoPostal = 1430;
        this.comuna = 12;
        this.estanterias = new ArrayList<>();
    }
    public Videoclub(String direccion, int codigoPostal, int comuna, ArrayList<Estanteria> estanterias) {
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.comuna = comuna;
        this.estanterias = estanterias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }

    public ArrayList<Estanteria> getEstanterias() {
        return estanterias;
    }

    public void setEstanterias(ArrayList<Estanteria> estanterias) {
        this.estanterias = estanterias;
    }

    //punto a: ABM estanterias
    public void altaEstanteria(Estanteria estanteria){
        estanterias.add(estanteria);
    }
    public void bajaEstanteria(Estanteria estanteria){
        estanterias.remove(estanteria);
    }
    public void modificarEstanteria(Estanteria estanteriaVieja, Estanteria estanteriaNueva){
        bajaEstanteria(estanteriaVieja);
        altaEstanteria(estanteriaNueva);
    }

    //punto b
    public void nombreYEstanteriaPeliculaMayorDuracion(){
        ArrayList<Pelicula> peliculasMayorDuracionEnCadaEstanteria = new ArrayList<>();
        Pelicula peliculaMayorDuracion = new Pelicula();
        Estanteria estanteriaConLaPeliculaDeMayorDuracion = new Estanteria();
        //lleno el arraylist con la pelicula de mayor duracion por cada categoria.
        for(Estanteria e: estanterias){
            peliculasMayorDuracionEnCadaEstanteria.add(e.peliculaMayorDuracion());
        }
        //Dentro de mi array que ya tengo las peliculas mayores de cada estanteria, defino la de mayor duracion que,
        // en consecuencia, va a ser la de mayor duración del videoclub.
        //uso un for i ya que el indice va a ser lo que me permita saber en qué estanteria está y
        for(int i=0; i<peliculasMayorDuracionEnCadaEstanteria.size();i++){
            if(peliculasMayorDuracionEnCadaEstanteria.get(i).getDuracion()>peliculaMayorDuracion.getDuracion()){
                peliculaMayorDuracion = peliculasMayorDuracionEnCadaEstanteria.get(i);
                estanteriaConLaPeliculaDeMayorDuracion = estanterias.get(i);
            }
        }

        //Ya me quedó en las variables peliculaMayor y estanteriaCOn lo que yo queria. Ahora lo muestro.
        System.out.println("La pelicula de mayor duracion es: "+ peliculaMayorDuracion.mostrarInfo() + " en la estanterias numero: " + estanteriaConLaPeliculaDeMayorDuracion.getNumeroEstanteria());
    }

    //punto f: peliculas de duracion menor a un numero en el videoclub.
    // pongo duracion como parametro para no hardcodear y que sirva si quiero probar luego con otra duracion
    public ArrayList<Pelicula> peliculasDeDuracionMenorA(int duracion){
        ArrayList<Pelicula> peliculasDeDuracionMenorAUnParametro = new ArrayList<>();
        for (Estanteria e :estanterias){
            ArrayList<Pelicula> peliculasDeDuracionMenorDeUnaEstanteria = e.peliculasMenorAUnaDUracion(duracion);
            for(Pelicula p: peliculasDeDuracionMenorDeUnaEstanteria){
                peliculasDeDuracionMenorAUnParametro.add(p);
            }
        }
        return peliculasDeDuracionMenorAUnParametro;
    }

    //auxiliar punto g
    public int cantidadDePeliculas(){
        int sumaPeliculas=0;
        for(Estanteria e: estanterias){
            sumaPeliculas += e.getPeliculas().size();
        }
        return sumaPeliculas;
    }

    //punto h: peliculas de un determinado genero
    public void mostrarPeliculasPorGenero(String genero){
        for(Estanteria e: estanterias){
            for(Pelicula p : e.peliculasDeUnGeneroDeterminado(genero)){
                System.out.println(p.mostrarInfo());

            }
        }
    }
}
