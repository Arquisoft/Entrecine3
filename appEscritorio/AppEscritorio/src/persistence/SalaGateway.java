package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Sala;

public interface SalaGateway {

	/**
	 * Establecer conexion con la base de datos
	 * @param connection
	 */
	public void setConnection(Connection connection);

	/**
	 * Retornar todas las salas
	 * @return salasList
	 */
	public List<Sala> findAll();

	/**
	 * Buscar sala por id
	 * @param id
	 * @return sala
	 */
	public Sala findById(int id);

	/**
	 * Guardar sala
	 * @param numSala
	 * @param numButacas
	 * @param tipoSala
	 * @throws SQLException
	 */
	public void save(int numSala, int numButacas, String tipoSala)
			throws SQLException;

	/**
	 * Actualizar sala
	 * @param idSala
	 * @param numSala
	 * @param numButacas
	 * @param tipoSala
	 * @throws SQLException
	 */
	public void update(int idSala, int numSala, int numButacas, String tipoSala)
			throws SQLException;

	/**
	 * Borrar sala
	 * @param numSala
	 * @throws SQLException
	 */
	public void delete(int numSala) throws SQLException;

}
