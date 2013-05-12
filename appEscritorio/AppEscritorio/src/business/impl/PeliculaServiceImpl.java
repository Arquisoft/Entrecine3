package business.impl;

import java.util.List;

import model.Pelicula;
import business.PeliculaService;
import business.impl.pelicula.ActualizarPelicula;
import business.impl.pelicula.BorrarPelicula;
import business.impl.pelicula.GuardarPelicula;
import business.impl.pelicula.ListarPorID;
import business.impl.pelicula.ListarTodos;

public class PeliculaServiceImpl implements PeliculaService {

	@Override
	public void addPelicula(String titulo, String duracion, String genero,
			String descripcion, String imagen) {
		new GuardarPelicula(titulo, duracion, genero, descripcion, imagen).execute();
	}

	@Override
	public void deletePelicula(String titulo) {
		new BorrarPelicula(titulo).execute();

	}

	@Override
	public void updatePelicula(int idPelicula, String titulo, String duracion,
			String genero, String descripcion, String imagen) {
		
		new ActualizarPelicula(idPelicula, titulo, duracion, genero,
				descripcion, imagen).execute();
	}

	@Override
	public List<Pelicula> listarTodo() {
		List<Pelicula> lista = new ListarTodos().execute();
		return lista;
	}

	@Override
	public Pelicula listarPorID(int id) {
		Pelicula pelicula = new ListarPorID().execute(id);
		return pelicula;
	}

}
