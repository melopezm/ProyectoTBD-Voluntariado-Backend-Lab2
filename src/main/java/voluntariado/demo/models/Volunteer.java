package voluntariado.demo.models;


import java.sql.Date;
import java.util.List;


public class Volunteer {

    private Integer id;
    private String rut;
    private String nombre;
    private String apellido;
    private String correo_electronico;
    private String celular;
    private Date fnacimiento;
    private List<Integer> habilidad;

    public List<Integer> getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(List<Integer> habilidad) {
        this.habilidad = habilidad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
