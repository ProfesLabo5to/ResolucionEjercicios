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
}
