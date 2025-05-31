package Usuarios;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Usuario {
    private RolEmpleado rol;
    private List<String> capacitaciones;
    private Turno turno;
    private String lugarTrabajo;

    public Empleado(String nombre, int id, RolEmpleado rol, List<String> capacitaciones,
                    Turno turno, String lugarTrabajo, String login, String password) {
        super(nombre, id, login, password);
        this.setRol(rol);
        this.setCapacitaciones(capacitaciones != null ? capacitaciones : new ArrayList<>());
        this.turno = turno;
        this.lugarTrabajo = lugarTrabajo;
    }

    public void asignarTurno(Turno turno) {
        this.turno = turno;
    }

    public String consultarAsignacion() {
        return "Turno: " + turno + ", Lugar de trabajo: " + lugarTrabajo;
    }

	public RolEmpleado getRol() {
		return rol;
	}

	public void setRol(RolEmpleado rol) {
		this.rol = rol;
	}

	public List<String> getCapacitaciones() {
		return capacitaciones;
	}

	public void setCapacitaciones(List<String> capacitaciones) {
		this.capacitaciones = capacitaciones;
	}

	public void setLugarTrabajo(String nombre) {
		// TODO Auto-generated method stub
		
	}
}

