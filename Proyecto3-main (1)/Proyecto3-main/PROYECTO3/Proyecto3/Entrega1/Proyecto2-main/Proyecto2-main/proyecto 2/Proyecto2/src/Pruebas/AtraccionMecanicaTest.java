package Pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Atracciones.AtraccionMecanica;
import Atracciones.NivelExclusividad;
import Usuarios.Cliente;

import java.util.Arrays;
import java.util.List;

class AtraccionMecanicaTest {

    private AtraccionMecanica atraccion;
    private Cliente clienteValido;
    private Cliente clienteConContraindicaciones;

    @BeforeEach
    void setUp() {
        atraccion = new AtraccionMecanica(
                "Montaña Rusa",
                "Zona A",
                20,
                2,
                NivelExclusividad.FAMILIAR,
                1.5,
                90.0,
                12,
                true
        );

        clienteValido = new Cliente("Carlos", 13, 1.60, 65.0, List.of());
        clienteConContraindicaciones = new Cliente("Ana", 20, 1.65, 60.0,
                Arrays.asList("cardíaco", "presión"));
    }

    @Test
    void testClienteAptoParaAtraccionExtrema() {
        assertTrue(atraccion.esAptaPara(clienteValido), "El cliente válido debería ser apto para la atracción extrema");
    }

    @Test
    void testClienteNoCumpleAltura() {
        clienteValido.setAltura(1.4);
        assertFalse(atraccion.esAptaPara(clienteValido), "El cliente no debería ser apto si no cumple con la altura mínima");
    }

    @Test
    void testClienteConContraindicacionMedica() {
        assertFalse(atraccion.esAptaPara(clienteConContraindicaciones), "El cliente con contraindicaciones médicas no debería ser apto");
    }

    @Test
    void testActualizarRestricciones() {
        atraccion.actualizarRestriccionesSeguridad(1.8, 80.0, 16);
        assertEquals(1.8, atraccion.getAlturaMinima(), "La altura mínima debería actualizarse correctamente");
        assertEquals(80.0, atraccion.getPesoMaximo(), "El peso máximo debería actualizarse correctamente");
        assertEquals(16, atraccion.getLimiteEdad(), "El límite de edad debería actualizarse correctamente");
    }
}