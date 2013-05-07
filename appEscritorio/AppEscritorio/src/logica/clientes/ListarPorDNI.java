package logica.clientes;

import java.sql.Connection;
import java.sql.SQLException;

import model.Cliente;
import persistence.ClienteGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ListarPorDNI {
	
	public Cliente ListarClientes(String dni) {

		Connection connection = null;

		ClienteGateway cliente = PersistenceFactory.getClienteGateway();
		Cliente c = new Cliente();
		try {

			connection = Jdbc.getConnection();
			cliente.setConnection(connection);
			c = cliente.findByDni(dni);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return c;
	}
}
