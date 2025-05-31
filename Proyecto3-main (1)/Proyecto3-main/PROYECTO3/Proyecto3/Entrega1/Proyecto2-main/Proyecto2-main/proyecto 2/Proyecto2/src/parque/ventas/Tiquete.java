package parque.ventas;

import java.io.Serializable;
import java.util.Date;

public class Tiquete implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private double precio;
    private int cupoMaximo;
    private boolean esDeTemporada;
    private TipoTiquete tipo;
    private Date fechaCompra;
    private Date fechaUso;
    private boolean estado;
    private double descuento;
    private boolean fastPass;




    // Constructor
    public Tiquete(int id, double precio, int cupoMaximo, boolean esDeTemporada,
                   TipoTiquete tipo, Date fechaCompra, double descuento, boolean fastPass) {
        this.id = id;
        this.precio = precio;
        this.setCupoMaximo(cupoMaximo);
        this.setEsDeTemporada(esDeTemporada);
        this.tipo = tipo;
        this.fechaCompra = fechaCompra;
        this.estado = false;
        this.descuento = descuento;
        this.fastPass = fastPass;
    }

    public boolean validarUso() {
        return !estado; // solo es válido si no ha sido usado
    }

    public void marcarUsado() {
        this.estado = true;
        this.fechaUso = new Date(); // marca la fecha en que fue usado
    }

    public String mostrarDetalles() {
        return "Tiquete ID: " + id + "\n" +
               "Tipo: " + tipo + "\n" +
               "Precio: $" + precio + "\n" +
               "Descuento: $" + descuento + "\n" +
               "FastPass: " + (fastPass ? "Sí" : "No") + "\n" +
               "Estado: " + (estado ? "Usado" : "No usado") + "\n" +
               "Fecha de compra: " + fechaCompra + "\n" +
               (estado ? "Fecha de uso: " + fechaUso + "\n" : "");
    }

    
    public double getPrecio() {
        return precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public TipoTiquete getTipo() {
        return tipo;
    }

    public boolean isFastPass() {
        return fastPass;
    }

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	public boolean isEsDeTemporada() {
		return esDeTemporada;
	}

	public void setEsDeTemporada(boolean esDeTemporada) {
		this.esDeTemporada = esDeTemporada;
	}
	public int getId() {
	    return id;
	}
	public Date getFechaCompra() {
	    return fechaCompra;
	}

}
