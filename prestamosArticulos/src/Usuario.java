package prestamos;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class Usuario extends Persona{
    private  double creditoGanado;
    private String mail;
    private HashSet<Publicacion> historialLectura;
    private int numeroSocio;
    private HashMap<Prestar, Integer> publicacionesPrestadas;
    private HashSet<Prestamo> prestamosActivos;

    //TODO: Métodos necesarios para manter consistentes estas colecciones de arriba
    public Usuario(int numeroSocio) {
        this.numeroSocio = numeroSocio;
        this.historialLectura = new HashSet<>();
        this.publicacionesPrestadas = new HashMap<>();
        this.prestamosActivos = new HashSet<>();
    }

    public Usuario(String nombre, String apellido, int edad, String direccion, int numeroSocio) {
        super(nombre, apellido, edad, direccion);
        this.numeroSocio = numeroSocio;
        this.historialLectura = new HashSet<>();
        this.publicacionesPrestadas = new HashMap<>();
        this.prestamosActivos = new HashSet<>();
    }

    public Usuario(String nombre, String apellido, LocalDate fNacimiento, int numeroSocio) {
        super(nombre, apellido, fNacimiento);
        this.numeroSocio = numeroSocio;
        this.historialLectura = new HashSet<>();
        this.publicacionesPrestadas = new HashMap<>();
        this.prestamosActivos = new HashSet<>();
    }

    public Usuario(String nombre, String apellido, int numeroSocio) {
        super(nombre, apellido);
        this.numeroSocio = numeroSocio;
        this.historialLectura = new HashSet<>();
        this.publicacionesPrestadas = new HashMap<>();
        this.prestamosActivos = new HashSet<>();
    }

    public double getCreditoGanado() {
        return creditoGanado;
    }

    public void setCreditoGanado(double creditoGanado) {
        this.creditoGanado = creditoGanado;
    }

    @Override
    public String getMail() {
        return mail;
    }

    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }

    public HashSet<Publicacion> getHistorialLectura() {
        return historialLectura;
    }

    public void setHistorialLectura(HashSet<Publicacion> historialLectura) {
        this.historialLectura = historialLectura;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public HashMap<Prestar, Integer> getPublicacionesPrestadas() {
        return publicacionesPrestadas;
    }

    public void setPublicacionesPrestadas(HashMap<Prestar, Integer> publicacionesPrestadas) {
        this.publicacionesPrestadas = publicacionesPrestadas;
    }

    public HashSet<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(HashSet<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    public void realizarPrestamo (Publicacion p, Prestamo prestamo){
        Prestar publicacionPrestable = (Prestar) p;
        publicacionesPrestadas.put(publicacionPrestable,
                publicacionesPrestadas.getOrDefault(publicacionPrestable,
                        0)+1);
        historialLectura.add(p);
        prestamosActivos.add(prestamo);
    }

    public void validarCreditoPositivo() throws ExtenderPrestamoException{
        if (creditoGanado<0){
            throw new ExtenderPrestamoException("Sin crédito -No es posible extender el préstamo");
        }
    }

    public void validarPrestamosActivos() throws ExtenderPrestamoException{
        if (prestamosActivos.size()>1){
            throw  new ExtenderPrestamoException("No es posible extender el préstamo");
        }
    }
    public boolean extenderPrestamo(Prestamo p){
        try {
            validarCreditoPositivo();
            validarPrestamosActivos();
            p.getArticulo().extenderPrestamo();
            return true;
        } catch (ExtenderPrestamoException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void devolverPrestamo(Prestamo p){
        prestamosActivos.remove(p);

    }

    public void cargarMulta(int multa){
        creditoGanado -= multa;
    }
}
