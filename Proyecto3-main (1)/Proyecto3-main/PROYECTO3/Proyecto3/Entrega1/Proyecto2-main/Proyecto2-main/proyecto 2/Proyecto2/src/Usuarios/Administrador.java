package Usuarios;

import java.io.Serializable;

import java.util.List;
import Atracciones.atraccion;
import Servicios.LugarServicios;

public class Administrador extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<String> permisos;

    public Administrador(String nombre, int id, List<String> permisos, 
                         String login, String password) {
        super(nombre, id, login, password);
        this.permisos = permisos;
    }

    public void gestionarAtraccion(atraccion atraccion, boolean activar) {
        atraccion.setEstado(activar); // Usamos método setter en vez de acceso directo
    }

    public void asignarEmpleado(Empleado empleado, LugarServicios lugar) {
        lugar.asignarEmpleado(empleado);
    }

    public boolean tienePermiso(String permiso) {
        return permisos.contains(permiso);
    }
}


