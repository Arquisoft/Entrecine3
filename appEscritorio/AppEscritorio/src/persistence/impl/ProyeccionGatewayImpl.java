package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Proyeccion;
import persistence.ProyeccionGateway;
import util.Jdbc;
import conf.Conf;

public class ProyeccionGatewayImpl implements ProyeccionGateway {

	private Connection connection;

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}

	@SuppressWarnings("finally")
	@Override
	public List<Proyeccion> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Proyeccion> lista = new ArrayList<Proyeccion>();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_ALL_PROYECCIONES"));
			rs = pst.executeQuery();

			while (rs.next()) {
				Proyeccion proyeccion = new Proyeccion();
				proyeccion.setIdProyeccion(rs.getInt(1));
				proyeccion.setIdPelicula(rs.getInt(2));
				proyeccion.setIdSala(rs.getInt(3));
				proyeccion.setFechaProyeccion(rs.getTimestamp(4));
				proyeccion.setTipoProyeccion(rs.getInt(5));
				lista.add(proyeccion);
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
	public Proyeccion findById(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Proyeccion proyeccion = new Proyeccion();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_PROYECCION_BY_ID"));

			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				proyeccion.setIdProyeccion(rs.getInt(1));
				proyeccion.setIdPelicula(rs.getInt(2));
				proyeccion.setIdSala(rs.getInt(3));
				proyeccion.setFechaProyeccion(rs.getTimestamp(4));
				proyeccion.setTipoProyeccion(rs.getInt(5));
			}

			return proyeccion;
		} catch (SQLException e) {
			e.printStackTrace();
			proyeccion = null;
		} finally {
			Jdbc.close(rs, pst);
			return proyeccion;
		}
	}

	@Override
	public void save(int idPelicula, int idSala, int dia_proyeccion,
			int mes_proyeccion, int anio_proyeccion, int hora_proyeccion,
			int minuto_proyeccion, int segundo_proyeccion, int tipoProyeccion)
			throws SQLException {

		PreparedStatement pst = null;

		pst = connection.prepareStatement(Conf.get("SQL_ADD_PROYECCION"));

		pst.setInt(1, idPelicula);
		pst.setInt(2, idSala);
		String fechaProyeccion = String.valueOf(anio_proyeccion + "-"
				+ mes_proyeccion + "-" + dia_proyeccion + " " + hora_proyeccion
				+ ":" + minuto_proyeccion + ":" + segundo_proyeccion);
		pst.setString(3, fechaProyeccion);
		pst.setInt(4, tipoProyeccion);

		pst.executeUpdate();

	}

	@Override
	public void delete(int idPelicula, int idSala, int tipoProyeccion) throws SQLException {
		PreparedStatement pst = null;
		pst = connection.prepareStatement(Conf.get("SQL_DELETE_PROYECCION"));

		pst.setInt(1, idPelicula);
		pst.setInt(2, idSala);
		pst.setInt(3, tipoProyeccion);
		pst.executeUpdate();

	}

}
