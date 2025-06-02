import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SistemaLlamadasTest {

    private Empleado empA;
    private Empleado empB;
    private Empleado empC;
    private Empleado empD;

    @BeforeEach
    void setUp() {
        empA = new Empleado("Ana",    "Pérez",   "11111111", "Argentina", "11-1234-0001");
        empB = new Empleado("Bruno",  "García",  "22222222", "Argentina", "11-1234-0002");
        empC = new Empleado("Carlos", "López",   "33333333", "Chile",     "56-9876-0003");
        empD = new Empleado("Diana",  "Martínez","44444444", "Uruguay",   "598-765-0004");
    }

    // ----------------------------
    // Tests para Empleado / Persona
    // ----------------------------



    @Test
    void testEsExteriorFalse() {
        // Misma país: Argentina → Argentina
        Llamada llamadaInterior = new Llamada(empA, empB, 50);
        assertFalse(llamadaInterior.esExterior());
    }

    @Test
    void testEsExteriorTrue() {
        // Diferentes países: Argentina → Chile
        Llamada llamadaExterior = new Llamada(empA, empC, 75);
        assertTrue(llamadaExterior.esExterior());
    }

    @Test
    void testRegistrarLlamadaIncrementaListaInterna() throws Exception {
        //TODO
    }


    @Test
    void testMostrarLlamadasDeSinLlamadas() {
        //TODO
    }

    @Test
    void testMostrarLlamadasDeConUnaLlamada() {
        //TODO
    }

    @Test
    void testMostrarLlamadasDeConVariasLlamadas() {
       //TODO
    }

    // ----------------------------
    // Tests para RegistroLlamada.rankingExterior()
    // ----------------------------

    @Test
    void testRankingExteriorSinLlamadasAlExterior() {
       //TODO
    }

    @Test
    void testRankingExteriorConUnaLlamadaExterior() {
        //TODO
    }

    @Test
    void testRankingExteriorOrdenCorrectoVariasLlamadas() {
        //TODO
    }
}
