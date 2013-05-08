package ui;

import util.menu.BaseMenu;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Men� principal", null },
			{ "Gesti�n de Clientes", 			ClientesMenu.class }, 
			{ "Gesti�n del Cine", 			CineMenu.class },
			{ "Gesti�n de ventas", 	VentasMenu.class },
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}

}