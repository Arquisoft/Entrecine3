package business.impl.pelicula;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.PeliculaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class BorrarPelicula {

	String titulo;

	public BorrarPelicula(String titulo) {
		this.titulo = titulo;
	}

	public void borrarPelicula() {

		Connection connection = null;
		PeliculaGateway pelicula = PersistenceFactory.getPeliculaGateway();
		
		try {

			connection = Jdbc.getConnection();
			pelicula.setConnection(connection);
			pelicula.delete(titulo);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
