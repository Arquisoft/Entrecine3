package business.impl.tipoProyeccion;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.TipoProyeccionGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class BorrarTipoProyeccion {

	String nombreTipo;

	public BorrarTipoProyeccion(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public void borrarTipoProyeccion() {

		Connection connection = null;
		TipoProyeccionGateway tipoP = PersistenceFactory.getTipoProyeccionGateway();
		
		try {

			connection = Jdbc.getConnection();
			tipoP.setConnection(connection);
			tipoP.delete(nombreTipo);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
