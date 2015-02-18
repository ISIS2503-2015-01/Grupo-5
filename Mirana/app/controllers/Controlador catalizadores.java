package controllers;

import play.*;
import play.mvc.*;
import models.Catalizadores;
import play.data.Form;


import views.html.*;

public class Catalizadores controlador extends Controller {

    public static Result index() {
        return ok(index.render("catalizador"));
    } 

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public static Result crear(){

     }

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public static Result actualizar(Long catalizadorID){

     }

    @Transactional
     public static Result borrar(Long catalizadorID){
     	
     } 

    @Transactional
     public static Result darEpisodio(Long catalizadorID){
     	
     }    


}
