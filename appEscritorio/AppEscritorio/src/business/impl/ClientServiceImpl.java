package business.impl;

import business.ClientService;
import business.impl.clientes.GuardarCliente;

public class ClientServiceImpl implements ClientService {

	@Override
	public void addClient(String dni, String nombre, String apellidos,
			String email, int dia_nacimiento, int mes_nacimiento,
			int anio_nacimiento) {
		new GuardarCliente(dni, nombre, apellidos, email, dia_nacimiento,
				mes_nacimiento, anio_nacimiento).execute();

	}

}
