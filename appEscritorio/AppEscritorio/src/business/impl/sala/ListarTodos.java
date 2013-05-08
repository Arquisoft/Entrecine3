package business.impl.sala;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import conf.PersistenceFactory;
import persistence.SalaGateway;
import util.Jdbc;
import model.Sala;

public class ListarTodos {

	public List<Sala> ListarSalas() {
		Connection connection = null;
		List<Sala> lista = null;
		SalaGateway sala = PersistenceFactory.getSalaGateway();
		
		try {

			connection = Jdbc.getConnection();
			sala.setConnection(connection);
			lista = sala.findAll();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return lista;
	}

}
