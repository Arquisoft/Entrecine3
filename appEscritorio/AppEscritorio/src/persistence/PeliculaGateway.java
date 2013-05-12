package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Pelicula;

public interface PeliculaGateway {

	/**
	 * Establecer conexion con la base de datos
	 * @param connection
	 */
	public void setConnection(Connection connection);

	/**
	 * Devolver todas las peliculas
	 * @return PeliculasList
	 */
	public List<Pelicula> findAll();

	/**
	 * Buscar pelicula por id
	 * @param id
	 * @return pelicula
	 */
	public Pelicula findById(int id);

	/**
	 * Guardar pelicula
	 * @param titulo
	 * @param duracion
	 * @param genero
	 * @param descripcion
	 * @param imagen
	 * @throws SQLException
	 */
	public void save(String titulo, String duracion, String genero,
			String descripcion, String imagen) throws SQLException;

	/**
	 * Actualizar pelicula
	 * @param idPelicula
	 * @param titulo
	 * @param duracion
	 * @param genero
	 * @param descripcion
	 * @param imagen
	 * @throws SQLException
	 */
	public void update(int idPelicula, String titulo, String duracion,
			String genero, String descripcion, String imagen)
			throws SQLException;

	/**
	 * Borrar pelicula
	 * @param titulo
	 * @throws SQLException
	 */
	public void delete(String titulo) throws SQLException;

}
