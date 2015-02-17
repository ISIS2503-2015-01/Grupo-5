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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	public String nombre;

	public String medicamento;

	public String alternativo;

	public boolean reposo;

	public boolean dieta;

	public boolean terapia;

	/*
	Constructor 
	*/
	public Catalizadores(){

	}

	public static Catalizadores create( String nombree, String medicamentoo, String alternativoo, boolean reposoo, boolean dietaa, boolean terapiaa){

	Catalizadores catalizador = new Catalizadores();

	catalizador.nombre = nombree;
	catalizador.medicamento = medicamentoo;
	catalizador.alternativo = alternativoo;
	catalizador.reposo = reposoo;
	catalizador.dieta = dietaa;
	catalizador.terapia = terapiaa;
	}

	/*
	Métodos
	*/

	public String darNombre(){
		return nombre;
	}

	public void cambiarNombre(String nuevo){
		this.nombre = nuevo;
	}

		public String darNombre(){
		return nombre;
	}

	public void cambiarNombre(String nuevo){
		this.nombre = nuevo;
	}

}