package controllers;


import play.data.Form;
import play.mvc.Controller;
import play.mvc.*;
import models.Episodio;


public class ControladorEpisodio extends Controller 
{

 public static Result addEpisodio()
 {
 	Episodio epi = Form.form(Episodio.class).bindFormRequest().get();
 	epi.save();
 	return redirect(routes.aplication.index());
 }

public static Result getEpisodio()
{
    List<Episodio> episodios = new Model.Finder(String.class, Episodio.class).all();
}

    public static Result deleteEpisodio()
    {
        String id="1";
        Episiodio.find.ref(id).delete();
        return redirect(routes.Application.index());
    }











}