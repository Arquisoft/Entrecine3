package model;

import java.sql.Time;

/**
 * Clase modelo que representa una película en el dominio
 * @author Project Team Entrecine3
 *
 */
public class Pelicula {
	
	private int idPelicula;
	private String titulo;
	private Time duracion;
	private String genero;
	private String descripcion;
	private String urlImagen;
	
	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Time getDuracion() {
		return duracion;
	}
	public void setDuracion(Time duracion) {
		this.duracion = duracion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", titulo=" + titulo
				+ ", duracion=" + duracion + ", genero=" + genero
				+ ", descripcion=" + descripcion + ", urlImagen=" + urlImagen
				+ "]";
	}
	
}
