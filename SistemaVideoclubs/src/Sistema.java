import java.util.ArrayList;

public class Sistema {
    private ArrayList<Videoclub> videoclubs;

    public Sistema() {
        this.videoclubs = new ArrayList<>();
    }
    public Sistema(ArrayList<Videoclub> videoclubs) {
        this.videoclubs = videoclubs;
    }

    public ArrayList<Videoclub> getVideoclubs() {
        return videoclubs;
    }

    public void setVideoclubs(ArrayList<Videoclub> videoclubs) {
        this.videoclubs = videoclubs;
    }
    //punto a: ABM videoclub
    public void altaVideoclub(Videoclub estanteria){
        videoclubs.add(estanteria);
    }
    public void bajaVideoclub(Videoclub estanteria){
        videoclubs.remove(estanteria);
    }
    public void modificarVideoclub(Videoclub videoclubViejo, Videoclub videoclubNuevo){
        bajaVideoclub(videoclubViejo);
        altaVideoclub(videoclubNuevo);
    }

    //punto e: direcciones de videoclub que pertenecen a una columna en particular
    public ArrayList<String> direccionesVideoclubEnUnaComuna(int comuna){
        ArrayList<String> direccionesVideoclub = new ArrayList<>();
        for(Videoclub v: videoclubs){
            if(v.getComuna() == comuna){
                direccionesVideoclub.add(v.getDireccion());
            }
        }
        return direccionesVideoclub;
    }

    //punto g: videoclub con más peliculas
    public Videoclub videoclubConMasPeliculas(){
        Videoclub videoclubConMasPeliculas = new Videoclub();
        for (Videoclub v: videoclubs){
            if(v.cantidadDePeliculas()>=videoclubConMasPeliculas.cantidadDePeliculas()){
                videoclubConMasPeliculas = v;
            }
        }
        return videoclubConMasPeliculas;
    }
}
