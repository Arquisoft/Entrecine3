package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pelicula;
import persistence.PeliculaGateway;
import util.Jdbc;
import conf.Conf;

public class PeliculaGatewayImpl implements PeliculaGateway {

	private Connection connection;

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@SuppressWarnings("finally")
	@Override
	public List<Pelicula> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Pelicula> lista = new ArrayList<Pelicula>();

		try {
			pst = connection.prepareStatement(Conf.get("SQL_FIND_ALL_MOVIES"));
			rs = pst.executeQuery();

			while (rs.next()) {
				Pelicula pelicula = new Pelicula();
				pelicula.setIdPelicula(rs.getInt(1));
				pelicula.setTitulo(rs.getString(2));
				pelicula.setDuracion(rs.getTime(3));
				pelicula.setGenero(rs.getString(4));
				pelicula.setDescripcion(rs.getString(5));
				pelicula.setUrlImagen(rs.getString(6));
				lista.add(pelicula);
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lista = null;
		} finally {
			Jdbc.close(rs, pst);
			return lista;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Pelicula findById(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Pelicula pelicula = new Pelicula();

		try {
			pst = connection.prepareStatement(Conf.get("SQL_FIND_MOVIE_BY_ID"));

			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				pelicula.setIdPelicula(rs.getInt(1));
				pelicula.setTitulo(rs.getString(2));
				pelicula.setDuracion(rs.getTime(3));
				pelicula.setGenero(rs.getString(4));
				pelicula.setDescripcion(rs.getString(5));
				pelicula.setUrlImagen(rs.getString(6));
			}

			return pelicula;
		} catch (SQLException e) {
			e.printStackTrace();
			pelicula = null;
		} finally {
			Jdbc.close(rs, pst);
			return pelicula;
		}
	}

	@Override
	public void save(String titulo, String duracion, String genero,
			String descripcion, String imagen) throws SQLException {
		PreparedStatement pst = null;

		pst = connection.prepareStatement(Conf.get("SQL_ADD_MOVIE"));

		pst.setString(1, titulo);
		pst.setString(2, duracion);
		pst.setString(3, genero);
		pst.setString(4, descripcion);
		pst.setString(5, imagen);

		pst.executeUpdate();
	}

	@Override
	public void delete(String titulo) throws SQLException {
		PreparedStatement pst = null;
		pst = connection.prepareStatement(Conf.get("SQL_DELETE_MOVIE"));
		pst.setString(1, titulo);

		pst.executeUpdate();
	}

	@Override
	public void update(int idPelicula, String titulo, String duracion,
			String genero, String descripcion, String imagen)
			throws SQLException {

		PreparedStatement pst = null;

		pst = connection.prepareStatement(Conf.get("SQL_UPDATE_PELICULA"));
		pst.setString(1, titulo);
		pst.setString(2, duracion);
		pst.setString(3, genero);
		pst.setString(4, descripcion);
		pst.setString(5, imagen);
		pst.setInt(6, idPelicula);

		pst.executeUpdate();

	}

}
