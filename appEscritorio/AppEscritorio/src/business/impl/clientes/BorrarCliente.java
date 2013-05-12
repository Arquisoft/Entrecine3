package business.impl.clientes;

import java.sql.Connection;
import java.sql.SQLException;

import persistence.ClienteGateway;
import util.BusinessException;
import util.Jdbc;
import conf.PersistenceFactory;

public class BorrarCliente {

	String dni;

	public BorrarCliente(String dni) {
		this.dni = dni;
	}

	public void execute() throws BusinessException{

		Connection connection = null;

		ClienteGateway cliente = PersistenceFactory.getClienteGateway();
		try {

			connection = Jdbc.getConnection();
			cliente.setConnection(connection);
			cliente.delete(dni);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(connection);
		}

	}
}
