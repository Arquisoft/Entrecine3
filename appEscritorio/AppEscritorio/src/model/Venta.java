package model;

import java.sql.Timestamp;

/**
 * Clase del modelo que representa una venta des dominio
 * @author Project Team Entrecine3
 *
 */
public class Venta {
	
	private int idVenta;
	private int idCliente;
	private double precioTotal;
	private Timestamp fechaVenta;
	
	public Venta(){	}
	
	/**
	 * Constructor parametrizado con índice del cliente
	 * @param idCliente
	 */
	public Venta(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Timestamp getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Timestamp fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", idCliente=" + idCliente
				+ ", precioTotal=" + precioTotal + ", fechaVenta=" + fechaVenta
				+ "]";
	}

}
