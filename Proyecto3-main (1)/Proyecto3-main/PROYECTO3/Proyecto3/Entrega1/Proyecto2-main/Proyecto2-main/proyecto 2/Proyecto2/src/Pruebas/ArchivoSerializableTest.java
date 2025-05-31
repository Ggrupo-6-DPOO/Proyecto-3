package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Persistencia.ArchivoSerializable;
import Usuarios.Cliente;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ArchivoSerializableTest {

    @Test
    void testEscrituraYLecturaCliente() {
        String archivo = "clientes_test.ser";

        Cliente cliente = new Cliente(123, "Prueba", 25, 1.75, 70.0, List.of("vértigo"), "user", "pass");
        ArrayList<Cliente> listaGuardar = new ArrayList<>();
        listaGuardar.add(cliente);

        ArchivoSerializable<Cliente> archivoSerializable = new ArchivoSerializable<>();
        archivoSerializable.escribir(listaGuardar, archivo);

        ArrayList<Cliente> listaLeida = archivoSerializable.leer(archivo);

        assertNotNull(listaLeida, "La lista leída no debería ser nula");
        assertEquals(1, listaLeida.size(), "La lista leída debería contener un cliente");
        assertEquals("Prueba", listaLeida.get(0).getNombre(), "El nombre del cliente leído debería ser 'Prueba'");

        new File(archivo).delete(); // Limpiar archivo temporal
    }

    @Test
    void testLeerArchivoInexistente() {
        ArchivoSerializable<Cliente> archivoSerializable = new ArchivoSerializable<>();
        ArrayList<Cliente> lista = archivoSerializable.leer("archivo_que_no_existe.ser");
        assertNull(lista, "La lista leída de un archivo inexistente debería ser nula");
    }
}