package logica.pelicula;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.PeliculaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class GuardarPelicula {

	String titulo, duracion, genero, descripcion, imagen;

	public GuardarPelicula(String titulo, String duracion, String genero,
			String descripcion, String imagen) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public void guardarCliente() {

		Connection connection = null;
		PeliculaGateway pelicula = PersistenceFactory.getPeliculaGateway();
		
		try {

			connection = Jdbc.getConnection();
			pelicula.setConnection(connection);
			pelicula.save(titulo, duracion, genero, descripcion, imagen);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}

}
