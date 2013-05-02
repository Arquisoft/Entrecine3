package models;

import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

@Entity
public class Pelicula extends Model {
	
	@Id
	public Long id;
	
	@Required
	public String titulo;
	
	public String descripcion;
	
	public static Finder<Long,Pelicula> find = new Finder(Long.class, Pelicula.class);
	
	public static List<Pelicula> all(){
		return find.all();
	}
	
	public static void crearPelicula(Pelicula pelicula){
		pelicula.save();
	}
	
	public static void borrarPeli(Long id){
		find.ref(id).delete();
	}


}
