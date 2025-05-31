package Pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Usuarios.Cliente;
import parque.ventas.Tiquete;

import java.util.List;
import java.util.ArrayList;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente(
                1,
                "Laura",
                22,
                1.68,
                58.5,
                new ArrayList<>(),
                "laura22",
                "claveSegura"
        );
    }

    @Test
    void testDatosBasicosCliente() {
        assertEquals(22, cliente.getEdad(), "La edad del cliente debería ser 22");
        assertEquals(1.68, cliente.getAltura(), "La altura del cliente debería ser 1.68");
        assertEquals(58.5, cliente.getPeso(), "El peso del cliente debería ser 58.5");
        assertEquals("laura22", cliente.getLogin(), "El login del cliente debería ser 'laura22'");
    }

    @Test
    void testCompraTiquete() {
        Tiquete tiquete = new Tiquete(101, 50000.0, 30, true, null, null, false, false);
        cliente.comprarTiquete(tiquete);
        List<Tiquete> tiquetes = cliente.getTiquetesComprados();
        assertEquals(1, tiquetes.size(), "Debería haber un tiquete comprado");
        assertEquals(101, tiquetes.get(0).getId(), "El ID del tiquete comprado debería ser 101");
    }

    @Test
    void testContraindicaciones() {
        cliente.setContraindicaciones(List.of("vértigo", "cardíaco"));
        List<String> lista = cliente.getContraindicaciones();
        assertTrue(lista.contains("vértigo"), "La lista de contraindicaciones debería contener 'vértigo'");
        assertTrue(lista.contains("cardíaco"), "La lista de contraindicaciones debería contener 'cardíaco'");
    }
}