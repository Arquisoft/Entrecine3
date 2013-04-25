package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Pelicula;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
	
	static List<Pelicula> pelis = new ArrayList<Pelicula>();
  
    public static Result index() {
        //return ok(index.render("Hola mundo!")); //utiliza la plantilla app/views/index.scala.html
    	//return ok("Hola mundo!");
    	return redirect(routes.Application.peliculas());
    }
    
    public static Result peliculas(){
    	pelis.add(new Pelicula("pelicula1", 10));
    	return ok(index.render(pelis));
    }
    
    public static Result comprarEntrada(){
    	pelis.get(0).comprar();
    	return redirect(routes.Application.peliculas());
    }
  
}
