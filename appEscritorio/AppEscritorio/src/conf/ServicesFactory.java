package conf;

import business.ClientService;
import business.impl.ClientServiceImpl;

public class ServicesFactory {
	
	public static ClientService getClientService(){
		return new ClientServiceImpl();
	}

}
