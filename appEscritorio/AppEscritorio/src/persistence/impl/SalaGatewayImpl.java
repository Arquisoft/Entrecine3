package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Sala;
import persistence.SalaGateway;
import util.Jdbc;
import conf.Conf;

public class SalaGatewayImpl implements SalaGateway{
	
	private Connection connection;

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
		
	}

	@SuppressWarnings("finally")
	@Override
	public List<Sala> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Sala> lista = new ArrayList<Sala>();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_ALL_SALAS"));
			rs = pst.executeQuery();

			while (rs.next()) {
				Sala sala = new Sala();
				sala.setIdSala(rs.getInt(1));
				sala.setNumSala(rs.getInt(2));
				sala.setNumButacas(rs.getInt(3));
				sala.setTipoSala(rs.getString(4));
				lista.add(sala);
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
	public Sala findById(int id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Sala sala = new Sala();

		try {
			pst = connection.prepareStatement(Conf
					.get("SQL_FIND_SALA_BY_ID"));

			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				sala.setIdSala(rs.getInt(1));
				sala.setNumSala(rs.getInt(2));
				sala.setNumButacas(rs.getInt(3));
				sala.setTipoSala(rs.getString(4));
			}

			return sala;
		} catch (SQLException e) {
			e.printStackTrace();
			sala = null;
		} finally {
			Jdbc.close(rs, pst);
			return sala;
		}
	}

	@Override
	public void save(int numSala, int numButacas, String tipoSala)
			throws SQLException {
		
		PreparedStatement pst = null;

		pst = connection.prepareStatement(Conf.get("SQL_ADD_SALA"));

		pst.setInt(1, numSala);
		pst.setInt(2, numButacas);
		pst.setString(3, tipoSala);

		pst.executeUpdate();
		
	}

	@Override
	public void delete(int numSala) throws SQLException {
		PreparedStatement pst = null;
		pst = connection.prepareStatement(Conf
				.get("SQL_DELETE_SALA"));

		pst.setInt(1, numSala);
		pst.executeUpdate();
		
	}

}
