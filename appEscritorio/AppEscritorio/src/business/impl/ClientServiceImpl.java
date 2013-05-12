package business.impl;

import java.util.List;

import util.BusinessException;

import model.Cliente;
import business.ClientService;
import business.impl.clientes.*;

public class ClientServiceImpl implements ClientService {

	@Override
	public void addClient(String dni, String nombre, String apellidos,
			String email, int dia_nacimiento, int mes_nacimiento,
			int anio_nacimiento) {

		new GuardarCliente(dni, nombre, apellidos, email, dia_nacimiento,
				mes_nacimiento, anio_nacimiento).execute();
	}

	@Override
	public void deleteCliente(String dni) {
		try {
			new BorrarCliente(dni).execute();
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCliente(int idCliente, String dni, String nombre,
			String apellidos, String email, int dia_nacimiento,
			int mes_nacimiento, int anio_nacimiento) {
		try {
			new ActualizarCliente(dni, nombre, apellidos, email, idCliente,
					dia_nacimiento, mes_nacimiento, anio_nacimiento).execute();
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Cliente> ListarTodo() {
		List<Cliente> lista = null;
		try {
			lista = new ListarTodos().execute();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Cliente ListarPorID(int id) {
		Cliente cliente = null;
		try {
			cliente = new ListarPorID().execute(id);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public Cliente ListarPorDNI(String dni) {
		Cliente cliente = null;
		try {
			cliente = new ListarPorDNI().execute(dni);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return cliente;
	}

}
