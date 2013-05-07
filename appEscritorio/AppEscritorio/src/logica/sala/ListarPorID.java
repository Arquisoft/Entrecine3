package logica.sala;

import java.sql.Connection;
import java.sql.SQLException;
import model.Sala;
import persistence.SalaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ListarPorID {

	public Sala ListarSalas(int id) {

		Connection connection = null;
		SalaGateway sala = PersistenceFactory.getSalaGateway();		
		Sala s = new Sala();
		
		try {

			connection = Jdbc.getConnection();
			sala.setConnection(connection);
			s = sala.findById(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return s;
	}
}
