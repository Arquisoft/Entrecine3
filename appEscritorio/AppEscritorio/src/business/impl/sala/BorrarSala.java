package business.impl.sala;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.SalaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class BorrarSala {

	int numSala;

	public BorrarSala(int numSala) {
		this.numSala = numSala;
	}


	public void borrarSala() {

		Connection connection = null;
		SalaGateway sala = PersistenceFactory.getSalaGateway();
		
		try {

			connection = Jdbc.getConnection();
			sala.setConnection(connection);
			sala.delete(numSala);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
