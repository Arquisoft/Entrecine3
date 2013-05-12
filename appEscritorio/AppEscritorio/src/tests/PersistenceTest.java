package tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.DatosBancarios;
import model.DetallesVenta;
import model.Pelicula;
import model.Proyeccion;
import model.Sala;
import model.TipoProyeccion;
import model.Venta;

import org.junit.Test;

import persistence.ClienteGateway;
import persistence.DatosBancariosGateway;
import persistence.DetallesVentaGateway;
import persistence.PeliculaGateway;
import persistence.ProyeccionGateway;
import persistence.SalaGateway;
import persistence.TipoProyeccionGateway;
import persistence.VentaGateway;
import persistence.impl.ClienteGatewayImpl;
import persistence.impl.DatosBancariosGatewayImpl;
import persistence.impl.DetallesVentaGatewayImpl;
import persistence.impl.PeliculaGatewayImpl;
import persistence.impl.ProyeccionGatewayImpl;
import persistence.impl.SalaGatewayImpl;
import persistence.impl.TipoProyeccionGatewayImpl;
import persistence.impl.VentaGatewayImpl;
import util.Jdbc;

public class PersistenceTest {

	@Test
	/**
	 * Añadir un cliente a la base de datos
	 */
	public void addClient() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			ClienteGateway cg = new ClienteGatewayImpl();
			cg.setConnection(conn);
			cg.save("7777778T", "Jorge", "Cabal", "uo216752@uniovi.es", 13, 02,
					1991);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Imprimir lista de clientes
	 */
	public void printClients() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			ClienteGateway cg = new ClienteGatewayImpl();
			cg.setConnection(conn);
			List<Cliente> lista = new ArrayList<Cliente>();
			lista = cg.findAll();
			for (Cliente c : lista)
				System.out.println(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Eliminar cliente de la base de datos
	 */
	public void removeClient() {

		Connection conn;
		try {
			conn = Jdbc.getConnection();
			ClienteGateway cg = new ClienteGatewayImpl();
			cg.setConnection(conn);
			cg.save("123456789T", "testBorrado", "Borrado", "borrado@test.es",
					1, 2, 1111);
			cg.delete("123456789T");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	/**
	 * Actualizar cliente de la base de datos
	 */
	public void updateCliente() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			ClienteGateway cg = new ClienteGatewayImpl();
			cg.setConnection(conn);
			cg.update(3, "98752647R", "Pepe", "Cabal", "uo216752@uniovi.es",
					13, 02, 1991);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Añadir datos bancarios a la base de datos
	 */
	public void addDatosBancarios() {
		Connection connection;

		try {
			connection = Jdbc.getConnection();
			DatosBancariosGateway dbg = new DatosBancariosGatewayImpl();
			dbg.setConnection(connection);
			dbg.save(1, 123456788, "Jorge", "Cabal", 1234, 10, 2015);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Listar datos bancarios
	 */
	public void printDatosBancarios() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			DatosBancariosGateway dbg = new DatosBancariosGatewayImpl();
			dbg.setConnection(conn);
			List<DatosBancarios> lista = new ArrayList<DatosBancarios>();
			lista = dbg.findAll();
			for (DatosBancarios db : lista)
				System.out.println(db);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Borrar datos bancarios de la bbdd
	 */
	public void deleteDatosBancarios() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			DatosBancariosGateway dbg = new DatosBancariosGatewayImpl();
			dbg.setConnection(conn);
			dbg.save(2, 1234567899, "test", "test", 1234, 10, 2015);
			printDatosBancarios();
			dbg.delete(1234567899);
			System.out.println("------------------");
			printDatosBancarios();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Actualizar datos bancarios de la bbdd
	 */
	public void updateDatosBancarios() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			DatosBancariosGateway dbg = new DatosBancariosGatewayImpl();
			dbg.setConnection(conn);
			dbg.update(1, 1, 144127452, "Jorge", "Cabal", 1234, 10, 2015);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Añadir peliculas a la bbdd
	 */
	public void addPeliculas() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			PeliculaGateway pg = new PeliculaGatewayImpl();
			pg.setConnection(conn);
			// Tiempo a continuación en horas, sin segundos para prueba de bbdd
			pg.save("Pelicula1", "03:00", "Terror",
					"Película pa cagase por la pata pa abajo!", "pelicula1.jpg");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Eliminar peliculas de la bbdd
	 */
	public void removePeliculas() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			PeliculaGateway pg = new PeliculaGatewayImpl();
			pg.setConnection(conn);
			pg.save("Pelicula2", "02:30", "Comedia",
					"Película pa reirse por la pata pa abajo!", "pelicula2.jpg");
			printPeliculas();
			pg.delete("Pelicula2");
			System.out.println("------------------");
			printPeliculas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Listar peliculas
	 */
	public void printPeliculas() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			PeliculaGateway pg = new PeliculaGatewayImpl();
			pg.setConnection(conn);
			List<Pelicula> lista = new ArrayList<Pelicula>();
			lista = pg.findAll();
			for (Pelicula p : lista)
				System.out.println(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Actualizar peliculas en la bbdd
	 */
	public void updatePelicula() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			PeliculaGateway pg = new PeliculaGatewayImpl();
			pg.setConnection(conn);
			pg.update(1, "Peli", "01:00:00", "Cómico",
					"Modificación a través de update", "imagen");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	/**
	 * Añadir tipo de proyeccion a la bbdd
	 */
	public void addTipoProyeccion() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			TipoProyeccionGateway tpg = new TipoProyeccionGatewayImpl();
			tpg.setConnection(conn);
			// Tiempo a continuación en horas, sin segundos para prueba de bbdd
			tpg.save("Normal", 5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Eliminar tipo de proyeccion de la bbdd
	 */
	public void removeTipoProyeccion() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			TipoProyeccionGateway tpg = new TipoProyeccionGatewayImpl();
			tpg.setConnection(conn);
			tpg.save("3D", 7.75);
			printTipoProyeccion();
			tpg.delete("3D");
			System.out.println("------------------");
			printTipoProyeccion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Listar tipos de proyeccion
	 */
	public void printTipoProyeccion() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			TipoProyeccionGateway tpg = new TipoProyeccionGatewayImpl();
			tpg.setConnection(conn);
			List<TipoProyeccion> lista = new ArrayList<TipoProyeccion>();
			lista = tpg.findAll();
			for (TipoProyeccion tp : lista)
				System.out.println(tp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Actualizar tipo de proyeccion de la bbdd
	 */
	public void updateTipoProyeccion() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			TipoProyeccionGateway tpg = new TipoProyeccionGatewayImpl();
			tpg.setConnection(conn);
			tpg.update(1, "Update", 5.3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Añadir sala a la bbdd
	 */
	public void addSala() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			SalaGateway sg = new SalaGatewayImpl();
			sg.setConnection(conn);
			sg.save(1, 150, "IMAX");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Eliminar sala de la bbdd
	 */
	public void removeSala() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			SalaGateway sg = new SalaGatewayImpl();
			sg.setConnection(conn);
			sg.save(2, 253, "Normal");
			printSala();
			sg.delete(2);
			System.out.println("------------------");
			printSala();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Actualizar sala de la bbdd
	 */
	public void updateSala() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			SalaGateway sg = new SalaGatewayImpl();
			sg.setConnection(conn);
			sg.update(6, 3, 134, "3D");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Imprimir salas
	 */
	public void printSala() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			SalaGateway sg = new SalaGatewayImpl();
			sg.setConnection(conn);
			List<Sala> lista = new ArrayList<Sala>();
			lista = sg.findAll();
			for (Sala tp : lista)
				System.out.println(tp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Añadir proyeccion a la bbdd
	 */
	public void addProyeccion() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			ProyeccionGateway pg = new ProyeccionGatewayImpl();
			pg.setConnection(conn);
			pg.save(1, 1, 20, 5, 2013, 16, 0, 0, 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Eliminar proyeccion de la bbdd
	 */
	public void removeProyeccion() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			ProyeccionGateway pg = new ProyeccionGatewayImpl();
			pg.setConnection(conn);
			pg.save(1, 1, 20, 5, 2013, 16, 0, 0, 1);
			printProyeccion();
			pg.delete(1, 1, 1);
			System.out.println("------------------");
			printProyeccion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Actualizar proyeccion de la bbdd
	 */
	public void updateProyeccion() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			ProyeccionGateway pg = new ProyeccionGatewayImpl();
			pg.setConnection(conn);
			pg.update(1, 1, 1, 10, 10, 2013, 16, 0, 0, 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	/**
	 * Imprimir proyecciones
	 */
	public void printProyeccion() {
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			ProyeccionGateway pg = new ProyeccionGatewayImpl();
			pg.setConnection(conn);
			List<Proyeccion> lista = new ArrayList<Proyeccion>();
			lista = pg.findAll();
			for (Proyeccion p : lista)
				System.out.println(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void addVenta(){
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			VentaGateway vg = new VentaGatewayImpl();
			vg.setConnection(conn);
			vg.save(1, 7.5, "2013-05-05");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void removeVenta(){
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			VentaGateway vg = new VentaGatewayImpl();
			vg.setConnection(conn);
			vg.save(1,200.3,"2013-06-06 16:55:55");
			printVentas();
			vg.delete(1); //Cambiar por ser ids autoincrementables
			System.out.println("------------------");
			printVentas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void printVentas(){
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			VentaGateway vg = new VentaGatewayImpl();
			vg.setConnection(conn);
			List<Venta> lista = new ArrayList<Venta>();
			lista = vg.findAll();
			for (Venta v : lista)
				System.out.println(v);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void addDetallesVenta(){
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			DetallesVentaGateway dvg = new DetallesVentaGatewayImpl();
			dvg.setConnection(conn);
			dvg.save(1, 1, 20, 3.5);
			dvg.save(1, 1, 2, 3.5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void removeDetallesVenta(){
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			DetallesVentaGateway dvg = new DetallesVentaGatewayImpl();
			dvg.setConnection(conn);
			dvg.save(1, 2, 20, 2.5);
			printDetallesVentas();
			dvg.deleteByIdVenta(1);
			System.out.println("------------------");
			printDetallesVentas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void printDetallesVentas(){
		Connection conn;

		try {
			conn = Jdbc.getConnection();
			DetallesVentaGateway dvg = new DetallesVentaGatewayImpl();
			dvg.setConnection(conn);
			List<DetallesVenta> lista = new ArrayList<DetallesVenta>();
			lista = dvg.listAll();
			for (DetallesVenta dv : lista)
				System.out.println(dv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
