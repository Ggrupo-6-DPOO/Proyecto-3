package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Usuarios.Administrador;
import Usuarios.Empleado;
import Usuarios.RolEmpleado;
import Usuarios.Turno;
import Atracciones.AtraccionMecanica;
import Atracciones.NivelExclusividad;
import Servicios.LugarServicio;
import Servicios.Taquilla;

import java.util.List;

class AdministradorTest {

    private Administrador admin;
    private AtraccionMecanica atraccion;
    private LugarServicio lugar; // Cambié 'LugarServicios' a 'LugarServicio'
    private Empleado empleado;

    @BeforeEach
    void setUp() {
        admin = new Administrador("Luis", 999, List.of("GESTION_ATRACCIONES", "GESTION_EMPLEADOS"), "luisAdmin", "admin123");

        atraccion = new AtraccionMecanica("Rápidos", "Zona B", 20, 2, NivelExclusividad.FAMILIAR, 1.2, 100.0, 10, false);

        lugar = new Taquilla("Taquilla Norte");

        empleado = new Empleado("Marta", 203, RolEmpleado.CAJERO, List.of(), Turno.APERTURA, "Zona B", "marta", "clave123");
    }

    @Test
    void testGestionarAtraccion() {
        admin.gestionarAtraccion(atraccion, false);
        assertFalse(atraccion.isEstado()); // Cambié 'estado' a 'isEstado()' asumiendo que es un método getter

        admin.gestionarAtraccion(atraccion, true);
        assertTrue(atraccion.isEstado()); // Cambié 'estado' a 'isEstado()' asumiendo que es un método getter
    }

    @Test
    void testAsignarEmpleado() {
        admin.asignarEmpleado(empleado, lugar);
        assertTrue(lugar.getEmpleados().contains(empleado));
    }

    @Test
    void testVerificarPermisos() {
        assertTrue(admin.tienePermiso("GESTION_ATRACCIONES"));
        assertFalse(admin.tienePermiso("MODIFICAR_TICKETS")); // Cambié 'TIQUETES' a 'TICKETS' para mantener consistencia en el idioma
    }
}