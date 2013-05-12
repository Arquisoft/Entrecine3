package util.menu;

import util.BusinessException;


public class NotYetImplementedAction implements Action {

	@Override
	public void execute() throws BusinessException {
		System.err.println("Opción no implementada");
	}

}
