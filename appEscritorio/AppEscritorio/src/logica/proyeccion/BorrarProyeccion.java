package logica.proyeccion;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.ProyeccionGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class BorrarProyeccion {

	int idPelicula, idSala, tipoProyeccion;

	

	public BorrarProyeccion(int idPelicula, int idSala, int tipoProyeccion) {
		this.idPelicula = idPelicula;
		this.idSala = idSala;
		this.tipoProyeccion = tipoProyeccion;
	}



	public void borrarProyeccion() {

		Connection connection = null;
		ProyeccionGateway proyeccion = PersistenceFactory.getProyeccionGateway();
		
		try {

			connection = Jdbc.getConnection();
			proyeccion.setConnection(connection);
			proyeccion.delete(idPelicula, idSala, tipoProyeccion);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
