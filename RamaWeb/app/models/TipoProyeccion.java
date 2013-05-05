package models;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
* Clase del modelo que representa los tipos de proyección
* @author Project Team Entrecine3
*
*/
@Entity
@Table(name="TTipo_Proyeccion")
public class TipoProyeccion {

@Id @GeneratedValue @Column(name="idTipoProyeccion")private int idTipoProyeccion;
private String nombre;
private double precio;

@OneToMany(mappedBy="tipoProyeccion") private Set<Proyeccion> proyeccion;

public TipoProyeccion(){ }

public TipoProyeccion(String nombre) {
super();
this.nombre = nombre;
}

public TipoProyeccion(String nombre, double precio) {
super();
this.nombre = nombre;
this.precio = precio;
}

public void addProyeccion(Proyeccion proyeccion){
this.proyeccion.add(proyeccion);
proyeccion.setTipoProyeccion(this);
}

public void removeProyeccion(Proyeccion proyeccion){
this.proyeccion.remove(proyeccion);
proyeccion.setTipoProyeccion(null);
}

public int getIdTipoProyeccion() {
return idTipoProyeccion;
}
public void setIdTipoProyeccion(int idTipoProyeccion) {
this.idTipoProyeccion = idTipoProyeccion;
}
public String getNombre() {
return nombre;
}
public void setNombre(String nombre) {
this.nombre = nombre;
}
public double getPrecio() {
return precio;
}
public void setPrecio(double precio) {
this.precio = precio;
}

public Set<Proyeccion> getProyeccion() {
return Collections.unmodifiableSet(proyeccion);
}

Set<Proyeccion> _getProyeccion(){
return proyeccion;
}

@Override
public String toString() {
return "TipoProyeccion [idTipoProyeccion=" + idTipoProyeccion
+ ", nombre=" + nombre + ", precio=" + precio + "]";
}


}