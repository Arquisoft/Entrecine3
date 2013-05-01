package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase del modelo que representa una sala en el dominio
 * @author Project Team Entrecine3
 *
 */
@Entity
@Table(name="TSalas")
public class Sala {
	
	@Id @GeneratedValue private int idSala;
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
	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", numSala=" + numSala
				+ ", numButacas=" + numButacas + ", tipoSala=" + tipoSala + "]";
	}
	
}
