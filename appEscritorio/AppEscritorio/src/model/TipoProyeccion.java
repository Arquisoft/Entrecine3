package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase del modelo que representa los tipos de proyección
 * @author Project Team Entrecine3
 *
 */
@Entity
@Table(name="TTipo_Proyeccion")
public class TipoProyeccion {
	
	@Id @GeneratedValue @Column(name="idTipo")private int idTipoProyeccion;
	private String nombre;
	private double precio;
	
	public TipoProyeccion(){ }
	
	public TipoProyeccion(String nombre) {
		super();
		this.nombre = nombre;
	}

	public TipoProyeccion(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public int getIdTipoProyeccion() {
		return idTipoProyeccion;
	}
	public void setIdTipoProyeccion(int idTipoProyeccion) {
		this.idTipoProyeccion = idTipoProyeccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "TipoProyeccion [idTipoProyeccion=" + idTipoProyeccion
				+ ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
}
