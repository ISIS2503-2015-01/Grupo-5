package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }


    public static Result addDoctor(){
        Doctor doctor= Form.form(Doctor.class).bindFromRequest().get();
        person.save();
        return redirect(routes.Application.index);
    }

}
