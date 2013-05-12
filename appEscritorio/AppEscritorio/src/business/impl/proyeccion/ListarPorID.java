package business.impl.proyeccion;

import java.sql.Connection;
import java.sql.SQLException;
import model.Proyeccion;
import persistence.ProyeccionGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ListarPorID {

	public Proyeccion execute(int id) {

		Connection connection = null;

		ProyeccionGateway proyeccion = PersistenceFactory
				.getProyeccionGateway();
		Proyeccion p = new Proyeccion();
		
		try {

			connection = Jdbc.getConnection();
			proyeccion.setConnection(connection);
			
			p = proyeccion.findById(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return p;
	}
}
