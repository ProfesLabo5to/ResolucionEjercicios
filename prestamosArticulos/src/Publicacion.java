package prestamos;
import java.time.Year;

public abstract class Publicacion {
    private String titulo;
    private Autor autor;
    private Year anioPublicacion;
    private int stock;

    public Publicacion(String titulo, Autor autor, Year anioPublicacion, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.stock = stock;
    }

    public Publicacion(String titulo) {
        this.titulo = titulo;
    }

    public Publicacion() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Year getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Year anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void descontarStock(){
        stock--;
    }
}
