package models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase del modelo que representa una venta des dominio
 * 
 * @author Project Team Entrecine3
 * 
 */
@Entity
@Table(name = "TVentas")
public class Venta {

	@Id
	@GeneratedValue
	private int idVenta;
	private int idCliente;
	private float precioTotal;
	private Timestamp fechaVenta;

	/**
	 * Constructor parametrizado con índice del cliente
	 * 
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

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Timestamp getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Timestamp fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

}