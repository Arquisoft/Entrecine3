package logica.clientes;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.ClienteGateway;
import util.Jdbc;
import conf.PersistenceFactory;

public class GuardarCliente {
	
	String dni, nombre, apellidos, email;
	int dia_nacimiento,mes_nacimiento,anio_nacimiento;
	
	public GuardarCliente(String dni, String nombre, String apellidos,
			String email, int dia_nacimiento, int mes_nacimiento,
			int anio_nacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.dia_nacimiento = dia_nacimiento;
		this.mes_nacimiento = mes_nacimiento;
		this.anio_nacimiento = anio_nacimiento;
	}
	
	public void guardarCliente() {

		Connection connection = null;

		ClienteGateway cliente = PersistenceFactory.getClienteGateway();
		try {

			connection = Jdbc.getConnection();
			cliente.setConnection(connection);
			cliente.save(dni, nombre, apellidos, email, dia_nacimiento, mes_nacimiento, anio_nacimiento);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(connection);
		}
		
	}

}
