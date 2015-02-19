package controllers;


import play.data.Form;
import play.mvc.Controller;
import play.mvc.*;


public class ControladorEpisodio extends Controller 
{

 public static Result addEpisodio()
 {
 	Episodio epi = Form.form(Episodio.class).bindFormRequest().get();
 	epi.save();
 	return redirect(routes.aplication.index());
 }

public static Result deleteEpisodio()
{

}













}