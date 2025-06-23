import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //Agregar mas cosas al main
        CargaDron c1 = new CargaDron("d", LocalDate.now(), Bateria.CIEN,Estado.INACTIVO,20);
        CargaDron c4 = new CargaDron("d", LocalDate.now(), Bateria.CIEN,Estado.INACTIVO,20);
        VigilanciaDron c5 = new VigilanciaDron("d", LocalDate.now(), Bateria.TREINTA,Estado.INACTIVO,20);
        System.out.println(Dron.getContador());
        c5.recargarBateria();
        System.out.println(c5.getCargaBateria());
        c5.recargarBateria();
        System.out.println(c5.getCargaBateria());
    }
}