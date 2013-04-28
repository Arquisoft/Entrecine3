package model;

/**
 * Clase del modelo que representa una sala en el dominio
 * @author Project Team Entrecine3
 *
 */
public class Salas {
	
	private int idSala;
	private int numSala;
	private int numButacas;
	private String tipoSala;
	
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public int getNumSala() {
		return numSala;
	}
	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}
	public int getNumButacas() {
		return numButacas;
	}
	public void setNumButacas(int numButacas) {
		this.numButacas = numButacas;
	}
	public String getTipoSala() {
		return tipoSala;
	}
	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

}
