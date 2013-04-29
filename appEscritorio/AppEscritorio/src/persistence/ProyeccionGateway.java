package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import model.Proyeccion;

public interface ProyeccionGateway {
	
	public void setConnection(Connection connection);
	public List<Proyeccion> findAll();
	public Proyeccion findById(int id);
	public void save(int idPelicula, int idSala, Timestamp fechaProyeccion, int tipoProyeccion) throws SQLException;
	public void delete(Long id) throws SQLException;

}
