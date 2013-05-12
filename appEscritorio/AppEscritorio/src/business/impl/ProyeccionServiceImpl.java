package business.impl;

import java.util.List;

import model.Proyeccion;
import business.ProyeccionService;
import business.impl.proyeccion.ActualizarProyeccion;
import business.impl.proyeccion.BorrarProyeccion;
import business.impl.proyeccion.GuardarProyeccion;
import business.impl.proyeccion.ListarPorID;
import business.impl.proyeccion.ListarTodos;

public class ProyeccionServiceImpl implements ProyeccionService {

	@Override
	public void addProyeccion(int idPelicula, int idSala, int dia_proyeccion,
			int mes_proyeccion, int anio_proyeccion, int hora_proyeccion,
			int minuto_proyeccion, int segundo_proyeccion, int tipoProyeccion) {

		new GuardarProyeccion(idPelicula, idSala, dia_proyeccion,
				mes_proyeccion, anio_proyeccion, hora_proyeccion,
				minuto_proyeccion, segundo_proyeccion, tipoProyeccion).execute();

	}

	@Override
	public void deleteProyeccion(int idPelicula, int idSala, int tipoProyeccion) {
		new BorrarProyeccion(idPelicula, idSala, tipoProyeccion).execute();

	}

	@Override
	public void updateProyeccion(int idProyeccion, int idPelicula, int idSala,
			int dia_proyeccion, int mes_proyeccion, int anio_proyeccion,
			int hora_proyeccion, int minuto_proyeccion, int segundo_proyeccion,
			int tipoProyeccion) {
		
		new ActualizarProyeccion(idProyeccion, idPelicula, idSala,
				dia_proyeccion, mes_proyeccion, anio_proyeccion,
				hora_proyeccion, minuto_proyeccion, segundo_proyeccion,
				tipoProyeccion).execute();
	}

	@Override
	public List<Proyeccion> listarTodo() {
		List<Proyeccion> lista = new ListarTodos().execute();
		return lista;
	}

	@Override
	public Proyeccion listarPorID(int id) {
		Proyeccion proyeccion = new ListarPorID().execute(id);
		return proyeccion;
	}

}
