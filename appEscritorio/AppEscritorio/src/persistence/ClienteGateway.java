package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.Cliente;

public interface ClienteGateway {
	
	public void setConnection(Connection connection);
	public List<Cliente> findAll();
	public Cliente findById(int id);
	public void save(String dni, String nombre, String apellidos, String email, Date fecha_nacimiento) throws SQLException;
	public void delete(Long id);

}
