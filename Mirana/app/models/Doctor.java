package models;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
/**
 * Created by Andre Navas on 17/02/2015.
 */
@Entity
public class Doctor extends Model {

    /*
	Atributos
	*/
    @Id
    public String id;
    public String name;
    public String apellido;
    public static Finder<String,Doctor> find = new Finder<String,Doctor>(
            String.class, Doctor.class
    );



}
