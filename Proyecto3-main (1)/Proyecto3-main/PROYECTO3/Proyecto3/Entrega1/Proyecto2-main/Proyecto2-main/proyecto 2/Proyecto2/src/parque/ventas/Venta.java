package parque.ventas;

import Usuarios.Cliente;
import Usuarios.Empleado;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {
    private String nombre; // o idVenta
    private Date fecha;
    private Empleado empleado;
    private Cliente cliente;
    private List<Tiquete> tiquetesVendidos;

    // Constructor
    public Venta(String nombre, Date fecha, Empleado empleado, Cliente cliente) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.setEmpleado(empleado);
        this.cliente = cliente;
        this.tiquetesVendidos = new ArrayList<>();
    }

    public void registrarVenta() {
        // Simula la lógica para registrar en base de datos o sistema
        System.out.println("Venta registrada: " + nombre + " - " + fecha);
    }

    public void agregarTiquete(Tiquete tiquete) {
        tiquetesVendidos.add(tiquete);
        cliente.getTiquetesComprados().add(tiquete); // vincula el tiquete al cliente
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Tiquete t : tiquetesVendidos) {
            total += t.validarUso() ? t.getPrecio() - t.getDescuento() : 0;
        }
        return total;
    }

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

    // Getters y setters si los necesitas
}
