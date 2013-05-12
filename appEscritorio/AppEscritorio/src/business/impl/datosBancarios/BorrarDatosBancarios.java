package business.impl.datosBancarios;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.DatosBancariosGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class BorrarDatosBancarios {

	int numTarjeta;

	public BorrarDatosBancarios(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public void execute() {

		Connection connection = null;
		DatosBancariosGateway datos = PersistenceFactory.getDatosBancariosGateway();
		try {

			connection = Jdbc.getConnection();
			datos.setConnection(connection);
			datos.delete(numTarjeta);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
