package controllers;

import models.Paciente;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.*;


/**
 * Created by USUARIO on 17/02/2015.
 */
public class pacientesController extends Controller
{

    public static Result addPaciente(){
        Paciente paciente = Form.form(Paciente.class).bindFromRequest().get();
        paciente.save();
        return redirect(routes.Application.index());
    }
}
