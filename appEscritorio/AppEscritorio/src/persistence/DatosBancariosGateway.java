package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.DatosBancarios;

public interface DatosBancariosGateway {

	public void setConnection(Connection connection);

	public List<DatosBancarios> findAll();

	public DatosBancarios findById(int id);

	public DatosBancarios findByNumTarjeta(int numTarjeta);

	public void save(int idCliente, int numTarjeta, String nombre,
			String apellidos, int pin, int mes_caducidad, int anio_caducidad)
			throws SQLException;

	public void update(int idDatosBancarios, int idCliente, int numTarjeta,
			String nombre, String apellidos, int pin, int mes_caducidad,
			int anio_caducidad) throws SQLException;

	public void delete(int numTarjeta) throws SQLException;

}
