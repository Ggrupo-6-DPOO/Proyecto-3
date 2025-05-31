package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parque.ventas.Tiquete;
import parque.ventas.TipoTiquete;
import parque.ventas.Venta;
import Usuarios.Cliente;
import Usuarios.Empleado;
import Usuarios.RolEmpleado;
import Usuarios.Turno;

import java.util.Date;
import java.util.List;

class VentaTest {

    private Venta venta;
    private Cliente cliente;
    private Empleado empleado;

    @BeforeEach
    void setUp() {
        cliente = new Cliente(101, "Lucía", 30, 1.65, 60.0, List.of(), "lucia30", "pass123");
        empleado = new Empleado(201, "Mario", RolEmpleado.CAJERO, Turno.APERTURA, List.of(), "marioC", "clave123");
        venta = new Venta("Venta001", new Date(), empleado, cliente);
    }

    @Test
    void testAgregarTiquete() {
        Tiquete tiquete = new Tiquete(1, 40000.0, 20, false, TipoTiquete.ORO, new Date(), 5000.0, false);
        venta.agregarTiquete(tiquete);

        assertEquals(1, cliente.getTiquetesComprados().size(), "El cliente debería tener un tiquete comprado");
        assertEquals(40000.0, venta.calcularTotal(), "El total de la venta debería ser 40000.0");
    }

    @Test
    void testCalcularTotalConDescuento() {
        Tiquete t1 = new Tiquete(1, 50000.0, 30, false, TipoTiquete.FAMILIAR, new Date(), 10000.0, true);
        Tiquete t2 = new Tiquete(2, 30000.0, 30, false, TipoTiquete.BASICO, new Date(), 0.0, false);

        venta.agregarTiquete(t1);
        venta.agregarTiquete(t2);

        double totalEsperado = (50000.0 - 10000.0) + 30000.0;
        assertEquals(totalEsperado, venta.calcularTotal(), "El total calculado debería ser igual al total esperado");
    }

    @Test
    void testRegistrarVentaOutput() {
        venta.registrarVenta();
        // Este test solo verifica que no haya excepciones en el método registrarVenta
        assertTrue(true, "El método registrarVenta debería ejecutarse sin lanzar excepciones");
    }
}