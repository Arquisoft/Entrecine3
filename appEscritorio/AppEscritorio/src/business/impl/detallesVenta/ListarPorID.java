package business.impl.detallesVenta;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.DetallesVenta;
import persistence.DetallesVentaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ListarPorID {

	public List<DetallesVenta> execute(int idVenta) {

		Connection connection = null;
		DetallesVentaGateway venta = PersistenceFactory.getDetallesVentaGateaway();		
		List<DetallesVenta> lista = null;
		
		try {

			connection = Jdbc.getConnection();
			venta.setConnection(connection);
			lista = venta.findByIdVenta(idVenta);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		return lista;
	}
}
