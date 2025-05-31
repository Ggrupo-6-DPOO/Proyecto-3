package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parque.ventas.Tiquete;
import parque.ventas.TipoTiquete;

import java.util.Date;

class TiqueteTest {

    private Tiquete tiquete;

    @BeforeEach
    void setUp() {
        tiquete = new Tiquete(
                1,
                60000.0,
                50,
                false,
                TipoTiquete.FAMILIAR,
                new Date(),
                5000.0,
                true
        );
    }

    @Test
    void testDatosBasicos() {
        assertEquals(60000.0, tiquete.getPrecio(), "El precio del tiquete debería ser 60000.0");
        assertEquals(5000.0, tiquete.getDescuento(), "El descuento del tiquete debería ser 5000.0");
        assertEquals(TipoTiquete.FAMILIAR, tiquete.getTipo(), "El tipo de tiquete debería ser FAMILIAR");
        assertTrue(tiquete.isFastPass(), "El tiquete debería tener FastPass activado");
    }

    @Test
    void testValidarUsoInicial() {
        assertTrue(tiquete.validarUso(), "El tiquete debería ser válido para su uso inicial");
    }

    @Test
    void testMarcarUsado() {
        tiquete.marcarUsado();
        assertFalse(tiquete.validarUso(), "El tiquete no debería ser válido después de ser marcado como usado");
    }

    @Test
    void testMostrarDetallesIncluyeFastPassYDescuento() {
        String detalles = tiquete.mostrarDetalles();
        assertTrue(detalles.contains("FastPass: Sí"), "Los detalles deberían incluir 'FastPass: Sí'");
        assertTrue(detalles.contains("Descuento: $5000.0"), "Los detalles deberían incluir el descuento de $5000.0");
    }
}