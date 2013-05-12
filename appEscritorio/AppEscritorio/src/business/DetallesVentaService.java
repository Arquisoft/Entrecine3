package business;

import java.util.List;

import model.DetallesVenta;

public interface DetallesVentaService {
	
	public void addDetallesVenta(int idProyeccion, int idVentas, int butaca, double precio);
	
	public void deleteDetallesVenta(int idVenta);
	
	public List<DetallesVenta> listarTodo();
	
	public List<DetallesVenta> listarPorId(int idVenta);
}
