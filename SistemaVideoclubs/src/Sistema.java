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
}
