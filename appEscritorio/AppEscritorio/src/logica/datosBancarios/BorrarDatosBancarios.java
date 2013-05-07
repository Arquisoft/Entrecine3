package logica.datosBancarios;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.DatosBancariosGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class BorrarDatosBancarios {

	int numTarjera;

	public BorrarDatosBancarios(int numTarjera) {
		this.numTarjera = numTarjera;
	}

	public void borrarDatosBancarios() {

		Connection connection = null;
		DatosBancariosGateway datos = PersistenceFactory.getDatosBancariosGateway();
		try {

			connection = Jdbc.getConnection();
			datos.setConnection(connection);
			datos.delete(numTarjera);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
