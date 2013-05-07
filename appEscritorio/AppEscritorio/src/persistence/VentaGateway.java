package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Venta;

public interface VentaGateway {

	/**
	 * Establecer conexion con la base de datos
	 * @param connection
	 */
	public void setConnection(Connection connection);

	/**
	 * Listar todas las ventas almacenadas
	 * @return ventaList
	 */
	public List<Venta> findAll();

	/**
	 * Buscar una venta por su id
	 * @param id
	 * @return venta
	 */
	public Venta findById(int id);

	/**
	 * Guardar una venta
	 * @param idCliente
	 * @param precioTotal
	 * @param fechaVenta
	 * @throws SQLException
	 */
	public void save(int idCliente, double precioTotal, String fechaVenta) throws SQLException;

	/**
	 * Borrar una venta por su id
	 * @param id
	 * @throws SQLException
	 */
	public void delete(int id) throws SQLException;

}
