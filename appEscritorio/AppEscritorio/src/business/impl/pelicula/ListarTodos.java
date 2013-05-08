package business.impl.pelicula;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import conf.PersistenceFactory;
import persistence.ClienteGateway;
import persistence.PeliculaGateway;
import util.Jdbc;
import model.Pelicula;

public class ListarTodos {

	public List<Pelicula> execute() {
		Connection connection = null;
		List<Pelicula> lista = null;

		ClienteGateway cliente = PersistenceFactory.getClienteGateway();
		PeliculaGateway pelicula = PersistenceFactory.getPeliculaGateway();

		try {

			connection = Jdbc.getConnection();
			cliente.setConnection(connection);
			lista = pelicula.findAll();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return lista;
	}

}
