package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Pelicula;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
  
    public static Result index() {
        //return ok(index.render("Hola mundo!")); //utiliza la plantilla app/views/index.scala.html
    	//return ok("Hola mundo!");
    	return redirect(routes.Application.peliculas());
    }
    
    public static Result peliculas(){
    	return ok(index.render(Pelicula.all(), formularioPelicula));
    }
    
    public static Result nuevaPelicula(){
    	Form<Pelicula> filledForm = formularioPelicula.bindFromRequest();
    	  if(filledForm.hasErrors()) {
    	    return badRequest(
    	      views.html.index.render(Pelicula.all(), filledForm)
    	    );
    	  } else {
    		  Pelicula.crearPelicula(filledForm.get());
    	    return redirect(routes.Application.peliculas());  
    	  }
    }
    
    public static Result borrar(Long id){
    	return TODO;
    }
    
    static List<Pelicula> pelis = new ArrayList<Pelicula>();
	static Form<Pelicula> formularioPelicula = Form.form(Pelicula.class);
  
}
