package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Atracciones.Atraccion;
import Atracciones.NivelExclusividad;

class AtraccionTest {

    private Atraccion atraccion;

    @BeforeEach
    void setUp() {
        atraccion = new Atraccion("Casa del Terror", "Zona A", 30, 3, NivelExclusividad.DIAMANTE);
    }

    @Test
    void testDisponibilidadInicial() {
        assertTrue(atraccion.verificarDisponibilidad(), "La atracción debería estar disponible inicialmente");
    }

    @Test
    void testDesactivarAtraccion() {
        atraccion.desactivar();
        assertFalse(atraccion.verificarDisponibilidad(), "La atracción debería estar desactivada después de llamar a desactivar()");
    }

    @Test
    void testAgregarYLeerRestricciones() {
        atraccion.agregarRestriccion("No apto para menores de 10");
        assertEquals(1, atraccion.getRestricciones().size(), "Debería haber una restricción agregada");
        assertTrue(atraccion.getRestricciones().contains("No apto para menores de 10"), "La restricción debería estar presente en la lista");
    }

    @Test
    void testToStringIncluyeDatos() {
        String salida = atraccion.toString();
        assertTrue(salida.contains("Casa del Terror"), "La salida debería incluir el nombre de la atracción");
        assertTrue(salida.contains("DIAMANTE"), "La salida debería incluir el nivel de exclusividad");
    }
}