package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
* Clase del modelo que representa una proyección en el dominio
* @author Project Team Entrecine3
*
*/
@Entity
@Table(name="TProyecciones")
public class Proyeccion extends Model {

@Id @GeneratedValue @Column(name="idProyecciones")private int idProyeccion;
//@Column(name="idPeliculas")private int idPelicula;
//@Column(name="idSalas")private int idSala;
//@Column(name="idTipoProyeccion")private int idTipoProyeccion;
//@Column(name="fechaProyeccion")
@Temporal(TemporalType.TIMESTAMP)private Date fechaProyeccion;

@ManyToOne @JoinColumn(name="idPeliculas") private Pelicula pelicula;
@ManyToOne @JoinColumn(name="idSalas") private Sala sala;
@ManyToOne @JoinColumn(name="idTipoProyeccion") private TipoProyeccion tipoProyeccion;


private static Finder<Long,Proyeccion> find = new Finder(Long.class, Proyeccion.class);

/**
* Constructor por omisión
*/
public Proyeccion(){

}

public Proyeccion(Date fechaProyeccion){
this.fechaProyeccion = fechaProyeccion;
}

public static List<Proyeccion> proyeccionesPorPelicula(Integer idPelicula){
	//return find.where().ilike("c2", idPelicula.toString()).findList();
	return find.all();
	
}

public int getIdProyeccion() {
return idProyeccion;
}
public void setIdProyeccion(int idProyeccion) {
this.idProyeccion = idProyeccion;
}

/*public int getIdPelicula() {
return idPelicula;
}
public void setIdPelicula(int idPelicula) {
this.idPelicula = idPelicula;
}
public int getIdSala() {
return idSala;
}
public void setIdSala(int idSala) {
this.idSala = idSala;
}
public int getTipoProyeccion() {
return idTipoProyeccion;
}
public void setTipoProyeccion(int tipoProyeccion) {
this.idTipoProyeccion = tipoProyeccion;
}*/
public Date getFechaProyeccion() {
return fechaProyeccion;
}
public void setFechaProyeccion(Date fechaProyeccion) {
this.fechaProyeccion = fechaProyeccion;
}

public Pelicula getPelicula() {
return pelicula;
}

public void setPelicula(Pelicula pelicula) {
this.pelicula = pelicula;
}

public Sala getSala() {
return sala;
}

public void setSala(Sala sala) {
this.sala = sala;
}

public TipoProyeccion getTipoProyeccion() {
return tipoProyeccion;
}

public void setTipoProyeccion(TipoProyeccion tipoProyeccion) {
this.tipoProyeccion = tipoProyeccion;
}



@Override
public String toString() {
return "Proyeccion [idProyeccion=" + idProyeccion
+ ", fechaProyeccion=" + fechaProyeccion + ", pelicula="
+ pelicula + ", sala=" + sala + ", tipoProyeccion="
+ tipoProyeccion + "]";
}

/*@Override
public String toString() {
return "Proyeccion [idProyeccion=" + idProyeccion + ", idPelicula="
+ idPelicula + ", idSala=" + idSala + ", tipoProyeccion="
+ idTipoProyeccion + ", fechaProyeccion=" + fechaProyeccion + "]";
}*/

}