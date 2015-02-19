package controllers;

import models.Doctor;
import models.Episodio;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import play.data.DynamicForm;



import java.util.List;
import views.html.*;

import static play.libs.Json.toJson;

public class Application extends Controller {


    public static Result index() {
        return ok(index.render("Hello"));
    }

    public static Result addDoctor(){
        Doctor doctor = Form.form(Doctor.class).bindFromRequest().get();
        doctor.save();
        return redirect(routes.Application.index());
    }

    public static Result get_Doctors(){
        List<Doctor> doctores= new Model.Finder(String.class, Doctor.class).all();
        return ok(toJson(doctores));
    }



    public static Result deleteDoctor(){

        String id="4";
        Doctor.find.ref(id).delete();
        return redirect(routes.Application.index());

    }
    public static Result addEpisodio(){
        Episodio epi = Form.form(Episodio.class).bindFromRequest().get();
        epi.save();
        return redirect(routes.Application.index());
    }

}
