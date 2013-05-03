package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Pelicula;

public interface PeliculaGateway {

	public void setConnection(Connection connection);

	public List<Pelicula> findAll();

	public Pelicula findById(int id);

	public void save(String titulo, String duracion, String genero,
			String descripcion, String imagen) throws SQLException;

	public void update(int idPelicula, String titulo, String duracion,
			String genero, String descripcion, String imagen)
			throws SQLException;

	public void delete(String titulo) throws SQLException;

}
