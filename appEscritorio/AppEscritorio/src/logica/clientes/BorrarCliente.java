package logica.clientes;

import java.sql.Connection;
import java.sql.SQLException;

import persistence.ClienteGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class BorrarCliente {

	String dni;

	public BorrarCliente(String dni) {
		this.dni = dni;
	}

	public void borrarCliente() {

		Connection connection = null;

		ClienteGateway cliente = PersistenceFactory.getClienteGateway();
		try {

			connection = Jdbc.getConnection();
			cliente.setConnection(connection);
			cliente.delete(dni);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
