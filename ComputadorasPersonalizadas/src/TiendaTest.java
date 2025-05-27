import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TiendaTest {

    private CPU cpu;
    private Entrada teclado;
    private Salida monitor;
    private Computadora computadora;
    private Tarjeta tarjeta;
    private Efectivo efectivo;
    private Persona persona;
    private Venta venta;
    private Sistema sistema;

    @BeforeEach
    void setUp() {
        cpu = new CPU("Intel", "i5", 100.0, 5);

        ArrayList<String> puertos = new ArrayList<>(Arrays.asList("USB-A"));
        ArrayList<String> conectores = new ArrayList<>(Arrays.asList("PS/2"));
        teclado = new Entrada("Logitech", "K120", 10.0, 2, puertos, conectores);
        monitor = new Salida("Dell", "U2419H", 150.0, 3, puertos);

        computadora = new Computadora(cpu, new ArrayList<>(Arrays.asList(teclado, monitor)));

        tarjeta = new Tarjeta(123456, "Titular", 999);
        efectivo = new Efectivo();

        persona = new Persona("Ana", "López", 12345678);
        venta = new Venta(persona, computadora, tarjeta);

        sistema = new Sistema();
    }

    @Test
    void testGettersComponente() {
        assertEquals("Intel", cpu.getFabricante());
        assertEquals("i5", cpu.getModelo());
        assertEquals(100.0, cpu.getPrecio());
        assertEquals(5, cpu.getStock());
    }

    @Test
    void testSettersComponente() {
        cpu.setFabricante("AMD");
        cpu.setModelo("Ryzen");
        cpu.setPrecio(200.0);
        cpu.setStock(8);

        assertEquals("AMD", cpu.getFabricante());
        assertEquals("Ryzen", cpu.getModelo());
        assertEquals(200.0, cpu.getPrecio());
        assertEquals(8, cpu.getStock());
    }

    @Test
    void testReducirStockComponente() {
        assertTrue(cpu.reducirStock(3));
        assertEquals(2, cpu.getStock());
    }

    @Test
    void testReducirStockInsuficienteComponente() {
        assertFalse(cpu.reducirStock(6)); // no alcanza el stock
        assertEquals(5, cpu.getStock());
    }


    @Test
    void testEfectivoSinRecargo() {
        double base = 50.0;
        assertEquals(base, efectivo.precioFinal(base));
    }

    @Test
    void testTarjetaConRecargo() {
        double base = 100.0;
        assertEquals(105.0, tarjeta.precioFinal(base));
    }



    @Test
    void testCalcularPrecioNetoYCantidadDispositivos() {
        // precio neto = 100 (CPU) + 10 (teclado) + 150 (monitor) = 260
        assertEquals(260.0, computadora.calcularPrecioNeto());

        assertEquals(1, computadora.cantidadDispositivosEntrada());
        assertEquals(1, computadora.cantidadDispositivosSalida());

        // prueba del conteo por clase
        assertEquals(1, computadora.cantidadDispositivos("Entrada"));
        assertEquals(1, computadora.cantidadDispositivos("Salida"));
    }

    @Test
    void testActualizarStockComputadora() {
        computadora.actualizarStock();
        // CPU de 5 a 4, teclado de 2 a 1, monitor de 3 a 2
        assertEquals(4, cpu.getStock());
        assertEquals(1, teclado.getStock());
        assertEquals(2, monitor.getStock());
    }


    @Test
    void testCalcularTotalConMedioDePago() {
        // base 260, con tarjeta *1.05 = 273
        assertEquals(273.0, venta.calcularTotalConMedioDePago());

        // con efectivo debería ser 260.0
        Venta ventaEfectivo = new Venta(persona, computadora, efectivo);
        assertEquals(260.0, ventaEfectivo.calcularTotalConMedioDePago());
    }

    @Test
    void testActualizarStockVenta() {
        venta.actualizarStock();
        // mismo efecto que computadora.actualizarStock()
        assertEquals(4, cpu.getStock());
        assertEquals(1, teclado.getStock());
        assertEquals(2, monitor.getStock());
    }

}
