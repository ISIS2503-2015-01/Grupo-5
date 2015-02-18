package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Episodio extends Model {


	/*
	Atributos
	*/
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public long id;

	public String idPaciente;

	public Paciente paciente;

	public Date fecha;

	public int intensidad;

	public String descipción;

	public String lugar;

	
	/*
	Constructor
	*/
	public Episodio(String pId, Paciente pPaciente, Date pFecha, int pIntensidad, String pDescripcion, String pLugar )
	{
		//id = pId;
		paciente = pPaciente;
		fecha = pFecha;
		intensidad = pIntensidad;
		descipción = pDescripcion;
		lugar = pLugar;
		
	}


	public String getId()
	{
		return id;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(pPaciente)
	{
		paciente = pPaciente;
	}

	public Date getFecha()
	{
		return fecha;
	}

	public void setFecha(Date pFecha)
	{
		fecha = pFecha;
	}

	public int getIntencidad()
	{
		return intensidad;
	}

	public void setIntesidad(int pIntensidad)
	{
		intensidad = pIntensidad;
	}

	public String getDescripcion()
	{
		return descipción;
	}

	public void setDescripcion(Sitring pDesc)
	{
		descipción = pDesc;
	}

	public String getLugar()
	{
		return lugar;
	}

	public void setLugar(String pLugar)
	{
		lugar = pLugar;
	}

	











}