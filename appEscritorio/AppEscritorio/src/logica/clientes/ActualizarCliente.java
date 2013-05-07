package logica.clientes;

import java.sql.Connection;
import java.sql.SQLException;

import persistence.ClienteGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class ActualizarCliente {
	String dni, nombre, apellidos, email;
	int idCliente,dia_nacimiento,mes_nacimiento,anio_nacimiento;
	
	public ActualizarCliente(String dni, String nombre, String apellidos,
			String email, int idCliente, int dia_nacimiento,
			int mes_nacimiento, int anio_nacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.idCliente = idCliente;
		this.dia_nacimiento = dia_nacimiento;
		this.mes_nacimiento = mes_nacimiento;
		this.anio_nacimiento = anio_nacimiento;
	}



	public void actualizarCliente() {

		Connection connection = null;

		ClienteGateway cliente = PersistenceFactory.getClienteGateway();
		try {

			connection = Jdbc.getConnection();
			cliente.setConnection(connection);
			cliente.update(idCliente, dni, nombre, apellidos, email, dia_nacimiento, mes_nacimiento, anio_nacimiento);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		
	}
}
