package Atracciones;

import Usuarios.Cliente;
import java.io.Serializable;

public class AtraccionMecanica extends atraccion implements Serializable {
    private double alturaMinima;
    private double pesoMaximo;
    private int limiteEdad;
    private boolean extrema; // Indica si es una atracción de alto impacto
    
    public AtraccionMecanica(String nombre, String ubicacion, int cupoMaximo, 
                            int numMinEmpleados, NivelExclusividad exclusividad,
                            double alturaMinima, double pesoMaximo, int limiteEdad, 
                            boolean extrema) {
        super(nombre, ubicacion, cupoMaximo, numMinEmpleados, exclusividad);
        this.alturaMinima = alturaMinima;
        this.pesoMaximo = pesoMaximo;
        this.limiteEdad = limiteEdad;
        this.extrema = extrema;
    }
    
    @Override
    public boolean esAptaPara(Cliente cliente) {
        // Verificar altura mínima
        boolean cumpleAltura = cliente.getAltura() >= alturaMinima;
        
        // Verificar peso máximo si está establecido
        boolean cumplePeso = pesoMaximo <= 0 || cliente.getPeso() <= pesoMaximo;
        
        // Verificar edad
        boolean cumpleEdad = cliente.getEdad() >= limiteEdad;
        
        // Verificar contraindicaciones médicas para atracciones extremas
        boolean sinContraindicaciones = true;
        if (extrema) {
            for (String contraindicacion : cliente.getContraindicaciones()) {
                // Lista de contraindicaciones que impiden usar atracciones extremas
                if (contraindicacion.toLowerCase().contains("cardíaco") || 
                    contraindicacion.toLowerCase().contains("presión") ||
                    contraindicacion.toLowerCase().contains("embarazo") ||
                    contraindicacion.toLowerCase().contains("columna")) {
                    sinContraindicaciones = false;
                    break;
                }
            }
        }
        
        return cumpleAltura && cumplePeso && cumpleEdad && 
               sinContraindicaciones && super.verificarDisponibilidad();
    }
    
    public void actualizarRestriccionesSeguridad(double nuevaAlturaMinima, 
                                               double nuevoPesoMaximo, 
                                               int nuevoLimiteEdad) {
        this.alturaMinima = nuevaAlturaMinima;
        this.pesoMaximo = nuevoPesoMaximo;
        this.limiteEdad = nuevoLimiteEdad;
    }
    
    // Getters y Setters
    public double getAlturaMinima() {
        return alturaMinima;
    }
    
    public void setAlturaMinima(double alturaMinima) {
        this.alturaMinima = alturaMinima;
    }
    
    public double getPesoMaximo() {
        return pesoMaximo;
    }
    
    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
    
    public int getLimiteEdad() {
        return limiteEdad;
    }
    
    public void setLimiteEdad(int limiteEdad) {
        this.limiteEdad = limiteEdad;
    }
    
    public boolean isExtrema() {
        return extrema;
    }
    
    public void setExtrema(boolean extrema) {
        this.extrema = extrema;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\t" + alturaMinima + "\t" + 
               pesoMaximo + "\t" + limiteEdad + "\t" + extrema;
    }
}