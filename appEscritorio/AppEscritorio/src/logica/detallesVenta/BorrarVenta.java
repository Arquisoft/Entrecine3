package logica.detallesVenta;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.DetallesVentaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class BorrarVenta {

	int idVenta;

	public BorrarVenta(int idVenta) {
		super();
		this.idVenta = idVenta;
	}

	public void borrarCliente() {

		Connection connection = null;
		DetallesVentaGateway venta = PersistenceFactory.getDetallesVentaGateaway();
		
		try {

			connection = Jdbc.getConnection();
			venta.setConnection(connection);
			venta.deleteByIdVenta(idVenta);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}

	}
}
