package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.TipoProyeccion;

public interface TipoProyeccionGateway {
	
	public void setConnection(Connection connection);
	public List<TipoProyeccion> findAll();
	public TipoProyeccion findById(int id);
	public void save(String nombre, float precio) throws SQLException;
	public void delete(Long id) throws SQLException;

}
