package logica.tipoProyeccion;

import java.sql.Connection;
import java.sql.SQLException;
import model.TipoProyeccion;
import persistence.TipoProyeccionGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ListarPorID {

	public TipoProyeccion ListarTipoProyeccion(int id) {

		Connection connection = null;
		TipoProyeccionGateway tipo = PersistenceFactory.getTipoProyeccionGateway();
		TipoProyeccion t = new TipoProyeccion();
		
		try {

			connection = Jdbc.getConnection();
			tipo.setConnection(connection);
			t = tipo.findById(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return t;
	}
}
