package business.impl;

import java.util.List;

import business.SalaService;
import business.impl.sala.ActualizarSala;
import business.impl.sala.BorrarSala;
import business.impl.sala.GuardarSala;
import business.impl.sala.ListarPorID;
import business.impl.sala.ListarTodos;

import model.Sala;

public class SalaServiceImpl implements SalaService {

	@Override
	public List<Sala> listarTodo() {
		List<Sala> lista = new ListarTodos().execute();
		return lista;
	}

	@Override
	public Sala listarPorID(int id) {
		Sala sala = new ListarPorID().execute(id);
		return sala;
	}

	@Override
	public void guardarSala(int numSala, int numButacas, String tipoSala) {
		new GuardarSala(numSala, numButacas, tipoSala).execute();

	}

	@Override
	public void actualizarSala(int idSala, int numSala, int numButacas,
			String tipoSala) {
		new ActualizarSala(idSala, numSala, numButacas, tipoSala).execute();

	}

	@Override
	public void borrarSala(int numSala) {
		new BorrarSala(numSala).execute();

	}

}
