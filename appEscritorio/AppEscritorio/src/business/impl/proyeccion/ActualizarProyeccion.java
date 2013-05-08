package business.impl.proyeccion;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.ProyeccionGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ActualizarProyeccion {
	int idProyeccion, idPelicula, idSala, dia_proyeccion, mes_proyeccion,
			anio_proyeccion, hora_proyeccion, minuto_proyeccion,
			segundo_proyeccion, tipoProyeccion;

	
	
	public ActualizarProyeccion(int idProyeccion, int idPelicula, int idSala,
			int dia_proyeccion, int mes_proyeccion, int anio_proyeccion,
			int hora_proyeccion, int minuto_proyeccion, int segundo_proyeccion,
			int tipoProyeccion) {
		this.idProyeccion = idProyeccion;
		this.idPelicula = idPelicula;
		this.idSala = idSala;
		this.dia_proyeccion = dia_proyeccion;
		this.mes_proyeccion = mes_proyeccion;
		this.anio_proyeccion = anio_proyeccion;
		this.hora_proyeccion = hora_proyeccion;
		this.minuto_proyeccion = minuto_proyeccion;
		this.segundo_proyeccion = segundo_proyeccion;
		this.tipoProyeccion = tipoProyeccion;
	}



	public void execute() {

		Connection connection = null;
		ProyeccionGateway proyeccion = PersistenceFactory
				.getProyeccionGateway();

		try {

			connection = Jdbc.getConnection();
			proyeccion.setConnection(connection);
			proyeccion.update(idProyeccion, idPelicula, idSala, dia_proyeccion,
					mes_proyeccion, anio_proyeccion, hora_proyeccion,
					minuto_proyeccion, segundo_proyeccion, tipoProyeccion);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
