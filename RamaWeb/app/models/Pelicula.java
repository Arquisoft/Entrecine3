package models;

import java.util.ArrayList;
import java.util.List;

import play.data.validation.Constraints.Required;

public class Pelicula {
	
	@Required
	private Long id;
	
	private String titulo;
	private int entradasDisponibles;
	
	public static List<Pelicula> all(){
		return new ArrayList<Pelicula>();
	}
	
	public static void crearPelicula(Pelicula pelicula){
		
	}
	
	public static void borrarPeli(Long id){
		
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

}
