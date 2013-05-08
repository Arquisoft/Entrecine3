package business.impl.venta;

import java.sql.Connection;
import java.sql.SQLException;
import model.Venta;
import persistence.VentaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ListarPorID {

	public Venta ListarVentas(int id) {

		Connection connection = null;
		VentaGateway venta = PersistenceFactory.getVentaGateaway();
		Venta v = new Venta();
		try {

			connection = Jdbc.getConnection();
			venta.setConnection(connection);
			v = venta.findById(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return v;
	}
}
