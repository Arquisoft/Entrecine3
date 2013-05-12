package business;

import java.util.List;
import model.TipoProyeccion;

public interface TipoProyeccionService {
	
	public List<TipoProyeccion> listarTodo();

	public TipoProyeccion listarPorID(int id);

	public void guardarTipoProyeccion(String nombre, double precio);

	public void actualizarTipoProyeccion(int idTipoProyeccion, String nombre, double precio);

	public void borrarTipoProyeccion(String nombreTipo);
}
