package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.text.*;
import java.util.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.*;

/**
 * Created by Andre Navas on 17/02/2015.
 */
@Entity
public class Paciente extends Model
{


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
    public Paciente(String cedula, String nombre, String apellido, String genero, int edad)
    {
        this.cedula= cedula;
        this.nombre= nombre;
        this.apellido= apellido;
        this.genero= genero;
        this.edad= edad;

    }


	/*
	Métodos
	*/


    /*
    Regresa el nombre
    */
    public String darNomnre(){
        return nombre;
    }

    /*
    Regresa el apellido
    */
    public String darApellido(){
        return apellido;
    }

    /*
    Regresa el género
    */
    public String darGenero(){
        return genero;
    }

    /*
    Regresa la edad
    */
    public int darEdad(){
        return edad;
    }

    /*
    Regresa los episodios
    */
    public ArrayList darEpisodios()
    {
        return episodios;
    }

    /*
    Regresa la cédula
    */
    public String darCedula()
    {
        return cedula;
    }

    /*
    Cambia el nombre
    */
    public void setNombre(String nombre)
    {
        nombre = nombre;
    }

    /*
    Cambia el apellido
    */
    public void setApellido(String apellido)
    {
        apellido = apellido;
    }

    /*
    Cambia la edad
    */
    public void setEdad(int edad)
    {
        edad = edad;
    }

}
