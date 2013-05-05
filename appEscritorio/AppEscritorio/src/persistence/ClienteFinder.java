package persistence;

import model.Cliente;
import util.Jpa;

public class ClienteFinder {

	public static Cliente findById(int id) {
		return (Cliente) Jpa.getManager().createNamedQuery("Cliente.findById")
				.setParameter(1, id).getSingleResult();
	}

}
