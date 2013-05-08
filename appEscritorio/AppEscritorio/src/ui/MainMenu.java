package ui;

import util.menu.BaseMenu;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Menú principal", null },
			{ "Gestión de Clientes", 			ClientesMenu.class }, 
			{ "Gestión del Cine", 			CineMenu.class },
			{ "Gestión de ventas", 	VentasMenu.class },
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}

}