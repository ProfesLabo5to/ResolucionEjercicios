package prestamos;

import java.time.LocalDate;

public class Libro extends Publicacion implements Prestar{
    private boolean esSaga;


    public Libro(boolean esSaga) {
        super();
        this.esSaga = esSaga;
    }

    public Libro(String titulo, boolean esSaga) {
        super(titulo);
        this.esSaga = esSaga;
    }

    public boolean isEsSaga() {
        return esSaga;
    }

    public void setEsSaga(boolean esSaga) {
        this.esSaga = esSaga;
    }

    @Override
    public int multaPrestamo() {
        return 7500;
    }

    @Override
    public LocalDate darPrestamo() {
        return LocalDate.now().plusDays(15);
    }

    @Override
    public String mensajePrestamo() {
        return "Si quiere tómelo prestado";
    }

    @Override
    public boolean extenderPrestamo() throws ExtenderPrestamoException {
       if (getStock()>5){
           return true;
       }
       throw new ExtenderPrestamoException("No es posible extender el prestamo");
    }

    @Override
    public String toString() {
        return "Libro{" +
                "esSaga=" + esSaga +
                mensajePrestamo()+
                '}';
    }
}
