package Atracciones;

import Usuarios.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class atraccion implements Serializable {
    protected String nombre;
    protected String ubicacion;
    protected int cupoMaximo;
    protected int numMinEmpleados;
    protected NivelExclusividad exclusividad;
    public boolean estado; // true = activa, false = inactiva
    protected List<String> restricciones;
    
    public atraccion(String nombre, String ubicacion, int cupoMaximo, 
                    int numMinEmpleados, NivelExclusividad exclusividad) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.cupoMaximo = cupoMaximo;
        this.numMinEmpleados = numMinEmpleados;
        this.exclusividad = exclusividad;
        this.estado = true; // Por defecto activa
        this.restricciones = new ArrayList<>();
    }
    
    public atraccion(String string, boolean b) {
		// TODO Auto-generated constructor stub
	}

	public boolean verificarDisponibilidad() {
        return estado && cupoMaximo > 0;
    }
    
    public boolean esAptaPara(Cliente cliente) {
        // Verificación básica de disponibilidad
        return verificarDisponibilidad();
    }
    
    public void activar() {
        this.estado = true;
    }
    
    public void desactivar() {
        this.estado = false;
    }
    
    public void agregarRestriccion(String restriccion) {
        this.restricciones.add(restriccion);
    }
    
    public List<String> getRestricciones() {
        return new ArrayList<>(restricciones); // Copia defensiva
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public int getCupoMaximo() {
        return cupoMaximo;
    }
    
    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }
    
    public int getNumMinEmpleados() {
        return numMinEmpleados;
    }
    
    public void setNumMinEmpleados(int numMinEmpleados) {
        this.numMinEmpleados = numMinEmpleados;
    }
    
    public NivelExclusividad getExclusividad() {
        return exclusividad;
    }
    
    public void setExclusividad(NivelExclusividad exclusividad) {
        this.exclusividad = exclusividad;
    }
    
    public boolean isEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return nombre + "\t" + ubicacion + "\t" + cupoMaximo + "\t" + 
               numMinEmpleados + "\t" + exclusividad + "\t" + estado;
    }
}