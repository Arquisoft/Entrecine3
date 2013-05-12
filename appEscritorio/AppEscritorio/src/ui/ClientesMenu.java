package ui;

import ui.action.AddClientAction;
import util.menu.BaseMenu;
import util.menu.NotYetImplementedAction;

public class ClientesMenu extends BaseMenu {

	public ClientesMenu() {
		menuOptions = new Object[][] { 
			{"Administrador > Gesti�n de Clientes", null},
			
			{ "A�adir cliente", 				AddClientAction.class }, 
			{ "Modificar datos de cliente", 	NotYetImplementedAction.class }, 
			{ "Eliminar cliente", 				NotYetImplementedAction.class }, 
			{ "Listar clientes", 				NotYetImplementedAction.class },
			{ "Buscar cliente por DNI",			NotYetImplementedAction.class }
		};
	}

}