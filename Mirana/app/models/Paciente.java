ppackage models;
import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
* Created by USUARIO on 17/02/2015.
*/
@Entity
/**
* Modela a un paciente. Es una POJO(clase de java que solo tiene getters, setters y un constructor)
*/
public class Paciente extends Model
{
    //---------------------------------------------------------------------
    // Constantes
    //---------------------------------------------------------------------

    /**
    * Constante que representa el género masculino
    */
    public static final int MASCULINO = 1;

    /**
    * Constante que representa el género femenino
    */
    public static final int FEMENINO= 2;


    //---------------------------------------------------------------------
    // Atributos
    //---------------------------------------------------------------------

    /**
    * Identificación única del paciente dentro del sistema
    */
    @Id
    private String id;

    /**
    * El nombre del paciente.
    */
    private String nombre;

    /**
    * El apellido del paciente.
    */
    private String apellido;

    /**
    * El género del paciente.
    */
    private String genero;

    /**
    * String que representa la fecha de nacimiento del paciente.
    */
    private String fechaNacimiento;

    /**
    * El número de documento de identidad del paciente.
    */
    private String documentoIdentidad;

    /**
    * El tipo de documento de identidad del paciente.
    */
    private String tipoDocumentoIdentidad;

    /**
    * El correo electrónico del paciente.
    */
    private String email;


    //---------------------------------------------------------------------
    // Constructor
    //---------------------------------------------------------------------

    public Paciente(String nombreP, String apellidoP, String generoP, String fechaNacimientoP, String documentoIdentidadP, String tipoDocumentoIdentidadP, String emailP)
    {
        nombre=nombreP;
        apellido=apellidoP;
        genero=generoP;
        fechaNacimiento=fechaNacimientoP;
        documentoIdentidad=documentoIdentidadP;
        tipoDocumentoIdentidad=tipoDocumentoIdentidadP;
        email=emailP;
    }

    
    //---------------------------------------------------------------------
    // Getters
    //---------------------------------------------------------------------

    public String getNombre()
    {
    return nombre;
    }

    public String getApellido()
    {
    return apellido;
    }

    public String getGenero()
    {
    return genero;
    }

    public String getDocumentoIdentidad()
    {
    return documentoIdentidad;
    }

    public String getTipoDocumentoIdentidad()
    {
    return tipoDocumentoIdentidad;
    }

    public String getFechaNacimiento()
    {
    return fechaNacimiento;
    }

    public String getEmail()
    {
    return email;
    }
    //---------------------------------------------------------------------
    // Setters
    //---------------------------------------------------------------------
    
    public void setNombre(String nombreP)
    {
    nombre = nombreP;
    }
    
    public void setApellido(String apellidoP)
    {
    this.apellido = apellidoP;
    }
    
    public void setGenero(String genero)
    {
    this.genero = genero;
    }
    
    public void setDocumentoIdentidad(String documentoIdentidad)
    {
    this.documentoIdentidad = documentoIdentidad;
    }
    
    public void setEmail(String email)
    {
    this.email = email;
    }
    
    public void setFechaNacimiento(String fechaNacimiento)
    {
    this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad)
    {
    this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }
}
