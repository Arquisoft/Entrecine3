package ui;

import ui.action.AddClientAction;
import util.menu.BaseMenu;
import util.menu.NotYetImplementedAction;

public class ClientesMenu extends BaseMenu {

	public ClientesMenu() {
		menuOptions = new Object[][] { 
			{"Administrador > Gestión de Clientes", null},
			
			{ "Añadir cliente", 				AddClientAction.class }, 
			{ "Modificar datos de cliente", 	NotYetImplementedAction.class }, 
			{ "Eliminar cliente", 				NotYetImplementedAction.class }, 
			{ "Listar clientes", 				NotYetImplementedAction.class },
			{ "Buscar cliente por DNI",			NotYetImplementedAction.class }
		};
	}

}