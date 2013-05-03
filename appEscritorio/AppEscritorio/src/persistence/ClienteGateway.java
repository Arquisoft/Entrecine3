package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Cliente;

public interface ClienteGateway {

	public void setConnection(Connection connection);

	public List<Cliente> findAll();

	public Cliente findById(int id);

	public Cliente findByDni(String dni);

	public void save(String dni, String nombre, String apellidos, String email,
			int dia_nacimiento, int mes_nacimiento, int anio_nacimiento)
			throws SQLException;

	public void update(int idCliente, String dni, String nombre,
			String apellidos, String email, int dia_nacimiento,
			int mes_nacimiento, int anio_nacimiento);

	public void delete(String dni);

}
