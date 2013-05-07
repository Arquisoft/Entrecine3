package logica.pelicula;

import java.sql.Connection;
import java.sql.SQLException;
import model.Pelicula;
import persistence.PeliculaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ListarPorID {

	public Pelicula ListarPeliculas(int id) {

		Connection connection = null;
		PeliculaGateway pelicula = PersistenceFactory.getPeliculaGateway();		
		Pelicula p = new Pelicula();
		
		try {

			connection = Jdbc.getConnection();
			pelicula.setConnection(connection);
			p = pelicula.findById(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return p;
	}
}
