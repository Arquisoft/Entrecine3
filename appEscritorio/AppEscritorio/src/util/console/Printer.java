package util.console;

import java.io.PrintStream;

/**
 * Métodos de utilidad para escribir cosas en pantalla de forma controlada.
 * Aqu� irian todas las decoraciones pertinentes
 * 
 * @author alb
 */
public class Printer {
	private static PrintStream con = System.out;
	
	public static void printHeading(String string) {
		con.println(string);
	}

	/**
	 * Avisa de error logico en la ejecuci�n, muy probablemente por 
	 * equivocacion del usuario o por circunstancias que han cambiado 
	 * durante el "think time" del usuario (control optimista y eso...)
	 * 
	 * @param e
	 */
	public static void printBusinessException(Exception e) {
		//TODO: Hacer esto un poco más curioso según lo pida la interfaz
		
		con.println("Ha ocurrido un problema procesando su opcion:");
		con.println("\t- " + e.getLocalizedMessage());
//		e.printStackTrace();
	}

	/**
	 * Avisa de error irrecuperable en la interfaz del usuario
	 * @param string
	 * @param e
	 */
	public static void printRuntimeException(RuntimeException e) {
		//TODO: Hacer esto un poco más curioso según lo pida la interfaz
		
		con.println("Ha ocurrido un error interno no recuperable, " +
				"el programa debe terminar");
		con.println("\t- " + e.getLocalizedMessage());
		e.printStackTrace();
	}

	public static void print(String msg) {
		con.println(msg);
	}

	public static void printException(String string, Exception e) {
		con.println(string);
		con.println("\t- " + e.getLocalizedMessage());
	}
}
