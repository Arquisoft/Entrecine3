package logica.proyeccion;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.ProyeccionGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class GuardarProyeccion {

	int idPelicula, idSala, dia_proyeccion, mes_proyeccion, anio_proyeccion,
			hora_proyeccion, minuto_proyeccion, segundo_proyeccion,
			tipoProyeccion, dia_nacimiento, mes_nacimiento, anio_nacimiento;

	public GuardarProyeccion(int idPelicula, int idSala, int dia_proyeccion,
			int mes_proyeccion, int anio_proyeccion, int hora_proyeccion,
			int minuto_proyeccion, int segundo_proyeccion, int tipoProyeccion,
			int dia_nacimiento, int mes_nacimiento, int anio_nacimiento) {

		this.idPelicula = idPelicula;
		this.idSala = idSala;
		this.dia_proyeccion = dia_proyeccion;
		this.mes_proyeccion = mes_proyeccion;
		this.anio_proyeccion = anio_proyeccion;
		this.hora_proyeccion = hora_proyeccion;
		this.minuto_proyeccion = minuto_proyeccion;
		this.segundo_proyeccion = segundo_proyeccion;
		this.tipoProyeccion = tipoProyeccion;
		this.dia_nacimiento = dia_nacimiento;
		this.mes_nacimiento = mes_nacimiento;
		this.anio_nacimiento = anio_nacimiento;
	}

	public void guardarProyeccion() {

		Connection connection = null;
		ProyeccionGateway proyeccion = PersistenceFactory
				.getProyeccionGateway();

		try {

			connection = Jdbc.getConnection();
			proyeccion.setConnection(connection);
			proyeccion.save(idPelicula, idSala, dia_proyeccion, mes_proyeccion,
					anio_proyeccion, hora_proyeccion, minuto_proyeccion,
					segundo_proyeccion, tipoProyeccion);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}

}
