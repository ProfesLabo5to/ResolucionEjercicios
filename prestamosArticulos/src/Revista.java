package prestamos;
import java.time.LocalDate;
import java.time.Year;

public class Revista extends Publicacion implements Prestar{
    private String distribuidora;

    public Revista(String distribuidora) {
        super();
        this.distribuidora = distribuidora;
    }

    public Revista(String titulo, String distribuidora) {
        super(titulo);
        this.distribuidora = distribuidora;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    @Override
    public int multaPrestamo() {
        return 3500;
    }

    @Override
    public LocalDate darPrestamo() {
        if (super.getAnioPublicacion().isBefore(Year.of(2020))) {
            return LocalDate.now().plusDays(10);
        } else {
            return LocalDate.now().plusDays(3);

        }
    }

    @Override
    public String mensajePrestamo() {
        return "Si quiere tómelo prestado";
    }

    @Override
    public boolean extenderPrestamo() throws ExtenderPrestamoException {
       if (distribuidora.length()>10){
         return true;
        }
        throw new ExtenderPrestamoException("No es posible extender el prestamo");
    }

    @Override
    public String toString() {
        return "Revista{" +
                "distribuidora='" + distribuidora + '\'' +
                mensajePrestamo()+
                '}';
    }
}
