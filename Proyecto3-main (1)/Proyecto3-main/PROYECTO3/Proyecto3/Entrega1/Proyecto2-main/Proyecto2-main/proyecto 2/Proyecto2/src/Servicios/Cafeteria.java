package Servicios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cafeteria extends LugarServicios implements Serializable {
    private int capacidad;
    private boolean tieneTerraza;
    private Map<String, Double> menu;
    private double ventasDiarias;

    // Constructor corregido
    public Cafeteria(String nombre, String ubicacion, int capacidad, boolean tieneTerraza) {
        super(nombre, ubicacion, TipoLugar.CAFETERIA); // Llamada correcta al constructor de LugarServicios
        this.capacidad = capacidad;
        this.tieneTerraza = tieneTerraza;
        this.menu = new HashMap<>();
        this.ventasDiarias = 0.0;
    }

    public void agregarItemMenu(String item, double precio) {
        menu.put(item, precio);
    }

    public void registrarVenta(String item, int cantidad) {
        Double precio = menu.get(item);
        if (precio != null) {
            ventasDiarias += precio * cantidad;
        }
    }

    public void resetearVentasDiarias() {
        ventasDiarias = 0.0;
    }

    @Override
    public double calcularGanancias() {
        return ventasDiarias;
    }

    // Getters y Setters
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isTieneTerraza() {
        return tieneTerraza;
    }

    public void setTieneTerraza(boolean tieneTerraza) {
        this.tieneTerraza = tieneTerraza;
    }

    public Map<String, Double> getMenu() {
        return new HashMap<>(menu); // Copia defensiva
    }

    public double getVentasDiarias() {
        return ventasDiarias;
    }
}