package business;

import java.util.List;

import model.Cliente;

public interface ClientService {
	
	public void addClient(String dni, String nombre, String apellidos,
			String email, int dia_nacimiento, int mes_nacimiento,
			int anio_nacimiento);
	
	
	public void deleteCliente(String dni);
	
	public void updateCliente(int idCliente, String dni, String nombre,
			String apellidos, String email, int dia_nacimiento,
			int mes_nacimiento, int anio_nacimiento);
	
	public List<Cliente> ListarTodo();

	public Cliente ListarPorID(int id);

	public Cliente ListarPorDNI(String dni);
}
