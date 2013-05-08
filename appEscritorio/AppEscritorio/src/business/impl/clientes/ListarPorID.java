package business.impl.clientes;

import java.sql.Connection;
import java.sql.SQLException;
import model.Cliente;
import persistence.ClienteGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ListarPorID {

	public Cliente ListarClientes(int id) {

		Connection connection = null;

		ClienteGateway cliente = PersistenceFactory.getClienteGateway();
		Cliente c = new Cliente();
		try {

			connection = Jdbc.getConnection();
			cliente.setConnection(connection);
			c = cliente.findById(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return c;
	}
}
