package conf;

import persistence.ClienteGateway;
import persistence.DatosBancariosGateway;
import persistence.PeliculaGateway;
import persistence.ProyeccionGateway;
import persistence.SalaGateway;
import persistence.TipoProyeccionGateway;
import persistence.impl.ClienteGatewayImpl;
import persistence.impl.DatosBancariosGatewayImpl;
import persistence.impl.PeliculaGatewayImpl;
import persistence.impl.ProyeccionGatewayImpl;
import persistence.impl.SalaGatewayImpl;
import persistence.impl.TipoProyeccionGatewayImpl;

/**
 * Factoría de persistencia
 * @author Project Team Entrecine
 */
public class PersistenceFactory {
	
	/**
	 * Devuelve una instancia de ClienteGateway
	 * @return ClienteGatewayImpl
	 */
	public static ClienteGateway getClienteGateway(){
		return new ClienteGatewayImpl();
	}
	
	/**
	 * Devuelve una instancia de DatosBancariosGateway
	 * @return DatosBancariosGatewayImpl
	 */
	public static DatosBancariosGateway getDatosBancariosGateway(){
		return new DatosBancariosGatewayImpl();
	}
	
	/**
	 * Devueulve una instancia de PeliculaGateway
	 * @return PeliculaGatewayImpl
	 */
	public static PeliculaGateway getPeliculaGateway(){
		return new PeliculaGatewayImpl();
	}
	
	/**
	 * Devuelve una instancia de ProyeccionGateway
	 * @return ProyeccionGatewayImpl
	 */
	public static ProyeccionGateway getProyeccionGateway(){
		return new ProyeccionGatewayImpl();
	}
	
	/**
	 * Devuelve una instancia de SalaGateway
	 * @return SalaGatewayImpl
	 */
	public static SalaGateway getSalaGateway(){
		return new SalaGatewayImpl();
	}
	
	/**
	 * Devuelve una instancia de TipoProyeccionGateway
	 * @return TipoProyeccionGatewayImpl
	 */
	public static TipoProyeccionGateway getTipoProyeccionGateway(){
		return new TipoProyeccionGatewayImpl();
	}

}
