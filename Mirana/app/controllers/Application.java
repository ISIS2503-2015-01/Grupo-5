package controllers;

import play.*;
import play.mvc.*;
import models.Doctor;
import play.data.Form;


import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }


    public static Result addDoctor(){
        Doctor doctor = Form.form(Doctor.class).bindFromRequest().get();
        doctor.save();
        return redirect(routes.Application.index());
    }

    public static addEpisodio()
    {
        Episodio epi = Form.form(Episodio.class).bindFromRequest.get();
        epi.save();
        return redirect(routes.Application.index);
    }

    

}
