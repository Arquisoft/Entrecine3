package business.impl.sala;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.SalaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class GuardarSala {
	
	int numSala, numButacas;
	String tipoSala;
	
	public GuardarSala(int numSala, int numButacas, String tipoSala) {
		this.numSala = numSala;
		this.numButacas = numButacas;
		this.tipoSala = tipoSala;
	}

	public void guardarSala() {

		Connection connection = null;
		SalaGateway sala = PersistenceFactory.getSalaGateway();
		
		try {

			connection = Jdbc.getConnection();
			sala.setConnection(connection);
			sala.save(numSala, numButacas, tipoSala);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		
	}

}
