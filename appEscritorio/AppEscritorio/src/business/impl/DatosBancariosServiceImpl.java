package business.impl;

import java.sql.SQLException;
import java.util.List;
import util.BusinessException;
import model.DatosBancarios;
import business.DatosBancariosService;
import business.impl.datosBancarios.ActualizarDatosBancarios;
import business.impl.datosBancarios.BorrarDatosBancarios;
import business.impl.datosBancarios.GuardarDatosBancarios;
import business.impl.datosBancarios.ListarPorID;
import business.impl.datosBancarios.ListarPorTarjeta;
import business.impl.datosBancarios.ListarTodos;


public class DatosBancariosServiceImpl implements DatosBancariosService {

	@Override
	public List<DatosBancarios> listarTodo() {
		List<DatosBancarios> lista = new ListarTodos().execute();
		return lista;
	}

	@Override
	public DatosBancarios listarPorID(int id) {
		DatosBancarios datos = new ListarPorID().execute(id);
		return datos;
	}

	@Override
	public DatosBancarios listarPorTarjeta(int numTarjeta) {
		DatosBancarios datos = null;
		try {
			datos = new ListarPorTarjeta().execute(numTarjeta);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return datos;
	}

	@Override
	public void updateDatosBancarios(int idDatosBancarios, int idCliente,
			int numTarjeta, String nombre, String apellidos, int pin,
			int mes_caducidad, int anio_caducidad) throws SQLException {

		new ActualizarDatosBancarios(idDatosBancarios, idCliente, numTarjeta,
				pin, mes_caducidad, anio_caducidad, nombre, apellidos).execute();

	}

	@Override
	public void deleteDatosBancarios(int numTarjeta) {
		new BorrarDatosBancarios(numTarjeta).execute();

	}

	@Override
	public void saveDatosBancarios(int idCliente, int numTarjeta,
			String nombre, String apellidos, int pin, int mes_caducidad,
			int anio_caducidad) throws SQLException {
		
		new GuardarDatosBancarios(idCliente, numTarjeta, pin, mes_caducidad,
				anio_caducidad, nombre, apellidos);

	}

}
