package business.impl.tipoProyeccion;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.TipoProyeccionGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class GuardarTipoProyeccion {
	
	String nombre; double precio;
	
	public GuardarTipoProyeccion(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public void guardarTipoProyeccion() {

		Connection connection = null;
		TipoProyeccionGateway tipo = PersistenceFactory.getTipoProyeccionGateway();
		
		try {

			connection = Jdbc.getConnection();
			tipo.setConnection(connection);
			tipo.save(nombre, precio);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		
	}

}
