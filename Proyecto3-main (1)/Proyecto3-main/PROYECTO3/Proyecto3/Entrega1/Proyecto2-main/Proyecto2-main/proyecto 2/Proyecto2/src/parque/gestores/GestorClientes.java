package parque.gestores;

import Persistencia.ArchivoSerializable;
import Usuarios.Cliente;
import parque.ventas.Tiquete;

import java.util.ArrayList;
import java.util.List;

public class GestorClientes {
    private List<Cliente> clientes;
    private ArchivoSerializable<Cliente> archivo;

    public GestorClientes() {
        this.clientes = new ArrayList<>();
        this.archivo = new ArchivoSerializable<>();
    }

    public void registrarCliente(Cliente cliente) {
        if (cliente != null && !clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    public Cliente buscarClientePorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void comprarTiquete(int idCliente, Tiquete tiquete) {
        Cliente cliente = buscarClientePorId(idCliente);
        if (cliente != null && tiquete != null) {
            cliente.comprarTiquete(tiquete);
        }
    }

    public List<Tiquete> consultarTiquetesCliente(int idCliente) {
        Cliente cliente = buscarClientePorId(idCliente);
        if (cliente != null) {
            return cliente.consultarTiquetes();
        }
        return new ArrayList<>();
    }

    public void guardarClientes(String archivoNombre) {
        archivo.escribir(new ArrayList<>(clientes), archivoNombre);
    }

    public void cargarClientes(String archivoNombre) {
        List<Cliente> cargados = archivo.leer(archivoNombre);
        if (cargados != null) {
            clientes = cargados;
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
