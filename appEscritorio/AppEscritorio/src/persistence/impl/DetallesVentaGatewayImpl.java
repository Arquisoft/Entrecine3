package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DetallesVenta;
import persistence.DetallesVentaGateway;
import util.Jdbc;
import conf.Conf;

public class DetallesVentaGatewayImpl implements DetallesVentaGateway {
	
	private Connection connection;

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}

	@SuppressWarnings("finally")
	@Override
	public List<DetallesVenta> listAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<DetallesVenta> lista = new ArrayList<DetallesVenta>();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_ALL_DETALLES_VENTAS"));
			rs = pst.executeQuery();

			while (rs.next()) {
				DetallesVenta detallesVenta = new DetallesVenta();
				detallesVenta.setIdDetallesVenta(rs.getInt(1));
				detallesVenta.setIdProyeccion(rs.getInt(2));
				detallesVenta.setIdVenta(rs.getInt(3));
				detallesVenta.setButaca(rs.getInt(4));
				detallesVenta.setPrecio(rs.getDouble(5));
				lista.add(detallesVenta);
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
	public List<DetallesVenta> findByIdVenta(int idVenta) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<DetallesVenta> lista = new ArrayList<DetallesVenta>();		

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_DETALLES_VENTA_BY_ID_VENTA"));

			pst.setInt(1, idVenta);
			rs = pst.executeQuery();

			while (rs.next()) {
				DetallesVenta detallesVenta = new DetallesVenta();
				detallesVenta.setIdDetallesVenta(rs.getInt(1));
				detallesVenta.setIdProyeccion(rs.getInt(2));
				detallesVenta.setIdVenta(rs.getInt(3));
				detallesVenta.setButaca(rs.getInt(4));
				detallesVenta.setPrecio(rs.getDouble(5));
				lista.add(detallesVenta);
			}

			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			lista = null;
		} finally {
			Jdbc.close(rs, pst);
			return lista;
		}
	}

	@Override
	public void save(int idProyeccion, int idVentas, int butaca, double precio) throws SQLException {
		PreparedStatement pst = null;

		pst = connection.prepareStatement(Conf.get("SQL_ADD_DETALLES_VENTA"));

		pst.setInt(1,idProyeccion);
		pst.setInt(2,idVentas);
		pst.setInt(3,butaca);
		pst.setDouble(4,precio);

		pst.executeUpdate();

	}

	@Override
	public void deleteByIdVenta(int idVenta) throws SQLException {
		PreparedStatement pst = null;
		pst = connection.prepareStatement(Conf.get("SQL_DELETE_DETALLES_VENTA_BY_ID_VENTA"));
		pst.setInt(1,idVenta);

		pst.executeUpdate();

	}

}
