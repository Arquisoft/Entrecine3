package model;


/**
 * Clase del modelo que representa los detalles de la venta del dominio
 * @author Project Team Entrecine3
 *
 */
public class DetallesVenta {
	
	private int idDetallesVenta;
	private int idVenta;
	private int idProyeccion;
	private int butaca;
	private float precio;
	
	/**
	 * Constructor parametrizado con los índices necesarios
	 * @param idVenta
	 * @param idProyeccion
	 */
	public DetallesVenta(int idVenta, int idProyeccion) {
		super();
		this.idVenta = idVenta;
		this.idProyeccion = idProyeccion;
	}
	
	public int getIdDetallesVenta() {
		return idDetallesVenta;
	}
	public void setIdDetallesVenta(int idDetallesVenta) {
		this.idDetallesVenta = idDetallesVenta;
	}
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdProyeccion() {
		return idProyeccion;
	}
	public void setIdProyeccion(int idProyeccion) {
		this.idProyeccion = idProyeccion;
	}
	public int getButaca() {
		return butaca;
	}
	public void setButaca(int butaca) {
		this.butaca = butaca;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
