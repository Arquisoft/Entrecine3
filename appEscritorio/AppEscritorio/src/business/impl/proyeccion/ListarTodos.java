package business.impl.proyeccion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import conf.PersistenceFactory;
import persistence.ProyeccionGateway;
import util.Jdbc;


import model.Proyeccion;

public class ListarTodos {

	public List<Proyeccion> execute() {

		Connection connection = null;
		List<Proyeccion> lista = null;
		
		ProyeccionGateway proyeccion = PersistenceFactory
				.getProyeccionGateway();		
		try {

			connection = Jdbc.getConnection();
			proyeccion.setConnection(connection);
			
			lista = proyeccion.findAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return lista;
	}

}
