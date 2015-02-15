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
	public Doctor(String nombre, String apellido){
		this.nombre = nombre;
		this.apellido = apellido;
	}


	/*
	Métodos
	*/
	public String darNombre(){
		return nombre;
	}

	public String darApellido(){
		return apellido;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setApellido(String apellido){
		this.apellido = apellido;
	}

}