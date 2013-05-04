package model;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase del modelo que representa una sala en el dominio
 * @author Project Team Entrecine3
 *
 */
@Entity
@Table(name="TSalas")
public class Sala {
	
	@Id @GeneratedValue @Column(name="idSalas")private int idSala;
	private int numSala;
	private int numButacas;
	private String tipoSala;
	
	@OneToMany(mappedBy="sala") private Set<Proyeccion> proyeccion;
	
	public Sala(){}
	
	public Sala(int numSala){
		super();
		this.numSala = numSala;
	}
	
	public Sala(int numSala, int numButacas, String tipoSala) {
		super();
		this.numSala = numSala;
		this.numButacas = numButacas;
		this.tipoSala = tipoSala;
	}
	
	public void addProyeccion(Proyeccion proyeccion){
		this.proyeccion.add(proyeccion);
		proyeccion.setSala(this);
	}
	
	public void removeProyeccion(Proyeccion proyeccion){
		this.proyeccion.remove(proyeccion);
		proyeccion.setSala(null);
	}

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
	public Set<Proyeccion> getProyeccion() {
		return Collections.unmodifiableSet(proyeccion);
	}
	
	Set<Proyeccion> _getProyeccion(){
		return proyeccion;
	}

	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", numSala=" + numSala
				+ ", numButacas=" + numButacas + ", tipoSala=" + tipoSala + "]";
	}
	
}
