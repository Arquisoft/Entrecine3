package business.impl.pelicula;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.PeliculaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ActualizarPelicula {
	int idPelicula;
	String titulo, duracion, genero, descripcion, imagen;

	public ActualizarPelicula(int idPelicula, String titulo, String duracion,
			String genero, String descripcion, String imagen) {
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}


	public void actualizarPelicula() {

		Connection connection = null;
		PeliculaGateway peliculas = PersistenceFactory.getPeliculaGateway();
		
		try {

			connection = Jdbc.getConnection();
			peliculas.setConnection(connection);
			peliculas.update(idPelicula, titulo, duracion, genero, descripcion, imagen);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
