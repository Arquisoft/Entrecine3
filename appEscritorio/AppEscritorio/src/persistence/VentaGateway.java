package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Venta;

/**
 * Pendiente
 * @author Jorge
 *
 */
public interface VentaGateway {
	
	public void setConnection(Connection connection);
	public List<Venta> findAll();
	public Venta findById(int id);
	public void save() throws SQLException;
	public void delete(Long id) throws SQLException;

}
