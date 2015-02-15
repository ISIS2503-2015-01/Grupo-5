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
	Costructor; el paciente debe introducir sus datos personales, para con ello ser visible para un doctor.
	*/
	public Paciente(String cedulaa, String nombree, String apellidoo, String generoo, int edadd){
		this.cedula = cedulaa;
		this.nombre = nombree;
		this.apellido = apellidoo;
		this.genero = generoo;
		this.edad = edadd;
		this.episodios = new ArrayList();
	}

	public String darNomnre(){
		return nombre;
	}

}