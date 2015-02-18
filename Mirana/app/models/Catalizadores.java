package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Catalizadores extends Model {

	//-------------------------------------
	//         Atributos
	//-------------------------------------

	/*
	El identificador del catalizador, es un valor único para cada uno.
	*/
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /*
    idCatalizador asociado al catalizador
    */
	public Long idCatalizador;

	/*
	Medicamento que se debe tomar para aliviar los sintomas
	*/
	public String medicamento;

	/*
	Recomendación sobre algún tipo de tratamiento alternativa
	*/
	public String alternativo;

	/*
	Se debe o no guardar reposo
	*/
	public boolean reposo;

	/*
	Se debe o no realizar dieta
	*/
	public boolean dieta;

	/*
	Se debe o no realizar terapiá física
	*/
	public boolean terapia;

	/* 
	Episodio asociado a el catalizador
	*/
	private Long episodioID;

	//-------------------------------------
	//         Constructores
	//-------------------------------------

	/*
	Constructor sin parámetros
	*/
	public Catalizadores(){

	}

	/*
	Constructor con parámetros:
	idCatalizadorr: el idCatalizador del catalizador
	medicamentoo: el medicamento asociado 
	alternativoo: el tratamiento alternativo propuesta
	reposoo: si se debe descansar
	dietaa: si se debe seguir una dieta
	terapiaa: si se debe realizar algún tipo de terapia
	episodioid: el episodio con el que esta conectado el catalizador
	Retorna el nuevo catalizador
	*/
	public static Catalizadores crear(Long idCatalizadorr, String medicamentoo, String alternativoo, boolean reposoo, boolean dietaa, boolean terapiaa, Long episodioid){

	Catalizadores catalizador = new Catalizadores();

	catalizador.idCatalizador = idCatalizadorr;
	catalizador.medicamento = medicamentoo;
	catalizador.alternativo = alternativoo;
	catalizador.reposo = reposoo;
	catalizador.dieta = dietaa;
	catalizador.terapia = terapiaa;
	catalizador.episodioID = episodioid;

	return catalizador;
	}

	//-------------------------------------
	//         Métodos
	//-------------------------------------

	/*
	Retorna el idCatalizador del catalizador
	*/
	public Long daridCatalizador(){
		return idCatalizador;
	}

	/*
	Cambia el idCatalizador del catalizador
	*/
	public void cambiaridCatalizador(String nuevo){
		this.idCatalizador = nuevo;
	}

	/*
	Retorna el medicamento propuesto
	*/
	public String darMedicamento(){
		return medicamento;
	}

	public void cambiarMedicamento( String nuevo){
		this.medicamento = nuevo;
	}

	/*
	Retorna el tratamiento alternativo propuesto
	*/
	public String darAlternativo(){
		return alternativo;
	}

	public void cambiarAlternativo(String nuevo){
		this.alternativo = nuevo;
	}

	/*
	Retorna si se debe guardar reposo
	*/
	public boolean darReposo(){
		return reposo;
	}

	/*
	Cambia el reposar o no
	*/
	public void cambiarReposo(boolean nuevo){
		this.reposo = nuevo;
	}

	/*
	Retorna si se debe hacer dieta
	*/
	public boolean darDieta(){
		return dieta;
	}

	/*
	Cambia el hacer o no dieta
	*/
	public void cambiarDieta(boolean nuevo){
		this.dieta = nuevo;
	}

	/*
	Retorna si se debe hacer terapia
	*/
	public boolean darTerapia(){
		return terapia;
	}

	/*
	Cambia el hacer o no terapia
	*/
	public void cambiarTerapia(boolean nuevo){
		this.terapia = nuevo;
	}

	/*
	Retorna el episodio asociado al catalizador
	*/
	public Long darEpisodio(){
		return episodioID;
	}

	/*
	Cambia el episodio asociado al catalizador
	*/
	public void cambiarEpisodio(Long nuevo){
		this.episodioID = nuevo;
	}
}