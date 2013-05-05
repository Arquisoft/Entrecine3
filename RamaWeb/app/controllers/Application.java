package controllers;

import models.Pelicula;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;


public class Application extends Controller {
  
    public static Result  index() {
    	return redirect(routes.Application.peliculas());
    }
    
    public static Result peliculas(){
    	return ok(views.html.index.render(Pelicula.all(), formularioPelicula));
    }
    
    public static Result comprarEntradas(){
    	return TODO;
    }
    
    public static Result nuevaPelicula(){
    	/*Form<Pelicula> filledForm = formularioPelicula.bindFromRequest();
    	  if(filledForm.hasErrors()) {
    	    return ok(filledForm.errorsAsJson().toString());
    		  //return badRequest(views.html.index.render(Pelicula.all(), filledForm));
    	  } else {
    		  Pelicula.crearPelicula(filledForm.get());
    	    return redirect(routes.Application.peliculas());  
    	  }
    	  */
    	return ok("En la aplicacion web no se hacen tareas de administracion");
    }
    
	public static Form<Pelicula> formularioPelicula = Form.form(Pelicula.class);
  
}
