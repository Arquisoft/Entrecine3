package business.impl.venta;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.VentaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class GuardarVenta {
	
	int idCliente; double precioTotal; String fechaVenta;
	
	public GuardarVenta(int idCliente, double precioTotal, String fechaVenta) {
		this.idCliente = idCliente;
		this.precioTotal = precioTotal;
		this.fechaVenta = fechaVenta;
	}

	public void execute() {

		Connection connection = null;
		VentaGateway venta = PersistenceFactory.getVentaGateaway();
		
		try {

			connection = Jdbc.getConnection();
			venta.setConnection(connection);
			venta.save(idCliente, precioTotal, fechaVenta);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		
	}

}
