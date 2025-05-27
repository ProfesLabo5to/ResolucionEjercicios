import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CPU cpu = new CPU("Intel", "i7-12700K", 35000, 10);
        ArrayList<String> puertosTeclado = new ArrayList<>();
        puertosTeclado.add("USB-A");
        puertosTeclado.add("USB-C");

        Entrada teclado = new Entrada("Logitech", "Teclado - K120", 2000, 15, puertosTeclado, new ArrayList<>());
        Entrada mouse  = new Entrada();
        Salida pantalla = new Salida();
        MetodoImpresion laser = new MetodoImpresion("laser");
        Impresora hp456 = new Impresora("HP", "HP456", 10000, 50, new ArrayList<>(),laser);

        ArrayList<Periferico> perifericosCompu = new ArrayList<>();
        perifericosCompu.add(teclado);
        perifericosCompu.add(mouse);
        perifericosCompu.add(pantalla);
        perifericosCompu.add(hp456);
        Computadora pc = new Computadora(cpu, perifericosCompu);
        Tarjeta pagoTarjeta = new Tarjeta();
        Persona cliente = new Persona("María", "Gómez", 1122334455);
        Venta venta = new Venta(cliente, pc, pagoTarjeta);

        System.out.println("Total a pagar: $" + venta.calcularTotalConMedioDePago());
        venta.actualizarStock();

        System.out.println("Entradas: " + venta.getComputadora().cantidadDispositivosEntrada());
        System.out.println("Salidas:  " + venta.getComputadora().cantidadDispositivosSalida());
    }

}