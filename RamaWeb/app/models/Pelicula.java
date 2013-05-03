package models;

import java.util.ArrayList;
import java.util.List;

import play.db.ebean.Model;

public class Pelicula extends Model {
	
	public Long id;
	
	public String titulo;
	
	public String descripcion;
	
	public static Finder<Long,Pelicula> find = new Finder(Long.class, Pelicula.class);
	
	public static List<Pelicula> all(){
		//return find.all();
		return new ArrayList<Pelicula>();
	}
//	
//	public static void crearPelicula(Pelicula pelicula){
//		//pelicula.save();
//	}
//	
//	public static void borrarPeli(Long id){
//		find.ref(id).delete();
//	}


}
