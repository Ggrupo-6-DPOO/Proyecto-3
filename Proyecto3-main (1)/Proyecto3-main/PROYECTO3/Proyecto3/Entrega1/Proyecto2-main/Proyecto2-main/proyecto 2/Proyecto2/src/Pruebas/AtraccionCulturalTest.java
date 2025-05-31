package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Atracciones.AtraccionCultural;
import Atracciones.NivelExclusividad;
import Usuarios.Cliente;

import java.util.List;

class AtraccionCulturalTest {

    private AtraccionCultural atraccion;
    private Cliente menorNoAcomp;
    private Cliente menorAcomp;
    private Cliente adulto;

    @BeforeEach
    void setUp() {
        atraccion = new AtraccionCultural("Museo Interactivo", "Zona C", 40, 1, NivelExclusividad.FAMILIAR, 10, true);

        menorNoAcomp = new Cliente(1, "Nico", 9, 1.4, 35.0, List.of(), "nico", "123");
        menorNoAcomp.setAcompaniado(false);

        menorAcomp = new Cliente(2, "Sara", 9, 1.35, 32.0, List.of(), "sara", "123");
        menorAcomp.setAcompaniado(true);

        adulto = new Cliente(3, "Ana", 20, 1.65, 55.0, List.of(), "ana", "123");
    }

    @Test
    void testClienteMenorSinAcompanianteRechazado() {
        assertFalse(atraccion.esAptaPara(menorNoAcomp, "El cliente menor sin acompañante debería ser rechazado"));
    }

    @Test
    void testClienteMenorConAcompaniantePermitido() {
        assertTrue(atraccion.esAptaPara(menorAcomp, "El cliente menor con acompañante debería ser permitido"));
    }

    @Test
    void testClienteAdultoSiemprePermitido() {
        assertTrue(atraccion.esAptaPara(adulto, "El cliente adulto debería ser siempre permitido"));
    }

    @Test
    void testActualizarEdadMinimaValida() {
        atraccion.actualizarEdadMinima(12);
        assertEquals(12, atraccion.getEdadMinima(), "La edad mínima debería actualizarse correctamente a 12");
    }

    @Test
    void testActualizarEdadMinimaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> atraccion.actualizarEdadMinima(-5), "Actualizar la edad mínima a un valor negativo debería lanzar una excepción");
    }
}