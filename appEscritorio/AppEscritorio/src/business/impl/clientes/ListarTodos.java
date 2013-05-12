package business.impl.clientes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import conf.PersistenceFactory;
import persistence.ClienteGateway;
import util.BusinessException;
import util.Jdbc;
import model.Cliente;

public class ListarTodos {

	public List<Cliente> execute() throws BusinessException {
		Connection connection = null;
		List<Cliente> lista = null;

		ClienteGateway cliente = PersistenceFactory.getClienteGateway();
		try {

			connection = Jdbc.getConnection();
			cliente.setConnection(connection);
			lista = cliente.findAll();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(connection);
		}
		return lista;
	}

}
