package model;

/**
 * Clase del modelo que representa los tipos de proyección
 * @author Project Team Entrecine3
 *
 */
public class TipoProyeccion {
	
	private int idTipoProyeccion;
	private String nombre;
	private float precio;
	
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
