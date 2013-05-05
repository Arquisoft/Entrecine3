package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.TipoProyeccion;

public interface TipoProyeccionGateway {

	/**
	 * Establecer conexion con la base de datos
	 * @param connection
	 */
	public void setConnection(Connection connection);

	/**
	 * Retornar lista de los tipos de proyecciones
	 * @return tiposProyeccionesList
	 */
	public List<TipoProyeccion> findAll();

	/**
	 * Buscar tipo de proyeccion por id
	 * @param id
	 * @return tipoProyeccion
	 */
	public TipoProyeccion findById(int id);

	/**
	 * Guardar proyeccion
	 * @param nombre
	 * @param precio
	 * @throws SQLException
	 */
	public void save(String nombre, double precio) throws SQLException;

	/**
	 * Actualizar proyeccion
	 * @param idTipoProyeccion
	 * @param nombre
	 * @param precio
	 * @throws SQLException
	 */
	public void update(int idTipoProyeccion, String nombre, double precio)
			throws SQLException;

	/**
	 * Borrar proyeccion
	 * @param nombreTipo
	 * @throws SQLException
	 */
	public void delete(String nombreTipo) throws SQLException;

}
