package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.DetallesVenta;

public interface DetallesVentaGateway {
	
	/**
	 * Establecer conexion con la base de datos
	 * @param connection
	 */
	public void setConnection(Connection connection);
	
	/**
	 * Listar todos los detalles de todas las ventas
	 * @return DetallesVentaList
	 */
	public List<DetallesVenta> listAll();
	
	/**
	 * Buscar los detalles de una venta por el id de la venta
	 * @param idVenta
	 * @return detallesVentaList
	 */
	public List<DetallesVenta> findByIdVenta(int idVenta);
	
	/**
	 * Guardar los detalles de una venta
	 * @param idProyeccion
	 * @param idVentas
	 * @param butaca
	 * @param precio
	 * @throws SQLException 
	 */
	public void save(int idProyeccion, int idVentas, int butaca, double precio) throws SQLException;
	
	/**
	 * Eliminar los detalles de una venta por su id correspondiente
	 * @param id
	 * @throws SQLException 
	 */
	public void deleteByIdVenta(int idVenta) throws SQLException;

}
