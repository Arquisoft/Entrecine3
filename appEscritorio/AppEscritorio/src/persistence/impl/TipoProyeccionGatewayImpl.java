package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TipoProyeccion;
import persistence.TipoProyeccionGateway;
import util.Jdbc;
import conf.Conf;

public class TipoProyeccionGatewayImpl implements TipoProyeccionGateway {

	private Connection connection;

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}

	@SuppressWarnings("finally")
	@Override
	public List<TipoProyeccion> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TipoProyeccion> lista = new ArrayList<TipoProyeccion>();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_ALL_TIPO_PROYECCION"));
			rs = pst.executeQuery();

			while (rs.next()) {
				TipoProyeccion tipoProyeccion = new TipoProyeccion();
				tipoProyeccion.setIdTipoProyeccion(rs.getInt(1));
				tipoProyeccion.setNombre(rs.getString(2));
				tipoProyeccion.setPrecio(rs.getFloat(3));
				lista.add(tipoProyeccion);
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
	public TipoProyeccion findById(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		TipoProyeccion tipoProyeccion = new TipoProyeccion();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_TIPO_PROYECCION_BY_ID"));

			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				tipoProyeccion.setIdTipoProyeccion(rs.getInt(1));
				tipoProyeccion.setNombre(rs.getString(2));
				tipoProyeccion.setPrecio(rs.getFloat(3));
			}

			return tipoProyeccion;
		} catch (SQLException e) {
			e.printStackTrace();
			tipoProyeccion = null;
		} finally {
			Jdbc.close(rs, pst);
			return tipoProyeccion;
		}
	}

	@Override
	public void save(String nombre, float precio) throws SQLException {
		PreparedStatement pst = null;

		pst = connection.prepareStatement(Conf.get("SQL_ADD_TIPO_PROYECCION"));

		pst.setString(1, nombre);
		pst.setFloat(2, precio);

		pst.executeUpdate();

	}

	@Override
	public void delete(Long id) throws SQLException {

		PreparedStatement pst = null;
		pst = connection.prepareStatement(Conf
				.get("SQL_DELETE_TIPO_PROYECCION"));

		pst.setLong(1, id);
		pst.executeUpdate();

	}

}
