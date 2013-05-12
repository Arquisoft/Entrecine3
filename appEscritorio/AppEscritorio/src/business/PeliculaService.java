package business;

import java.util.List;

import model.Pelicula;

public interface PeliculaService {
	
	public void addPelicula(String titulo, String duracion,
			String genero, String descripcion, String imagen);	
	
	public void deletePelicula(String titulo);
	
	public void updatePelicula(int idPelicula, String titulo, String duracion,
			String genero, String descripcion, String imagen);
	
	public List<Pelicula> listarTodo();

	public Pelicula listarPorID(int id);

}
