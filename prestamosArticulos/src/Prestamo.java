package prestamos;
import java.time.LocalDate;

public class Prestamo {
    private Prestar articulo;
    private int numeroSocio;
    private LocalDate fechaInicioPrestamo;
    private LocalDate fechaFinalPrestamo;

    public Prestamo(Prestar articulo, int numeroSocio, LocalDate fechaInicioPrestamo, LocalDate fechaFinalPrestamo) {
        this.articulo = articulo;
        this.numeroSocio = numeroSocio;
        this.fechaInicioPrestamo = fechaInicioPrestamo;
        this.fechaFinalPrestamo = fechaFinalPrestamo;
    }

    public Prestar getArticulo() {
        return articulo;
    }

    public void setArticulo(Prestar articulo) {
        this.articulo = articulo;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public LocalDate getFechaInicioPrestamo() {
        return fechaInicioPrestamo;
    }

    public void setFechaInicioPrestamo(LocalDate fechaInicioPrestamo) {
        this.fechaInicioPrestamo = fechaInicioPrestamo;
    }

    public LocalDate getFechaFinalPrestamo() {
        return fechaFinalPrestamo;
    }

    public void setFechaFinalPrestamo(LocalDate fechaFinalPrestamo) {
        this.fechaFinalPrestamo = fechaFinalPrestamo;
    }
}
