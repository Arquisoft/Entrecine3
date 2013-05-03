package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TDatos_bancarios")
public class DatosBancarios {
	
	@Id @GeneratedValue private int idDatosBancarios;
	private int idCliente;
	private int numTarjeta;
	private String nombre;
	private String apellidos;
	private int pin;
	private Date fechaCaducidad;
	
	@ManyToOne private Cliente cliente;
	
	/**
	 * Constructor por omisión
	 */
	public DatosBancarios(){
		
	}
	
	/**
	 * Constructor parametrizado. Obligamos a insertar siempre el cliente asociado.
	 * @param idCliente cliente asociado
	 */
	public DatosBancarios(int idCliente){
		this.idCliente = idCliente;
	}
	
	public DatosBancarios(int idCliente, int numTarjeta,
			String nombre, String apellidos, int pin, Date fechaCaducidad) {
		super();
		this.idCliente = idCliente;
		this.numTarjeta = numTarjeta;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.pin = pin;
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getIdDatosBancarios() {
		return idDatosBancarios;
	}
	public void setIdDatosBancarios(int idDatosBancarios) {
		this.idDatosBancarios = idDatosBancarios;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "DatosBancarios [idDatosBancarios=" + idDatosBancarios
				+ ", idCliente=" + idCliente + ", numTarjeta=" + numTarjeta
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", pin="
				+ pin + ", fechaCaducidad=" + fechaCaducidad + "]";
	}
	
}
