package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.DatosBancarios;

public interface DatosBancariosGateway {

	/**
	 * Establecer conexion con la base de datos
	 * @param connection
	 */
	public void setConnection(Connection connection);

	/**
	 * Listar todos los datos bancarios existentes
	 * @return DatosBancariosList
	 */
	public List<DatosBancarios> findAll();

	/**
	 * Buscar los datos bancarios por id
	 * @param id
	 * @return DatosBancarios
	 */
	public DatosBancarios findById(int id);

	/**
	 * Buscar los datos bancarios a través del número de la tarjeta
	 * @param numTarjeta
	 * @return DatosBancarios
	 */
	public DatosBancarios findByNumTarjeta(int numTarjeta);

	/**
	 * Guardar los datos bancarios 
	 * @param idCliente
	 * @param numTarjeta
	 * @param nombre
	 * @param apellidos
	 * @param pin
	 * @param mes_caducidad
	 * @param anio_caducidad
	 * @throws SQLException
	 */
	public void save(int idCliente, int numTarjeta, String nombre,
			String apellidos, int pin, int mes_caducidad, int anio_caducidad)
			throws SQLException;

	/**
	 * Actualizar los datos bancarios
	 * @param idDatosBancarios
	 * @param idCliente
	 * @param numTarjeta
	 * @param nombre
	 * @param apellidos
	 * @param pin
	 * @param mes_caducidad
	 * @param anio_caducidad
	 * @throws SQLException
	 */
	public void update(int idDatosBancarios, int idCliente, int numTarjeta,
			String nombre, String apellidos, int pin, int mes_caducidad,
			int anio_caducidad) throws SQLException;

	/**
	 * Borrar los datos bancarios
	 * @param numTarjeta
	 * @throws SQLException
	 */
	public void delete(int numTarjeta) throws SQLException;

}
