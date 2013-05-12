package business.impl;

import java.util.List;
import model.Venta;
import business.VentaService;
import business.impl.venta.BorrarVenta;
import business.impl.venta.GuardarVenta;
import business.impl.venta.ListarPorID;
import business.impl.venta.ListarTodos;

public class VentaServiceImpl implements VentaService{

	@Override
	public List<Venta> listarTodo() {
		List<Venta> lista = new ListarTodos().execute();
		return lista;
	}

	@Override
	public Venta listarPorID(int id) {
		Venta venta = new ListarPorID().execute(id);
		return venta;
	}

	@Override
	public void guardarVenta(int idCliente, double precioTotal,
			String fechaVenta) {
		new GuardarVenta(idCliente, precioTotal, fechaVenta);
		
	}

	@Override
	public void borrarVenta(int id) {
		new BorrarVenta(id);
		
	}

}
