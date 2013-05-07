package logica.datosBancarios;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.DatosBancariosGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ActualizarDatosBancarios {
	int idDatosBancarios, idCliente, numTarjeta, pin, mes_caducidad,
			anio_caducidad;
	String nombre, apellidos;

	public ActualizarDatosBancarios(int idDatosBancarios, int idCliente,
			int numTarjeta, int pin, int mes_caducidad, int anio_caducidad,
			String nombre, String apellidos) {
		super();
		this.idDatosBancarios = idDatosBancarios;
		this.idCliente = idCliente;
		this.numTarjeta = numTarjeta;
		this.pin = pin;
		this.mes_caducidad = mes_caducidad;
		this.anio_caducidad = anio_caducidad;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public void actualizarDatosBacarios() {

		Connection connection = null;
		DatosBancariosGateway datos = PersistenceFactory
				.getDatosBancariosGateway();
		try {

			connection = Jdbc.getConnection();
			datos.setConnection(connection);
			datos.update(idDatosBancarios, idCliente, numTarjeta, nombre,
					apellidos, pin, mes_caducidad, anio_caducidad);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
