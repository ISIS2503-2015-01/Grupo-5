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
	public static Result addPaciente()
	{
		Paciente paciente = Form.form(Paciente.class).bindFromRequest().get();
		paciente.save();
		return redirect(routes.Application.index());
	}
	
	public static Result getPacientes()
	{
		List<Paciente> pacientes= new Model.Finder(String.class, Paciente.class).all();
		return ok(toJson(pacientes));
	}
	
	 public static Result deletePaciente()
	 {
		String id="1";
		Paciente.find.ref(id).delete();
		return redirect(routes.Application.index());
	}
