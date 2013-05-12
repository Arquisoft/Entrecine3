package business.impl.datosBancarios;

import java.sql.Connection;
import java.sql.SQLException;
import model.DatosBancarios;
import persistence.DatosBancariosGateway;
import util.BusinessException;
import util.Jdbc;
import conf.PersistenceFactory;

public class ListarPorTarjeta {
	
	public DatosBancarios execute(int numTarjeta) throws BusinessException{

		Connection connection = null;
		DatosBancariosGateway datos = PersistenceFactory.getDatosBancariosGateway();
		DatosBancarios db = new DatosBancarios();
		
		try {

			connection = Jdbc.getConnection();
			datos.setConnection(connection);
			db = datos.findByNumTarjeta(numTarjeta);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(connection);
		}
		return db;
	}
}
