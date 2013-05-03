package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TDatos_bancarios")
public class DatosBancarios {
	
	@Id @GeneratedValue @Column(name="idDatos_bancarios")private int idDatosBancarios;
	//private int idCliente;
	private int numTarjeta;
	private String nombre;
	private String apellidos;
	private int pin;
	@Temporal(TemporalType.DATE)
	@Column(name="Fecha_caducidad")private Date fechaCaducidad;
	
	@ManyToOne @JoinColumn(name="idCliente") private Cliente cliente;
	
	/**
	 * Constructor por omisión
	 */
	public DatosBancarios(){
		
	}
	
	/**
	 * Constructor parametrizado. Obligamos a insertar siempre el cliente asociado.
	 * @param idCliente cliente asociado
	 */
	public DatosBancarios(int numTarjeta){
		this.numTarjeta = numTarjeta;
	}
	
	public DatosBancarios(int numTarjeta,
			String nombre, String apellidos, int pin, Date fechaCaducidad) {
		super();
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
				+ ", numTarjeta=" + numTarjeta
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", pin="
				+ pin + ", fechaCaducidad=" + fechaCaducidad + "]";
	}
	
}
