package controllers;

import models.Pelicula;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;


public class Application extends Controller {
  
    public static Result index() {
        //return ok(index.render("Hola mundo!")); //utiliza la plantilla app/views/index.scala.html
    	//return ok("Hola mundo!");
    	return redirect(routes.Application.peliculas());
    }
    
    public static Result peliculas(){
    	return ok(views.html.index.render(Pelicula.all(), formularioPelicula));
    }
    
    public static Result nuevaPelicula(){
    	Form<Pelicula> filledForm = formularioPelicula.bindFromRequest();
    	  if(filledForm.hasErrors()) {
    	    return ok(filledForm.errorsAsJson().toString());
    		  //return badRequest(views.html.index.render(Pelicula.all(), filledForm));
    	  } else {
    		  Pelicula.crearPelicula(filledForm.get());
    	    return redirect(routes.Application.peliculas());  
    	  }
    	  
    }
    
    public static Result borrar(Long id){
    	return TODO;
    }
    
	public static Form<Pelicula> formularioPelicula = Form.form(Pelicula.class);
  
}
