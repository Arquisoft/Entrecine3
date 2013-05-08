package business;

import java.sql.SQLException;
import java.util.List;

import model.DatosBancarios;

public interface DatosBancariosService {
	
	public List<DatosBancarios> listarTodo();

	public DatosBancarios listarPorID(int id);

	public DatosBancarios listarPorTarjeta(int numTarjeta);

	public void saveDatosBancarios(int idCliente, int numTarjeta, String nombre,
			String apellidos, int pin, int mes_caducidad, int anio_caducidad)
			throws SQLException;


	public void updateDatosBancarios(int idDatosBancarios, int idCliente, int numTarjeta,
			String nombre, String apellidos, int pin, int mes_caducidad,
			int anio_caducidad) throws SQLException;

	public void deleteDatosBancarios(int numTarjeta) throws SQLException;

}
