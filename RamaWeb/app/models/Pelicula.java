package models;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.ebean.Model;

/**
 * Clase modelo que representa una película en el dominio
 * 
 * @author Project Team Entrecine3
 * 
 */
@Entity
@Table(name = "TPeliculas")
public class Pelicula extends Model {

	@Id
	@GeneratedValue
	@Column(name = "idPeliculas")
	private int idPelicula;
	private String titulo;
	@Temporal(TemporalType.TIME)
	private Date duracion;
	private String genero;
	private String descripcion;
	@Column(name = "imagen")
	private String urlImagen;

	@OneToMany(mappedBy = "pelicula")
	private Set<Proyeccion> proyeccion;
	
	public static Finder<Long,Pelicula> find = new Finder(Long.class, Pelicula.class);

	public Pelicula() {
	}

	public Pelicula(String titulo) {
		super();
		this.titulo = titulo;
	}
	
	public static List<Pelicula> all(){
		return find.all();
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

	public void addProyeccion(Proyeccion proyeccion) {
		this.proyeccion.add(proyeccion);
		proyeccion.setPelicula(this);
	}

	public void removeProyeccion(Proyeccion proyeccion) {
		this.proyeccion.remove(proyeccion);
		proyeccion.setPelicula(null);
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

	public Set<Proyeccion> getProyeccion() {
		return Collections.unmodifiableSet(proyeccion);
	}

	Set<Proyeccion> _getProyeccion() {
		return proyeccion;
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", titulo=" + titulo
				+ ", duracion=" + duracion + ", genero=" + genero
				+ ", descripcion=" + descripcion + ", urlImagen=" + urlImagen
				+ "]";
	}

}