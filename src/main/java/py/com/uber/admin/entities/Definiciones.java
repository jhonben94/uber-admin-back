/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uber.admin.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 59599
 */
@Entity
@Table(name = "definiciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Definiciones.findAll", query = "SELECT d FROM Definiciones d")
    , @NamedQuery(name = "Definiciones.findByIdDefinicion", query = "SELECT d FROM Definiciones d WHERE d.idDefinicion = :idDefinicion")
    , @NamedQuery(name = "Definiciones.findByActivo", query = "SELECT d FROM Definiciones d WHERE d.activo = :activo")
    , @NamedQuery(name = "Definiciones.findByNombre", query = "SELECT d FROM Definiciones d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Definiciones.findByValor", query = "SELECT d FROM Definiciones d WHERE d.valor = :valor")
    , @NamedQuery(name = "Definiciones.findByDescripcion", query = "SELECT d FROM Definiciones d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "Definiciones.findByUsuarioCreacion", query = "SELECT d FROM Definiciones d WHERE d.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "Definiciones.findByUsuarioModificacion", query = "SELECT d FROM Definiciones d WHERE d.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "Definiciones.findByFechaModificacion", query = "SELECT d FROM Definiciones d WHERE d.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Definiciones.findByFechaCreacion", query = "SELECT d FROM Definiciones d WHERE d.fechaCreacion = :fechaCreacion")})
public class Definiciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_definicion")
    private Integer idDefinicion;
    @Basic(optional = false)
    @Column(name = "activo")
    private String activo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    private String fechaCreacion;

    public Definiciones() {
    }

    public Definiciones(Integer idDefinicion) {
        this.idDefinicion = idDefinicion;
    }

    public Definiciones(Integer idDefinicion, String activo, String nombre, String valor, String descripcion, String usuarioCreacion, String fechaCreacion) {
        this.idDefinicion = idDefinicion;
        this.activo = activo;
        this.nombre = nombre;
        this.valor = valor;
        this.descripcion = descripcion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdDefinicion() {
        return idDefinicion;
    }

    public void setIdDefinicion(Integer idDefinicion) {
        this.idDefinicion = idDefinicion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDefinicion != null ? idDefinicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Definiciones)) {
            return false;
        }
        Definiciones other = (Definiciones) object;
        if ((this.idDefinicion == null && other.idDefinicion != null) || (this.idDefinicion != null && !this.idDefinicion.equals(other.idDefinicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Definiciones[ idDefinicion=" + idDefinicion + " ]";
    }
    
}
