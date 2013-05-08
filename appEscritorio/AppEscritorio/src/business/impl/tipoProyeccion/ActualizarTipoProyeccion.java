package business.impl.tipoProyeccion;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.TipoProyeccionGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ActualizarTipoProyeccion {
	int idTipoProyeccion;
	String nombre;
	double precio;

	public ActualizarTipoProyeccion(int idTipoProyeccion, String nombre,
			double precio) {
		this.idTipoProyeccion = idTipoProyeccion;
		this.nombre = nombre;
		this.precio = precio;
	}

	public void actualizarTipoProyeccion() {

		Connection connection = null;
		TipoProyeccionGateway proyeccion = PersistenceFactory.getTipoProyeccionGateway();
		
		try {

			connection = Jdbc.getConnection();
			proyeccion.setConnection(connection);
			proyeccion.update(idTipoProyeccion, nombre, precio);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
