package prestamos;

import java.time.Year;

public class AudioLibro extends Publicacion{
    private int duracion;
    private int pesoArchivo;

    public AudioLibro(String titulo, Autor autor, Year anioPublicacion, int stock, int duracion, int pesoArchivo) {
        super(titulo, autor, anioPublicacion, stock);
        this.duracion = duracion;
        this.pesoArchivo = pesoArchivo;
    }

    public AudioLibro(String titulo, int duracion, int pesoArchivo) {
        super(titulo);
        this.duracion = duracion;
        this.pesoArchivo = pesoArchivo;
    }

    public AudioLibro(int duracion, int pesoArchivo) {
        this.duracion = duracion;
        this.pesoArchivo = pesoArchivo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getPesoArchivo() {
        return pesoArchivo;
    }

    public void setPesoArchivo(int pesoArchivo) {
        this.pesoArchivo = pesoArchivo;
    }

    @Override
    public String toString() {
        return "AudioLibro{" +
                "duracion=" + duracion +
                ", pesoArchivo=" + pesoArchivo +
                '}';
    }
}
