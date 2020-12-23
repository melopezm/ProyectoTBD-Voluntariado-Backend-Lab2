package voluntariado.demo.models;

import java.sql.Date;
import java.sql.Timestamp;


public class LogTask {
    private Integer id;
    private Integer id_tarea;
    private String nombre;
    private String estado;
    private Date fecha_de_creacion;
    private String descrip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_de_creacion() {
        return fecha_de_creacion;
    }

    public void setFecha_de_creacion(Date fecha_de_creacion) {
        this.fecha_de_creacion = fecha_de_creacion;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
