package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Servicios.LugarServicio;
import Servicios.TipoLugar;
import Usuarios.Empleado;
import Usuarios.RolEmpleado;
import Usuarios.Turno;

import java.util.List;

class LugarServicioTest {

    private LugarServicioMock servicio;
    private Empleado cajero;
    private Empleado operador;

    // Clase mock para probar LugarServicio
    static class LugarServicioMock extends LugarServicio {
        public LugarServicioMock() {
            super(TipoLugar.TIENDA);
            this.setNombre("Tienda Principal");
            this.setUbicacion("Zona D");
        }

        @Override
        public double calcularGanancias() {
            return 1000.0;
        }
    }

    @BeforeEach
    void setUp() {
        servicio = new LugarServicioMock();
        cajero = new Empleado("Juan", 100, RolEmpleado.CAJERO, List.of(), Turno.APERTURA, "Zona D", "juan", "123");
        operador = new Empleado("Luis", 101, RolEmpleado.OPERADOR_ATRACCIONES, List.of(), Turno.CIERRE, "Zona D", "luis", "123");
    }

    @Test
    void testAsignarEmpleadoValido() {
        servicio.asignarEmpleado(cajero);
        assertEquals(1, servicio.getEmpleadosAsignados().size(), "Debería haber un empleado asignado");
        assertTrue(servicio.getEmpleadosAsignados().contains(cajero), "El empleado asignado debería ser 'cajero'");
    }

    @Test
    void testAsignarEmpleadoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> servicio.asignarEmpleado(operador), "Debería lanzar una excepción al intentar asignar un empleado no válido");
    }

    @Test
    void testToStringYGetters() {
        String output = servicio.toString();
        assertTrue(output.contains("Tienda Principal"), "La salida debería incluir el nombre de la tienda");
        assertTrue(output.contains("Zona D"), "La salida debería incluir la ubicación de la tienda");
        assertEquals(TipoLugar.TIENDA, servicio.getTipo(), "El tipo de lugar debería ser TIENDA");
    }

    @Test
    void testCalcularGananciasMock() {
        assertEquals(1000.0, servicio.calcularGanancias(), "Las ganancias calculadas deberían ser 1000.0");
    }
}