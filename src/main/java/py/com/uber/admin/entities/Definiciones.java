/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uber.admin.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "definiciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Definiciones.findAll", query = "SELECT d FROM Definiciones d")
    , @NamedQuery(name = "Definiciones.findByIdDefinicion", query = "SELECT d FROM Definiciones d WHERE d.idDefinicion = :idDefinicion")
    , @NamedQuery(name = "Definiciones.findByActivo", query = "SELECT d FROM Definiciones d WHERE d.activo = :activo")
    , @NamedQuery(name = "Definiciones.findByNombre", query = "SELECT d FROM Definiciones d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Definiciones.findByDescripcion", query = "SELECT d FROM Definiciones d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "Definiciones.findByValor", query = "SELECT d FROM Definiciones d WHERE d.valor = :valor")})
public class Definiciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_definicion")
    private Integer idDefinicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "activo")
    private String activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "valor")
    private String valor;

    public Definiciones() {
    }

    public Definiciones(Integer idDefinicion) {
        this.idDefinicion = idDefinicion;
    }

    public Definiciones(Integer idDefinicion, String activo, String nombre, String descripcion, String valor) {
        this.idDefinicion = idDefinicion;
        this.activo = activo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
        return "entity.Definiciones[ idDefinicion=" + idDefinicion + " ]";
    }
    
}
