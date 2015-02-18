package models;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;

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




}
