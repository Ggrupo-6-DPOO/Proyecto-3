package Servicios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import parque.ventas.Tiquete;
import parque.ventas.Venta;

public class Taquilla extends LugarServicios implements Serializable {
    private int numeroTaquilla;
    private boolean aceptaTarjeta;
    private List<Venta> ventasRealizadas;
    private Date fechaApertura;
    private Date fechaCierre;

    // Constructor corregido
    public Taquilla(String nombre, String ubicacion, int numeroTaquilla, boolean aceptaTarjeta) {
        super(nombre, ubicacion, TipoLugar.TAQUILLA); // Llamada correcta al constructor de LugarServicios
        this.numeroTaquilla = numeroTaquilla;
        this.aceptaTarjeta = aceptaTarjeta;
        this.ventasRealizadas = new ArrayList<>();
        this.fechaApertura = new Date(); // Por defecto se asigna la fecha actual
    }

    public void registrarVenta(Venta venta) {
        ventasRealizadas.add(venta);
    }

    public void cerrarTaquilla() {
        this.fechaCierre = new Date();
    }

    @Override
    public double calcularGanancias() {
        double total = 0.0;
        for (Venta venta : ventasRealizadas) {
            total += venta.calcularTotal();
        }
        return total;
    }

    // Getters y Setters
    public int getNumeroTaquilla() {
        return numeroTaquilla;
    }

    public void setNumeroTaquilla(int numeroTaquilla) {
        this.numeroTaquilla = numeroTaquilla;
    }

    public boolean isAceptaTarjeta() {
        return aceptaTarjeta;
    }

    public void setAceptaTarjeta(boolean aceptaTarjeta) {
        this.aceptaTarjeta = aceptaTarjeta;
    }

    public List<Venta> getVentasRealizadas() {
        return new ArrayList<>(ventasRealizadas); // Copia defensiva
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + numeroTaquilla + "\t" + 
               (aceptaTarjeta ? "Acepta tarjeta" : "Solo efectivo");
    }
}