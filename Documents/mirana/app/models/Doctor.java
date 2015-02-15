3package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor extends Model {

	/*
	Atributos
	*/
	@Id
	public String id;

	public String nombre;

	public String apellido;


	/*
	Constructor; se deben pasar nombre y apellido del doctor como parámetro.
	*/
	public Doctor(String nombree, String apellidoo){
		this.nombre = nombree;
		this.apellido = apellidoo;
	}

	public String darNombre(){
		return nombre;
	}

	public String darApellido(){
		return apellido;
	}


}