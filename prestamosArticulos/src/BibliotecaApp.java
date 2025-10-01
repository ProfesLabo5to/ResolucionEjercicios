package prestamos;

import java.time.LocalDate;
import java.time.Year;
import java.util.HashMap;
import java.util.HashSet;

public class BibliotecaApp {
    private HashSet<Publicacion> publicaciones;
    private HashSet<Prestar> publicacionesAPrestamo;
    private HashSet<Prestamo> prestamos;
    private HashMap<Integer, Usuario> usuarioPorNumero;

    //TODO: Cambiar a excepciones personalizadas con los mensajes correspondientes
    //TODO: Llamar en el main a las funcionalidades
    public BibliotecaApp() {
        publicaciones = new HashSet<>();
        publicacionesAPrestamo = new HashSet<>();
        prestamos = new HashSet<>();
        usuarioPorNumero = new HashMap<>();
    }

    public HashSet<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(HashSet<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public HashSet<Prestar> getPublicacionesAPrestamo() {
        return publicacionesAPrestamo;
    }

    public void setPublicacionesAPrestamo(HashSet<Prestar> publicacionesAPrestamo) {
        this.publicacionesAPrestamo = publicacionesAPrestamo;
    }

    public HashSet<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(HashSet<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void agregarUsuario(Usuario u){
        usuarioPorNumero.put(u.getNumeroSocio(), u);
    }
    public void agregarPublicacion(Publicacion p){
        publicaciones.add(p);
        try{
            publicacionesAPrestamo.add((Prestar)p);
        }catch(Exception e){

        }
    }
    public Publicacion motorBusqueda(String nombre) throws NoTenemosElLibroException{
        for(Publicacion p:publicaciones){
            if(p.getTitulo().equals(nombre)){
                return p;
            }
        }
        throw new NoTenemosElLibroException("No tenemos el libro");
    }

    public boolean verificarPrestamo(Publicacion publicacion) throws Exception{
       if(!publicacionesAPrestamo.contains(publicacion)){
            throw new Exception("No se puede dar a prestamo");
       }
       return true;
    }
    public boolean verificarStock(Publicacion publicacion) throws Exception{
        if(publicacion.getStock()>0){
            return true;
        }
        throw new Exception("No hay suficiente stock");
    }
    public boolean validarDevueltoEnTiempoCorrecto(Prestamo p) throws PrestamoFueraDeFechaException{
        if(LocalDate.now().isEqual(p.getFechaFinalPrestamo()) || LocalDate.now().isBefore(p.getFechaFinalPrestamo())){
            return true;
        }
        throw new PrestamoFueraDeFechaException("Prestamo devuelto fuera de fecha");
    }

    public Prestamo agregarPrestamo(Publicacion p, Usuario u){
        try{
            verificarPrestamo(p);
            verificarStock(p);
            Prestamo prestamo = new Prestamo((Prestar) p,u.getNumeroSocio(), LocalDate.now(),((Prestar) p).darPrestamo());
            prestamos.add(prestamo);
            p.descontarStock();
            u.realizarPrestamo(p, prestamo);
            System.out.println("Prestamo agregado correctamente");
            return prestamo;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void devolverPrestamo(Prestamo p){
        Usuario u = usuarioPorNumero.get(p.getNumeroSocio());
        try{
            validarDevueltoEnTiempoCorrecto(p);
            u.devolverPrestamo(p);
        } catch(Exception e){
            System.out.println(e.getMessage());
            u.cargarMulta(p.getArticulo().multaPrestamo());
        }


    }

    public void extenderPrestamo(Prestamo p, Usuario u){
        if(prestamos.contains(p) && u.extenderPrestamo(p)){
            p.setFechaFinalPrestamo(p.getFechaFinalPrestamo().plusDays(5));
            System.out.println("Prestamo extendido");

        } else{
            System.out.println("Prestamo no  extendido");

        }

    }


    public static void main(String[] args) {

        Usuario u1 = new Usuario(34303);
        Usuario u2 = new Usuario(222332);
        // Usuario
        Usuario u = new Usuario("Ana", "Pérez", 1234);
        u.setMail("ana@example.com");
        u.setCreditoGanado(20000); // tiene crédito positivo

        BibliotecaApp app = new BibliotecaApp();
        Autor rowling = new Autor("J.K.", "Rowling");
        Autor asimov  = new Autor("Isaac", "Asimov");
        Autor vargas  = new Autor("Juan", "Vargas");

        // Publicaciones
        Libro hp1 = new Libro("Harry Potter y la Piedra Filosofal", true);

        hp1.setStock(8);

        Revista natGeo2019 = new Revista("National Geographic 2019", "NG Media");
        Revista natGeo2023 = new Revista("National Geographic 2023", "NG Media");
        AudioLibro fundacionAudio = new AudioLibro("Fundación (Audio)", asimov, Year.of(1951), 5, 420, 180);

        app.agregarPublicacion(hp1);
        app.agregarPublicacion(natGeo2019);
        app.agregarPublicacion(natGeo2023);
        app.agregarPublicacion(fundacionAudio);
        app.agregarUsuario(u1);
        app.agregarUsuario(u2);
        app.agregarUsuario(u);



        // Motor de búsqueda
        try {
            System.out.println(app.motorBusqueda("Harry Potter y la Piedra Filosofal"));
            System.out.println(app.motorBusqueda("Fundación (Audio)")); // no prestable, sin leyenda
            System.out.println(app.motorBusqueda("Inexistente")); // lanza “No tenemos el libro”
        } catch (NoTenemosElLibroException e) {
            System.out.println(e.getMessage());
        }

        Prestamo pLibro = app.agregarPrestamo(hp1, u);
        app.extenderPrestamo(pLibro, u);

        Prestamo pRev1 = app.agregarPrestamo(natGeo2019, u);
        // Extiende revista cuando NO hay otra revista activa
        app.extenderPrestamo(pRev1, u);

        // bloquea extensión por “otra revista activa”
        Prestamo pRev2 = app.agregarPrestamo(natGeo2023, u);
        // Intenta extender la primera revista ahora debería fallar
        app.extenderPrestamo(pRev1, u);
        app.devolverPrestamo(pLibro);

        System.out.println("Stock HP1: " + hp1.getStock());
        System.out.println("Stock NatGeo2019: " + natGeo2019.getStock());
        System.out.println("Crédito actual de " + u.getNombre() + ": " + u.getCreditoGanado());
    }
}
