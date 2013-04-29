package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.DatosBancarios;
import persistence.DatosBancariosGateway;
import util.Jdbc;
import conf.Conf;

public class DatosBancariosGatewayImpl implements DatosBancariosGateway {

	private Connection connection;

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@SuppressWarnings("finally")
	@Override
	public List<DatosBancarios> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<DatosBancarios> lista = new ArrayList<DatosBancarios>();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_ALL_DATOS_BANCARIOS"));
			rs = pst.executeQuery();

			while (rs.next()) {
				DatosBancarios datosBancarios = new DatosBancarios();
				datosBancarios.setIdDatosBancarios(rs.getInt(1));
				datosBancarios.setIdCliente(rs.getInt(2));
				datosBancarios.setNumTarjeta(rs.getInt(3));
				datosBancarios.setNombre(rs.getString(4));
				datosBancarios.setApellidos(rs.getString(5));
				datosBancarios.setPin(rs.getInt(6));
				datosBancarios.setFechaCaducidad(rs.getDate(7));
				lista.add(datosBancarios);
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
	public DatosBancarios findById(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		DatosBancarios datosBancarios = new DatosBancarios();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_DATOS_BANCARIOS_BY_ID"));

			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				datosBancarios.setIdDatosBancarios(rs.getInt(1));
				datosBancarios.setIdCliente(rs.getInt(2));
				datosBancarios.setNumTarjeta(rs.getInt(3));
				datosBancarios.setNombre(rs.getString(4));
				datosBancarios.setApellidos(rs.getString(5));
				datosBancarios.setPin(rs.getInt(6));
				datosBancarios.setFechaCaducidad(rs.getDate(7));
			}

			return datosBancarios;
		} catch (SQLException e) {
			e.printStackTrace();
			datosBancarios = null;
		} finally {
			Jdbc.close(rs, pst);
			return datosBancarios;
		}
	}

	@Override
	public void save(int idCliente, int numTarjeta, String nombre,
			String apellidos, int pin, Date fechaCaducidad) throws SQLException {

		PreparedStatement pst = null;

		pst = connection.prepareStatement(Conf.get("SQL_ADD_DATOS_BANCARIOS"));

		pst.setInt(1, idCliente);
		pst.setInt(2, numTarjeta);
		pst.setString(3, nombre);
		pst.setString(4, apellidos);
		pst.setInt(5, pin);
		pst.setString(6, converUtilDateToSqlDate(fechaCaducidad));

		pst.executeUpdate();

	}

	private String converUtilDateToSqlDate(java.util.Date utilDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = sdf.format(utilDate);
		return sqlDate;
	}

	@Override
	public void delete(Long id) {
		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_DELETE_DATOS_BANCARIOS"));
			pst.setLong(1, id);

			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out
					.println("Error en DatosBancariosGatewayImpl a la hora de borrar, m�todo delete.");
		}

	}

}
