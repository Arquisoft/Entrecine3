package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase modelo que representa una película en el dominio
 * @author Project Team Entrecine3
 *
 */
@Entity
@Table(name="TPeliculas")
public class Pelicula {
	
	@Id @GeneratedValue @Column(name="idPeliculas")private int idPelicula;
	private String titulo;
	@Temporal(TemporalType.TIME)private Date duracion;
	private String genero;
	private String descripcion;
	@Column(name="imagen")private String urlImagen;
	
	public Pelicula(){}
	
	public Pelicula(String titulo) {
		super();
		this.titulo = titulo;
	}

	public Pelicula(String titulo, Date duracion, String genero,
			String descripcion, String urlImagen) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen;
	}

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
	public Date getDuracion() {
		return duracion;
	}
	public void setDuracion(Date duracion) {
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
