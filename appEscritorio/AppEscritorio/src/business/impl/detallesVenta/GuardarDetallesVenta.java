package business.impl.detallesVenta;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.DetallesVentaGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class GuardarDetallesVenta {
	
	int idProyeccion, idVentas, butaca; double precio;
	
	public GuardarDetallesVenta(int idProyeccion, int idVentas, int butaca,
			double precio) {
		super();
		this.idProyeccion = idProyeccion;
		this.idVentas = idVentas;
		this.butaca = butaca;
		this.precio = precio;
	}
	
	public void guardarDatosVenta() {

		Connection connection = null;
		DetallesVentaGateway venta = PersistenceFactory.getDetallesVentaGateaway();
		
		try {

			connection = Jdbc.getConnection();
			venta.setConnection(connection);
			venta.save(idProyeccion, idVentas, butaca, precio);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		
	}

}
