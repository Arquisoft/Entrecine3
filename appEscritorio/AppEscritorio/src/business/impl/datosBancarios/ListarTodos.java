package business.impl.datosBancarios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import conf.PersistenceFactory;
import persistence.DatosBancariosGateway;
import util.Jdbc;
import model.DatosBancarios;

public class ListarTodos {

	public List<DatosBancarios> ListarDatosBancarios() {
		Connection connection = null;
		List<DatosBancarios> lista = null;
		DatosBancariosGateway datos = PersistenceFactory.getDatosBancariosGateway();
		
		try {

			connection = Jdbc.getConnection();
			datos.setConnection(connection);
			lista = datos.findAll();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return lista;
	}

}
