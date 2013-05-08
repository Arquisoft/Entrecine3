package ui.action;

import conf.ServicesFactory;
import util.BusinessException;
import util.console.Console;
import util.menu.Action;

public class AddClientAction implements Action {

	@Override
	public void execute() throws BusinessException {
		
		String dni = Console.readString("Dni");
		String nombre = Console.readString("Nombre"); 
		String apellidos = Console.readString("Apellidos");
		String email = Console.readString("Email");
		int diaNacimiento = Console.readInt("DiaNacimiento");
		int mesNacimiento = Console.readInt("MesNacimiento");
		int anioNacimiento = Console.readInt("AnioNacimiento");
		
		try{
			ServicesFactory.getClientService().addClient(dni, nombre, apellidos, email, diaNacimiento, mesNacimiento, anioNacimiento);
		
		Console.println("Nuevo cliente añadido");
		} catch (RuntimeException e){
			Console.println("Problema al añadir cliente");
		} 
	}
}
