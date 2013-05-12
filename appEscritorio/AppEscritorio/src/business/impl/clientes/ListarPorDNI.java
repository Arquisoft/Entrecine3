package business.impl.clientes;

import java.sql.Connection;
import java.sql.SQLException;

import model.Cliente;
import persistence.ClienteGateway;
import util.BusinessException;
import util.Jdbc;
import conf.PersistenceFactory;

public class ListarPorDNI {
	
	public Cliente execute(String dni) throws BusinessException{

		Connection connection = null;

		ClienteGateway cliente = PersistenceFactory.getClienteGateway();
		Cliente c = new Cliente();
		try {

			connection = Jdbc.getConnection();
			cliente.setConnection(connection);
			c = cliente.findByDni(dni);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(connection);
		}
		return c;
	}
}
