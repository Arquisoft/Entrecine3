package business.impl.venta;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import conf.PersistenceFactory;
import persistence.VentaGateway;
import util.Jdbc;
import model.Venta;

public class ListarTodos {

	public List<Venta> execute() {
		Connection connection = null;
		List<Venta> lista = null;
		VentaGateway venta = PersistenceFactory.getVentaGateaway();
		try {

			connection = Jdbc.getConnection();
			venta.setConnection(connection);
			lista = venta.findAll();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return lista;
	}

}
