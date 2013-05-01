package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Proyeccion;

public interface ProyeccionGateway {

	public void setConnection(Connection connection);

	public List<Proyeccion> findAll();

	public Proyeccion findById(int id);

	public void save(int idPelicula, int idSala, int dia_proyeccion,
			int mes_proyeccion, int anio_proyeccion, int hora_proyeccion,
			int minuto_proyeccion, int segundo_proyeccion, int tipoProyeccion)
			throws SQLException;

	public void delete(int idPelicula, int idSala, int tipoProyeccion) throws SQLException;

}
