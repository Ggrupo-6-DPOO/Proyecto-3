package Atracciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Espectaculo extends atraccion implements Serializable {
    private Date horaInicio;
    private int duracionMinutos;
    private String descripcion;
    private List<String> artistas;
    private TipoEspectaculo tipo;
    
    public Espectaculo(String nombre, String ubicacion, int cupoMaximo, 
                      int numMinEmpleados, NivelExclusividad exclusividad,
                      Date horaInicio, int duracionMinutos, String descripcion, 
                      TipoEspectaculo tipo) {
        super(nombre, ubicacion, cupoMaximo, numMinEmpleados, exclusividad);
        this.horaInicio = horaInicio;
        this.duracionMinutos = duracionMinutos;
        this.descripcion = descripcion;
        this.artistas = new ArrayList<>();
        this.tipo = tipo;
    }
    
    public void agregarArtista(String artista) {
        this.artistas.add(artista);
    }
    
    public boolean estaEnCurso(Date fechaActual) {
        long tiempoInicio = horaInicio.getTime();
        long tiempoActual = fechaActual.getTime();
        long tiempoFin = tiempoInicio + (duracionMinutos * 60 * 1000);
        
        return tiempoActual >= tiempoInicio && tiempoActual <= tiempoFin;
    }
    
    public void reprogramar(Date nuevaHora, int nuevaDuracion) {
        this.horaInicio = nuevaHora;
        this.duracionMinutos = nuevaDuracion;
    }
    
    // Getters y Setters
    public Date getHoraInicio() {
        return horaInicio;
    }
    
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<String> getArtistas() {
        return new ArrayList<>(artistas); // Copia defensiva
    }
    
    public TipoEspectaculo getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoEspectaculo tipo) {
        this.tipo = tipo;
    }
    
    public String toString() {
        return super.toString() + "\t" + horaInicio + "\t" + duracionMinutos + 
               "\t" + tipo;
    }
}