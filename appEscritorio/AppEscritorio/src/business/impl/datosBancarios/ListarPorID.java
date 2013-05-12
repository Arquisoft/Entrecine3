package business.impl.datosBancarios;

import java.sql.Connection;
import java.sql.SQLException;
import model.DatosBancarios;
import persistence.DatosBancariosGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ListarPorID {

	public DatosBancarios execute(int id) {

		Connection connection = null;
		DatosBancariosGateway datos = PersistenceFactory.getDatosBancariosGateway();
		DatosBancarios db = new DatosBancarios();
		
		try {

			connection = Jdbc.getConnection();
			datos.setConnection(connection);
			db = datos.findById(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return db;
	}
}
