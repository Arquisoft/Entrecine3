package business.impl.tipoProyeccion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import conf.PersistenceFactory;
import persistence.TipoProyeccionGateway;
import util.Jdbc;
import model.TipoProyeccion;

public class ListarTodos {

	public List<TipoProyeccion> execute() {
		Connection connection = null;
		List<TipoProyeccion> lista = null;
		TipoProyeccionGateway tipo = PersistenceFactory.getTipoProyeccionGateway();
		
		try {

			connection = Jdbc.getConnection();
			tipo.setConnection(connection);
			lista = tipo.findAll();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return lista;
	}

}
