package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Cliente;

public interface ClienteGateway {

	/**
	 * Establecer la conexion con la base de datos
	 * @param connection
	 */
	public void setConnection(Connection connection);

	/**
	 * Listar todos los clientes
	 * @return ClientList
	 */
	public List<Cliente> findAll();

	/**
	 * Buscar cliente por id
	 * @param id
	 * @return cliente
	 */
	public Cliente findById(int id);

	/**
	 * Buscar cliente por dni
	 * @param dni
	 * @return cliente
	 */
	public Cliente findByDni(String dni);

	/**
	 * Guardar un cliente
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param dia_nacimiento
	 * @param mes_nacimiento
	 * @param anio_nacimiento
	 * @throws SQLException
	 */
	public void save(String dni, String nombre, String apellidos, String email,
			int dia_nacimiento, int mes_nacimiento, int anio_nacimiento)
			throws SQLException;

	/**
	 * Actualizar un cliente
	 * @param idCliente
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param dia_nacimiento
	 * @param mes_nacimiento
	 * @param anio_nacimiento
	 */
	public void update(int idCliente, String dni, String nombre,
			String apellidos, String email, int dia_nacimiento,
			int mes_nacimiento, int anio_nacimiento);

	/**
	 * Borrar un cliente por su dni
	 * @param dni
	 */
	public void delete(String dni);

}
