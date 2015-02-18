package controllers;

import models.Doctor;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import javax.xml.transform.Result;
import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result addDoctor(){
        Doctor doctor = Form.form(Doctor.class).bindFromRequest().get();
        doctor.save();
        return redirect(routes.Application.index());
    }

    public static Result get_Doctors()
    {
        List<Doctor> doctores= new Model.Finder(String.class, Doctor.class).all();
        return ok(toJson(doctores));
    }

}
