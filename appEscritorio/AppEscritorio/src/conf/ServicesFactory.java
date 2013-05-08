package conf;

import business.ClientService;
import business.DatosBancariosService;
import business.DetallesVentaService;
import business.PeliculaService;
import business.ProyeccionService;
import business.SalaService;
import business.TipoProyeccionService;
import business.VentaService;
import business.impl.ClientServiceImpl;
import business.impl.DatosBancariosServiceImpl;
import business.impl.DetallesVentaServiceImpl;
import business.impl.PeliculaServiceImpl;
import business.impl.ProyeccionServiceImpl;
import business.impl.SalaServiceImpl;
import business.impl.TipoProyeccionServiceImpl;
import business.impl.VentaServiceImpl;

public class ServicesFactory {
	
	public static ClientService getClientService(){
		return new ClientServiceImpl();
	}
	
	public static DatosBancariosService getDatosBancariosService(){
		return new DatosBancariosServiceImpl();
	}
	
	public static DetallesVentaService getDetallesVentaService(){
		return new DetallesVentaServiceImpl();
	}
	
	public static PeliculaService getPeliculaService(){
		return new PeliculaServiceImpl();
	}
	
	public static ProyeccionService getProyeccionService(){
		return new ProyeccionServiceImpl();
	}
	
	public static SalaService getSalaService(){
		return new SalaServiceImpl();
	}
	
	public static TipoProyeccionService getTipoProyeccionService(){
		return new TipoProyeccionServiceImpl();
	}
	
	public static VentaService getVentaService(){
		return new VentaServiceImpl();
	}

}
