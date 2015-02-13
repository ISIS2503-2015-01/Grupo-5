3package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Episodio extends Model {

	@Id
	public String id;

	public Paciente paciente;

	public Date fecha;

	public int intensidad;

	public String descipción;

	

}