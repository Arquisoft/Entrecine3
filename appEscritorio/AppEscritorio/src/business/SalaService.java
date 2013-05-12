package business;

import java.util.List;

import model.Sala;

public interface SalaService {
	
	public List<Sala> listarTodo();

	public Sala listarPorID(int id);

	public void guardarSala(int numSala, int numButacas, String tipoSala);

	public void actualizarSala(int idSala, int numSala, int numButacas, String tipoSala);

	public void borrarSala(int numSala);

}
