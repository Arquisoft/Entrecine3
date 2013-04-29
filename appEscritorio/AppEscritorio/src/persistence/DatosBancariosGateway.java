package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.DatosBancarios;

public interface DatosBancariosGateway {

	public void setConnection(Connection connection);

	public List<DatosBancarios> findAll();

	public DatosBancarios findById(int id);

	public void save(int idCliente, int numTarjeta, String nombre,
			String apellidos, int pin, Date fechaCaducidad) throws SQLException;

	public void delete(Long id);

}
