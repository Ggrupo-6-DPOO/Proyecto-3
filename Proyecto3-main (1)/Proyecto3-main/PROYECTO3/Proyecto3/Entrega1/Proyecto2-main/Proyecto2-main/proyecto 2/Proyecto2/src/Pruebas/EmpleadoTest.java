package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Usuarios.Empleado;
import Usuarios.RolEmpleado;
import Usuarios.Turno;

import java.util.List;

class EmpleadoTest {

    private Empleado empleado;

    @BeforeEach
    void setUp() {
        empleado = new Empleado(
                "Camilo",
                301,
                RolEmpleado.OPERADOR_ATRACCIONES,
                List.of("Montaña Rusa", "Rápidos"),
                Turno.CIERRE,
                "Zona C",
                "camilo",
                "claveCamilo"
        );
    }

    @Test
    void testDatosBasicosEmpleado() {
        assertEquals("Camilo", empleado.getNombre(), "El nombre del empleado debería ser 'Camilo'");
        assertEquals(RolEmpleado.OPERADOR_ATRACCIONES, empleado.getRol(), "El rol del empleado debería ser 'OPERADOR_ATRACCIONES'");
        assertEquals("Zona C", empleado.consultarAsignacion().split(": ")[1], "La zona asignada debería ser 'Zona C'");
    }

    @Test
    void testAsignarTurno() {
        empleado.asignarTurno(Turno.APERTURA);
        assertEquals("Turno: APERTURA, Lugar de trabajo: Zona C", empleado.consultarAsignacion(), "La asignación debería reflejar el nuevo turno y la zona de trabajo");
    }

    @Test
    void testCapacitaciones() {
        List<String> lista = empleado.getCapacitaciones();
        assertTrue(lista.contains("Montaña Rusa"), "La lista de capacitaciones debería contener 'Montaña Rusa'");
        assertEquals(2, lista.size(), "La lista de capacitaciones debería tener un tamaño de 2");
    }
}