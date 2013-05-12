package models;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase de modelo que representa un cliente en el dominio
 * 
 * @author Project Team Entrecine3
 * 
 */
@Entity
@Table(name = "TClientes")
public class Cliente {

	@Id
	@GeneratedValue
	private int idCliente;
	private String dni;
	private String nombre;
	private String apellidos;
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	// Lista para mapeador
	@OneToMany(mappedBy = "cliente")
	private Set<DatosBancarios> datosBancarios = new HashSet<DatosBancarios>();

	public Cliente() {

	}

	public Cliente(String dni) {
		super();
		this.dni = dni;
	}

	public Cliente(String dni, String nombre, String apellidos, String email,
			Date fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Añadir datos bancarios al cliente. Metodo de mantenimiento para el
	 * mapeador.
	 * 
	 * @param datosBancarios
	 */
	public void addDatosBancarios(DatosBancarios datosBancarios) {
		this.datosBancarios.add(datosBancarios);
		datosBancarios.setCliente(this);
	}

	/**
	 * Eliminar datos bancarios del cliente. Metodo de mantenimiento para el
	 * mapeador.
	 * 
	 * @param datosBancarios
	 */
	public void removeDatosBancarios(DatosBancarios datosBancarios) {
		this.datosBancarios.remove(datosBancarios);
		datosBancarios.setCliente(null);
	}

	public Set<DatosBancarios> getDatosBancarios() {
		return Collections.unmodifiableSet(datosBancarios);
	}

	@SuppressWarnings("unused")
	private Set<DatosBancarios> _getDatosBancarios() {
		return datosBancarios;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", dni=" + dni + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
}