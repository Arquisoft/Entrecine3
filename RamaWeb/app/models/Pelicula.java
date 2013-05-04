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
		ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();
		pelis.add(new Pelicula("Peli1", "Hola"));
		pelis.add(new Pelicula("Peli3", "Hola3"));
		pelis.add(new Pelicula("Peli4", "Hola4"));
		return pelis;
	}
	
	public Pelicula() {
		
	}
	
	public Pelicula(String titulo, String descripcion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
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
