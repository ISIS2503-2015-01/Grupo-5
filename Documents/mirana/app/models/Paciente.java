3package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paciente extends Model {

	/*
	Atributos
	*/
	@Id
	public String id;

	public String nombre;

	public String apellido;

	public String genero;

	public int edad;

	public ArrayList episodios;

	public String cedula;

	
	/*
	papipupepo
	*/

	/*
	Costructor; el paciente debe introducir sus datos personales, para con ello ser visible para un doctor.
	*/
	public Paciente(String cedula, String nombre, String apellido, String genero, int edad){
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.edad = edad;
		this.episodios = new ArrayList();
	}


	/*
	Métodos
	*/
	public String darNomnre(){
		return nombre;
	}

	public String darApellido(){
		return apellido;
	}

	public String darGenero(){
		return genero;
	}

	public int darEdad(){
		return edad;
	}

	public ArrayList darEpisodios(){
		return episodios;
	}

	public String darCedula(){
		return cedula;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setApellido(String apellido){
		this.apellido = apellido;
	}

	public void setEdad(int edad){
		this.edad = edad;
	}

}