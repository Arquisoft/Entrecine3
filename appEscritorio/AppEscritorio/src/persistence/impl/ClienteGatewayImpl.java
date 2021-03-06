package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import persistence.ClienteGateway;
import util.Jdbc;
import conf.Conf;

public class ClienteGatewayImpl implements ClienteGateway {

	private Connection connection;

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}

	@SuppressWarnings("finally")
	@Override
	public List<Cliente> findAll() {

		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Cliente> lista = new ArrayList<Cliente>();

		try {
			pst = connection.prepareStatement(Conf.get("SQL_FIND_ALL_CLIENTS"));
			rs = pst.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt(1));
				cliente.setDni(rs.getString(2));
				cliente.setNombre(rs.getString(3));
				cliente.setApellidos(rs.getString(4));
				cliente.setEmail(rs.getString(5));
				cliente.setFechaNacimiento(rs.getDate(6));
				lista.add(cliente);
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
	public Cliente findById(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Cliente cliente = new Cliente();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_CLIENTE_BY_ID"));

			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				cliente.setIdCliente(rs.getInt(1));
				cliente.setDni(rs.getString(2));
				cliente.setNombre(rs.getString(3));
				cliente.setApellidos(rs.getString(4));
				cliente.setEmail(rs.getString(5));
				cliente.setFechaNacimiento(rs.getDate(6));
			}

			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
			cliente = null;
		} finally {
			Jdbc.close(rs, pst);
			return cliente;
		}
	}

	@Override
	public void save(String dni, String nombre, String apellidos, String email,
			int dia_nacimiento, int mes_nacimiento, int anio_nacimiento)
			throws SQLException {
		PreparedStatement pst = null;

		pst = connection.prepareStatement(Conf.get("SQL_ADD_CLIENT"));

		pst.setString(1, dni);
		pst.setString(2, nombre);
		pst.setString(3, apellidos);
		pst.setString(4, email);
		pst.setString(
				5,
				String.valueOf(anio_nacimiento + "-" + mes_nacimiento + "-"
						+ dia_nacimiento));

		pst.executeUpdate();

	}

	@Override
	public void delete(String dni) {
		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(Conf.get("SQL_DELETE_CLIENT"));
			pst.setString(1, dni);

			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out
					.println("Error en ClienteGatewayImpl a la hora de borrar, m�todo delete.");
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Cliente findByDni(String dni) {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		ResultSet rs = null;
		Cliente cliente = new Cliente();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_CLIENTE_BY_DNI"));

			pst.setString(1, dni);
			rs = pst.executeQuery();

			while (rs.next()) {
				cliente.setIdCliente(rs.getInt(1));
				cliente.setDni(rs.getString(2));
				cliente.setNombre(rs.getString(3));
				cliente.setApellidos(rs.getString(4));
				cliente.setEmail(rs.getString(5));
				cliente.setFechaNacimiento(rs.getDate(6));
			}

			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
			cliente = null;
		} finally {
			Jdbc.close(rs, pst);
			return cliente;
		}
	}

	@Override
	public void update(int idCliente, String dni, String nombre,
			String apellidos, String email, int dia_nacimiento,
			int mes_nacimiento, int anio_nacimiento) {
		PreparedStatement pst = null;

		try {
			pst = connection.prepareStatement(Conf.get("SQL_UPDATE_CLIENT"));
			pst.setString(1, dni);
			pst.setString(2, nombre);
			pst.setString(3, apellidos);
			pst.setString(4, email);
			pst.setString(
					5,
					String.valueOf(anio_nacimiento + "-" + mes_nacimiento + "-"
							+ dia_nacimiento));
			pst.setInt(6, idCliente);

			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out
					.println("Error en ClienteGatewayImpl a la hora de UPDATE");
		}

	}

}
