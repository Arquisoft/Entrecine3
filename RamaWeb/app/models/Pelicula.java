package models;

public class Pelicula {
	
	private Long id;
	
	private String titulo;
	private int entradasDisponibles;
	
	public Pelicula(String titulo, int entradasDisponibles) {
		super();
		this.titulo = titulo;
		this.entradasDisponibles = entradasDisponibles;
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
	
	public void comprar(){
		if(entradasDisponibles > 0)
			entradasDisponibles--;
	}

}
