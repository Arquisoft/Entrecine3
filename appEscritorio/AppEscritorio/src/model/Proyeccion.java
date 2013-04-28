package model;

import java.sql.Timestamp;

/**
 * Clase del modelo que representa una proyección en el dominio
 * @author Project Team Entrecine3
 *
 */
public class Proyeccion {
	
	private int idProyeccion;
	private int idPelicula;
	private int idSala;
	private int tipoProyeccion;
	private Timestamp fechaProyeccion;
	
	/**
	 * Constructor parametrizado con los índices
	 * @param idPelicula
	 * @param idSala
	 * @param tipoProyeccion
	 */
	public Proyeccion(int idPelicula, int idSala, int tipoProyeccion){
		this.idPelicula = idPelicula;
		this.idSala = idSala;
		this.tipoProyeccion = tipoProyeccion;
	}
	
	public int getIdProyeccion() {
		return idProyeccion;
	}
	public void setIdProyeccion(int idProyeccion) {
		this.idProyeccion = idProyeccion;
	}
	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public int getTipoProyeccion() {
		return tipoProyeccion;
	}
	public void setTipoProyeccion(int tipoProyeccion) {
		this.tipoProyeccion = tipoProyeccion;
	}
	public Timestamp getFechaProyeccion() {
		return fechaProyeccion;
	}
	public void setFechaProyeccion(Timestamp fechaProyeccion) {
		this.fechaProyeccion = fechaProyeccion;
	}
}
