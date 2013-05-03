package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.TipoProyeccion;

public interface TipoProyeccionGateway {

	public void setConnection(Connection connection);

	public List<TipoProyeccion> findAll();

	public TipoProyeccion findById(int id);

	public void save(String nombre, double precio) throws SQLException;

	public void update(int idTipoProyeccion, String nombre, double precio)
			throws SQLException;

	public void delete(String nombreTipo) throws SQLException;

}
