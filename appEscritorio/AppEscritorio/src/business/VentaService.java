package business;

import java.util.List;
import model.Venta;


public interface VentaService {
	
	public List<Venta> listarTodo();

	public Venta listarPorID(int id);

	public void guardarVenta(int idCliente, double precioTotal, String fechaVenta);

	public void borrarVenta(int id);

}
