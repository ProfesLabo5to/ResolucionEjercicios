package prestamos;

import java.time.LocalDate;

public interface Prestar {
    int multaPrestamo();
    LocalDate darPrestamo();//va a retornar la fecha de devolucion
    String mensajePrestamo();
    boolean extenderPrestamo() throws ExtenderPrestamoException;
}
