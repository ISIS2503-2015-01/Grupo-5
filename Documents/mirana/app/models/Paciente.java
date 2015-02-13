3package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paciente extends Model {

	@Id
	public String id;

	public String nombre;

	public String apellido;

	public String genero;

	public int edad;

	public ArrayList episodios;

}