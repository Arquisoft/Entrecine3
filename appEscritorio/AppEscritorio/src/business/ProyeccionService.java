package business;

import java.util.List;

import model.Proyeccion;

public interface ProyeccionService {
	
	public void addProyeccion(int idPelicula, int idSala, int dia_proyeccion,
			int mes_proyeccion, int anio_proyeccion, int hora_proyeccion,
			int minuto_proyeccion, int segundo_proyeccion, int tipoProyeccion);	
	
	public void deleteProyeccion(int idPelicula, int idSala, int tipoProyeccion);
	
	public void updateProyeccion(int idProyeccion, int idPelicula, int idSala,
			int dia_proyeccion, int mes_proyeccion, int anio_proyeccion,
			int hora_proyeccion, int minuto_proyeccion, int segundo_proyeccion,
			int tipoProyeccion);
	
	public List<Proyeccion> listarTodo();

	public Proyeccion listarPorID(int id);
}
