package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Pelicula extends Model {
	
	@Id
	private Long id;
	
	@Required
	private String titulo;
	private int entradasDisponibles;
	
	public static Finder<Long,Pelicula> find = new Finder(
		    Long.class, Pelicula.class
		  );
	
	public static List<Pelicula> all(){
		return find.all();
	}
	
	public static void crearPelicula(Pelicula pelicula){
		pelicula.save();
	}
	
	public static void borrarPeli(Long id){
		find.ref(id).delete();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getEntradasDisponibles() {
		return entradasDisponibles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setEntradasDisponibles(int entradasDisponibles) {
		this.entradasDisponibles = entradasDisponibles;
	}

}
