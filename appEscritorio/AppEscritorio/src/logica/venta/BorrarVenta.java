package logica.venta;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.VentaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class BorrarVenta {

	int id;

	public BorrarVenta(int id) {
		this.id = id;
	}

	public void borrarCliente() {

		Connection connection = null;
		VentaGateway venta = PersistenceFactory.getVentaGateaway();
		
		try {

			connection = Jdbc.getConnection();
			venta.setConnection(connection);
			venta.delete(id);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
