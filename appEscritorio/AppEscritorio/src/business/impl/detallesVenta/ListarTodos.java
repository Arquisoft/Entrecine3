package business.impl.detallesVenta;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import conf.PersistenceFactory;
import persistence.DetallesVentaGateway;
import util.Jdbc;
import model.DetallesVenta;

public class ListarTodos {

	public List<DetallesVenta> execute() {

		Connection connection = null;
		DetallesVentaGateway venta = PersistenceFactory.getDetallesVentaGateaway();		
		List<DetallesVenta> lista = null;
		
		try {

			connection = Jdbc.getConnection();
			venta.setConnection(connection);
			lista = venta.listAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return lista;
	}

}
