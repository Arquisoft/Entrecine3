package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Proyeccion;

public interface ProyeccionGateway {

	/**
	 * Establecer conexion con la base de datos
	 * @param connection
	 */
	public void setConnection(Connection connection);

	/**
	 * Retornar lista de proyecciones
	 * @return
	 */
	public List<Proyeccion> findAll();

	/**
	 * Buscar proyeccion por id
	 * @param id
	 * @return
	 */
	public Proyeccion findById(int id);

	/**
	 * Guardar proyeccion
	 * @param idPelicula
	 * @param idSala
	 * @param dia_proyeccion
	 * @param mes_proyeccion
	 * @param anio_proyeccion
	 * @param hora_proyeccion
	 * @param minuto_proyeccion
	 * @param segundo_proyeccion
	 * @param tipoProyeccion
	 * @throws SQLException
	 */
	public void save(int idPelicula, int idSala, int dia_proyeccion,
			int mes_proyeccion, int anio_proyeccion, int hora_proyeccion,
			int minuto_proyeccion, int segundo_proyeccion, int tipoProyeccion)
			throws SQLException;

	/**
	 * Actualizar proyeccion
	 * @param idProyeccion
	 * @param idPelicula
	 * @param idSala
	 * @param dia_proyeccion
	 * @param mes_proyeccion
	 * @param anio_proyeccion
	 * @param hora_proyeccion
	 * @param minuto_proyeccion
	 * @param segundo_proyeccion
	 * @param tipoProyeccion
	 * @throws SQLException
	 */
	public void update(int idProyeccion, int idPelicula, int idSala,
			int dia_proyeccion, int mes_proyeccion, int anio_proyeccion,
			int hora_proyeccion, int minuto_proyeccion, int segundo_proyeccion,
			int tipoProyeccion) throws SQLException;

	/**
	 * Borrar proyeccion
	 * @param idPelicula
	 * @param idSala
	 * @param tipoProyeccion
	 * @throws SQLException
	 */
	public void delete(int idPelicula, int idSala, int tipoProyeccion)
			throws SQLException;

}
