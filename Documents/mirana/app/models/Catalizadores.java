3package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Catalizadores extends Model {

	/*
	Atributos
	*/
	@Id
	public String id;

	public String nombre;

	/*
	Constructor 
	*/
	public Catalizadores( String nombree){
		this.nombre = nombree;
	}
		

}