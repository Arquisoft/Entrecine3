package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
	private Date fechaNacimiento;

	// Lista para mapeador
	@OneToMany(mappedBy = "cliente")
	private Set<DatosBancarios> datosBancarios = new HashSet<DatosBancarios>();

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
