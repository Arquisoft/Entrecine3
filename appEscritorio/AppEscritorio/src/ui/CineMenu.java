package ui;

import util.menu.BaseMenu;
import util.menu.NotYetImplementedAction;

public class CineMenu extends BaseMenu{
	
	public CineMenu() {
		menuOptions = new Object[][] { 
			{"Administrador > Gestión de Cine", null},
			
			{ "Añadir pelicula", 				NotYetImplementedAction.class }, 
			{ "Modificar pelicula", 	NotYetImplementedAction.class }, 
			{ "Eliminar pelicula", 				NotYetImplementedAction.class }, 
			{ "Listar peliculas", 				NotYetImplementedAction.class },
			{ "Añadir sala",			NotYetImplementedAction.class },
			{ "Modificar sala",			NotYetImplementedAction.class },
			{ "Eliminar sala",			NotYetImplementedAction.class },
			{ "Listar salas",			NotYetImplementedAction.class },
			{ "Añadir tipos de proyeccion",			NotYetImplementedAction.class },
			{ "Modificar tipos de proyeccion",			NotYetImplementedAction.class },
			{ "Eliminar tipos de proyeccion",			NotYetImplementedAction.class },
			{ "Listar tipos de proyeccion",			NotYetImplementedAction.class },
			{ "Añadir proyeccion",			NotYetImplementedAction.class },
			{ "Modificar proyeccion",			NotYetImplementedAction.class },
			{ "Eliminar proyeccion",			NotYetImplementedAction.class },
			{ "Listar proyecciones",			NotYetImplementedAction.class },
		};
	}

}
