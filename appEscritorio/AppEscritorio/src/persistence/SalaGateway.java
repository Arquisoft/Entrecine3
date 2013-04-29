package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Sala;

public interface SalaGateway {
	
	public void setConnection(Connection connection);
	public List<Sala> findAll();
	public Sala findById(int id);
	public void save(int numSala, int numButacas, String tipoSala) throws SQLException;
	public void delete(Long id) throws SQLException;

}
