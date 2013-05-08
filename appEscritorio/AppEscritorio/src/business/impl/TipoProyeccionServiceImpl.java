package business.impl;

import java.util.List;

import model.TipoProyeccion;
import business.TipoProyeccionService;
import business.impl.tipoProyeccion.ActualizarTipoProyeccion;
import business.impl.tipoProyeccion.BorrarTipoProyeccion;
import business.impl.tipoProyeccion.GuardarTipoProyeccion;
import business.impl.tipoProyeccion.ListarPorID;
import business.impl.tipoProyeccion.ListarTodos;

public class TipoProyeccionServiceImpl implements TipoProyeccionService{

	@Override
	public List<TipoProyeccion> listarTodo() {
		List<TipoProyeccion> lista = new ListarTodos().execute();
		return lista;
	}

	@Override
	public TipoProyeccion listarPorID(int id) {
		TipoProyeccion tipo = new ListarPorID().execute(id);
		return tipo;
	}

	@Override
	public void guardarTipoProyeccion(String nombre, double precio) {
		new GuardarTipoProyeccion(nombre, precio).execute();
		
	}

	@Override
	public void actualizarTipoProyeccion(int idTipoProyeccion, String nombre,
			double precio) {
		new ActualizarTipoProyeccion(idTipoProyeccion, nombre, precio).execute();
		
	}

	@Override
	public void borrarTipoProyeccion(String nombreTipo) {
		new BorrarTipoProyeccion(nombreTipo).execute();
		
	}

}
