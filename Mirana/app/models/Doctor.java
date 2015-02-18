package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;

@Entity
public class Doctor extends Model {

	/*
	Atributos
	*/
	@Id
	public String id;
    public String name;
    public String apellido;
	

	/*
	Constructor; se deben pasar nombre y apellido del doctor como parámetro.
	*/
	public Doctor(String nombre, String apellido){
        name = nombre;
		apellido = apellido;
	}


	/*
	Métodos
	*/

	/*
	Regresa el nombre
	*/
	public String darNombre(){
		return name;
	}

	/*
	Regresa el apellidoPc
	*/
	public String darApellido(){
		return apellido;
	}

	/*
	Cambia el nombre
	*/
	public void setNombre(String nombre){
		name = nombre;
	}

	/*
	Cambia el apellido
	*/
	public void setApellido(String apellido){
		apellido = apellido;
	}

}