package business.impl.sala;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.SalaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ActualizarSala {
	
	int idSala, numSala, numButacas;
	String tipoSala;

	public ActualizarSala(int idSala, int numSala, int numButacas,
			String tipoSala) {
		this.idSala = idSala;
		this.numSala = numSala;
		this.numButacas = numButacas;
		this.tipoSala = tipoSala;
	}

	public void actualizarSala() {

		Connection connection = null;
		SalaGateway sala =PersistenceFactory.getSalaGateway();
		
		try {

			connection = Jdbc.getConnection();
			sala.setConnection(connection);
			sala.update(idSala, numSala, numButacas, tipoSala);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		
	}
}
