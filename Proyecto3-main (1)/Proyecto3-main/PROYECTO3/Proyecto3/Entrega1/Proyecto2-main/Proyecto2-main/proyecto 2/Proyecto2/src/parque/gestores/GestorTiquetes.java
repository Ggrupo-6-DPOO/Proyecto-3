package parque.gestores;

import Persistencia.ArchivoSerializable;
import parque.ventas.Tiquete;
import parque.ventas.TipoTiquete;

import java.util.*;

public class GestorTiquetes {
    private List<Tiquete> tiquetes;
    private ArchivoSerializable<Tiquete> archivo;
    private int contadorId;

    public GestorTiquetes() {
        this.tiquetes = new ArrayList<>();
        this.archivo = new ArchivoSerializable<>();
        this.contadorId = 1;
    }

    public Tiquete generarTiquete(double precio, int cupoMaximo, boolean esDeTemporada,
                                   TipoTiquete tipo, double descuento, boolean fastPass) {
        int id = contadorId++;
        Date fechaCompra = new Date();
        Tiquete nuevo = new Tiquete(id, precio, cupoMaximo, esDeTemporada, tipo, fechaCompra, descuento, fastPass);
        tiquetes.add(nuevo);
        return nuevo;
    }

    public boolean estaImpreso(int idTiquete) {
        for (Tiquete t : tiquetes) {
            if (t.getId() == idTiquete) {
                return !t.validarUso();
            }
        }
        return false;
    }

    public boolean confirmarReimpresion(int idTiquete) {
        // Aquí podrías implementar una lógica de confirmación con la GUI
        return true; 
    }

    public void marcarComoImpreso(int idTiquete) {
        for (Tiquete t : tiquetes) {
            if (t.getId() == idTiquete && t.validarUso()) {
                t.marcarUsado();
                break;
            }
        }
    }

    public void guardarTiquetes(String archivoNombre) {
        archivo.escribir(new ArrayList<>(tiquetes), archivoNombre);
    }

    public void cargarTiquetes(String archivoNombre) {
        List<Tiquete> cargados = archivo.leer(archivoNombre);
        if (cargados != null) {
            tiquetes = cargados;
            for (Tiquete t : tiquetes) {
                if (t.getId() >= contadorId) {
                    contadorId = t.getId() + 1;
                }
            }
        }
    }

    public List<Tiquete> getTiquetes() {
        return tiquetes;
    }
}
