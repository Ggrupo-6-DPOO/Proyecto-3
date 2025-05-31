package Servicios;

import Usuarios.Empleado;
import Usuarios.RolEmpleado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class LugarServicios implements Serializable {
    protected String nombre;
    protected String ubicacion;
    private TipoLugar tipo;
    private List<Empleado> empleadosAsignados;

    // Constructor que recibe nombre, ubicación y tipo
    public LugarServicios(String nombre, String ubicacion, TipoLugar tipo) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.empleadosAsignados = new ArrayList<>();
    }

    // Método para asignar empleados con validación de rol
    public void asignarEmpleado(Empleado empleado) {
        if (empleado.getRol() == RolEmpleado.CAJERO || 
            empleado.getRol() == RolEmpleado.SERVICIO_GENERAL) {
            empleadosAsignados.add(empleado);
        } else {
            throw new IllegalArgumentException("Rol no válido para este servicio");
        }
    }

    // Método abstracto para calcular ganancias (debe implementarlo la subclase concreta)
    public abstract double calcularGanancias();

    // Getters y setters
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

    public TipoLugar getTipo() {
        return tipo;
    }

    public List<Empleado> getEmpleadosAsignados() {
        return new ArrayList<>(empleadosAsignados); // Retorna copia defensiva
    }

    @Override
    public String toString() {
        return nombre + "\t" + ubicacion + "\t" + tipo;
    }
}