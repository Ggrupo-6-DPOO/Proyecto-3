package Servicios;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Tienda extends LugarServicios implements Serializable {
    private String tematica;
    private Map<String, Producto> inventario;
    private double ventasDiarias;

    // Constructor corregido
    public Tienda(String nombre, String ubicacion, String tematica) {
        super(nombre, ubicacion, TipoLugar.TIENDA); // Llamada correcta al constructor de LugarServicios
        this.tematica = tematica;
        this.inventario = new HashMap<>();
        this.ventasDiarias = 0.0;
    }

    public void agregarProducto(String codigo, String nombre, double precio, int cantidad) {
        Producto producto = new Producto(codigo, nombre, precio, cantidad);
        inventario.put(codigo, producto);
    }

    public boolean venderProducto(String codigo, int cantidad) {
        Producto producto = inventario.get(codigo);
        if (producto != null && producto.getCantidad() >= cantidad) {
            producto.reducirCantidad(cantidad);
            ventasDiarias += producto.getPrecio() * cantidad;
            return true;
        }
        return false;
    }

    public void reabastecerProducto(String codigo, int cantidad) {
        Producto producto = inventario.get(codigo);
        if (producto != null) {
            producto.aumentarCantidad(cantidad);
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
    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public Map<String, Producto> getInventario() {
        return new HashMap<>(inventario); // Copia defensiva
    }

    public double getVentasDiarias() {
        return ventasDiarias;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + tematica;
    }

    // Clase interna para representar un producto
    public static class Producto implements Serializable {
        private String codigo;
        private String nombre;
        private double precio;
        private int cantidad;

        public Producto(String codigo, String nombre, double precio, int cantidad) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public void reducirCantidad(int cantidad) {
            if (this.cantidad >= cantidad) {
                this.cantidad -= cantidad;
            }
        }

        public void aumentarCantidad(int cantidad) {
            this.cantidad += cantidad;
        }

        // Getters y Setters
        public String getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        @Override
        public String toString() {
            return codigo + "\t" + nombre + "\t" + precio + "\t" + cantidad;
        }
    }
}