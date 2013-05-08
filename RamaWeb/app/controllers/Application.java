package controllers;

import models.Pelicula;
import play.mvc.Controller;
import play.mvc.Result;


public class Application extends Controller {
  
    public static Result  index() {
    	return redirect(routes.Application.peliculas());
    }
    
    public static Result peliculas(){
    	return ok(views.html.index.render(Pelicula.all()));
    }
    
    public static Result comprarEntradas(Integer idPelicula){
    	return ok(views.html.comprarEntradas.render(idPelicula));
    }
    
    public static Result confirmarCompra(){
    	String fecha = Controller.request().getQueryString("fecha");
    	String correo = Controller.request().getQueryString("correo");
    	String butaca = Controller.request().getQueryString("butaca");
    	return ok(views.html.confirmarCompra.render(fecha, correo, butaca));
    }
    
  
}
