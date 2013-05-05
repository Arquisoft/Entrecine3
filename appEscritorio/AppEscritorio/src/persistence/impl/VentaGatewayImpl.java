package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Venta;
import persistence.VentaGateway;
import util.Jdbc;
import conf.Conf;

public class VentaGatewayImpl implements VentaGateway {
	
	private Connection connection;

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}

	@SuppressWarnings("finally")
	@Override
	public List<Venta> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Venta> lista = new ArrayList<Venta>();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_ALL_VENTAS"));
			rs = pst.executeQuery();

			while (rs.next()) {
				Venta venta = new Venta();
				venta.setIdVenta(rs.getInt(1));
				venta.setIdCliente(rs.getInt(2));
				venta.setPrecioTotal(rs.getDouble(3));
				venta.setFechaVenta(rs.getTimestamp(4));
				lista.add(venta);
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
	public Venta findById(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Venta venta = new Venta();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_VENTA_BY_ID"));

			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				venta.setIdVenta(rs.getInt(1));
				venta.setIdCliente(rs.getInt(2));
				venta.setPrecioTotal(rs.getDouble(3));
				venta.setFechaVenta(rs.getTimestamp(4));
			}

			return venta;
		} catch (SQLException e) {
			e.printStackTrace();
			venta = null;
		} finally {
			Jdbc.close(rs, pst);
			return venta;
		}
	}

	@Override
	public void save(int idCliente, double precioTotal, String fechaVenta)
			throws SQLException {
		PreparedStatement pst = null;

		pst = connection.prepareStatement(Conf.get("SQL_ADD_VENTA"));

		pst.setInt(1,idCliente);
		pst.setDouble(2, precioTotal);
		pst.setString(3, fechaVenta);
		
		pst.executeUpdate();

	}

	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement pst = null;
		pst = connection.prepareStatement(Conf
				.get("SQL_DELETE_VENTA"));

		pst.setInt(1, id);
		pst.executeUpdate();

	}

}
