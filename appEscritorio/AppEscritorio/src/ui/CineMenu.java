package ui;

import util.menu.BaseMenu;
import util.menu.NotYetImplementedAction;

public class CineMenu extends BaseMenu{
	
	public CineMenu() {
		menuOptions = new Object[][] { 
			{"Administrador > Gesti�n de Cine", null},
			
			{ "A�adir pelicula", 				NotYetImplementedAction.class }, 
			{ "Modificar pelicula", 	NotYetImplementedAction.class }, 
			{ "Eliminar pelicula", 				NotYetImplementedAction.class }, 
			{ "Listar peliculas", 				NotYetImplementedAction.class },
			{ "A�adir sala",			NotYetImplementedAction.class },
			{ "Modificar sala",			NotYetImplementedAction.class },
			{ "Eliminar sala",			NotYetImplementedAction.class },
			{ "Listar salas",			NotYetImplementedAction.class },
			{ "A�adir tipos de proyeccion",			NotYetImplementedAction.class },
			{ "Modificar tipos de proyeccion",			NotYetImplementedAction.class },
			{ "Eliminar tipos de proyeccion",			NotYetImplementedAction.class },
			{ "Listar tipos de proyeccion",			NotYetImplementedAction.class },
			{ "A�adir proyeccion",			NotYetImplementedAction.class },
			{ "Modificar proyeccion",			NotYetImplementedAction.class },
			{ "Eliminar proyeccion",			NotYetImplementedAction.class },
			{ "Listar proyecciones",			NotYetImplementedAction.class },
		};
	}

}
