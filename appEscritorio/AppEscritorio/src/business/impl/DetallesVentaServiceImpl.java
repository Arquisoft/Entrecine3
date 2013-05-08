package business.impl;

import java.util.List;
import model.DetallesVenta;
import business.DetallesVentaService;
import business.impl.detallesVenta.BorrarDetallesVenta;
import business.impl.detallesVenta.GuardarDetallesVenta;
import business.impl.detallesVenta.ListarPorID;
import business.impl.detallesVenta.ListarTodos;

public class DetallesVentaServiceImpl implements DetallesVentaService{

	@Override
	public void addDetallesVenta(int idProyeccion, int idVentas, int butaca,
			double precio) {
		new GuardarDetallesVenta(idProyeccion, idVentas, butaca, precio).execute();	
	}

	@Override
	public void deleteDetallesVenta(int idVenta) {
		new BorrarDetallesVenta(idVenta).execute();		
	}

	@Override
	public List<DetallesVenta> listarTodo() {
		List<DetallesVenta> lista = new ListarTodos().execute();
		return lista;
	}

	@Override
	public List<DetallesVenta> listarPorId(int idVenta) {
		List<DetallesVenta> lista = new ListarPorID().execute(idVenta);
		return lista;
	}

	

}
