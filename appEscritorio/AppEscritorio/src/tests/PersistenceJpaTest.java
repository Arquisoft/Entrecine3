package tests;

import model.Cliente;

import org.junit.Test;

import persistence.ClienteFinder;
import util.Jpa;

public class PersistenceJpaTest {

	@Test
	public void findClientById() {
		Cliente c = ClienteFinder.findById(1);
		System.out.println(c);
	}

}
