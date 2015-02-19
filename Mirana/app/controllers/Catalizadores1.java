package controllers; import play.*; import play.mvc.*; import models.Catalizadores; import play.data.Form; import com.fasterxml.jackson.databind.JsonNode; import play.db.jpa.jpa;

import play.libs.Json; import play.mvc.BodyParser; import play.mvc.Controller; import play.mvc.Result; import play.mvc.Results; import javax.persistence.Query; import java.text.ParseException; import java.text.SimpleDateFormat; import java.util.Collection; import java.util.Date; import views.html.*; /** * Created by Andre Navas on 18/02/2015. */ public class Catalizadores1 extends Controller {

public static Result index() { return ok(index.render("Holis! Recétale algo al muchacho")); }

/* Crear un nuevo catalizador, a partir del episodio asociado episodioID: el episodio para el cual se crea el catalizador */ @Transactional @BodyParser.Of(BodyParser.Json.class) public static Result crear(Long episodioID) { Episodio episodio = JPA.em().getReference(Episodio.class, episodioID);

if(episodio != null) { JsonNode capturador = Controller.request().body().asJson(); Long idCatalizador = Long.parseLong(Controller.request().path()); String medicamento = capturador.findPath("Medicamento").asText(); String alternativo = capturador.findPath("Sugerencia medicina alterna").asText(); boolean reposo = capturador.findPath("Debe reposar?").asBoolean(); boolean dieta = capturador.findPath("Debe hacer dieta?").asBoolean(); boolean terapia = capturador.findPath("Debe hacer terapia?").asBoolean(); Long idespisodio = episodioID;

try{ Catalizadores catalizador = Catalizadores.crear(idCatalizador, medicamento, alternativo, reposo, dieta, terapia, idespisodio); JPA.em.persist(catalizador); }

catch(Exception e) { e.printStackTrace(); return null; }

return Results.created(Json.toJson(getNotification(episodioID, medicamento, alternativo, reposo, dieta, terapia))); } else {return Results.badRequest("Parece que no existe el episodio");} }

/* Actualiza el catalizador que se esta revisando catalizadorID: el catalizador a ser modificado */ @Transactional @BodyParser.Of(BodyParser.Json.class) public static Result actualizar(Long catalizadorID){ Catalizadores temporal = JPA.em().find(Catalizadores.class, catalizadorID); Long episodioID = temporal.darEpisodio(); Episodio episodio = JPA.em().getReference(Episodio.class, episodioID);

if(episodio != null){ JsonNode capturador = Controller.request().body().asJson(); Long idCatalizador = Long.parseLong(Controller.request().path()); String medicamento = capturador.findPath("Medicamento").asText(); String alternativo = capturador.findPath("Sugerencia medicina alterna").asText(); boolean reposo = capturador.findPath("Debe reposar?").asBoolean(); boolean dieta = capturador.findPath("Debe hacer dieta?").asBoolean(); boolean terapia = capturador.findPath("Debe hacer terapia?").asBoolean(); Long idespisodio = episodioID;

try{ Catalizadores catalizador = JPA.em().getReference(Catalizadores.class, catalizadorID); catalizador.cambiaridCatalizador(idCatalizador); catalizador.cambiarMedicamento(medicamento); catalizador.cambiarAlternativo(alternativo); catalizador.cambiarReposo(reposo); catalizador.cambiarDieta(dieta); catalizador.cambiarTerapia(terapia); catalizador.cambiarEpisodio(episodioID); }

catch(Exception e){ e.printStackTrace(); return Results.notModified("Parece que no fue posible actualizar el catalizador"); }

return Results.created(); } else {return Results.badRequest("Parece que no existe el episodio");} }

/* Borra un catalizador, con identificador especificado catalizadorID: el catalizador a ser eliminado episodioID: el episodio del cual será eliminado el catalizador */ @Transactional public static Result borrar(Long catalizadorID, Long episodioID){ Catalizadores catalizador = JPA.em().find(Catalizadores.class, catalizadorID);

if(catalizador.darEpisodio().equals(episodioID)) { JPA.em().remove(catalizador); return Results.ok(); }

else { return Results.badRequest("No se pudo eliminar el catalizador, vuelve a intentarlo");}

}

/* El paciente que tiene asignado un catalizador catalizadorID: el catalizador del cual se quiere conocer el paciente asociado */ @Transactional public static Result darPaciente(Long catalizadorID){ Catalizadores catalizador = JPA.em().find(Catalizadores.class, catalizadorID); Episodio episodio = catalizador.darEpisodio(); Paciente paciente = episodio.getPaciente();

if(paciente.darNombre() != null) { return Result.ok(Json.toJson(paciente)); }

else {return Result.badRequest("El catalizador no tiene paciente asociado");} }

}