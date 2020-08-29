/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uber.admin.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 59599
 */
@Entity
@Table(name = "tipo_documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumentos.findAll", query = "SELECT t FROM TipoDocumentos t")
    , @NamedQuery(name = "TipoDocumentos.findByIdTipoDocumento", query = "SELECT t FROM TipoDocumentos t WHERE t.idTipoDocumento = :idTipoDocumento")
    , @NamedQuery(name = "TipoDocumentos.findByActivo", query = "SELECT t FROM TipoDocumentos t WHERE t.activo = :activo")
    , @NamedQuery(name = "TipoDocumentos.findByNombre", query = "SELECT t FROM TipoDocumentos t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoDocumentos.findByDescripcion", query = "SELECT t FROM TipoDocumentos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoDocumentos.findByUsuarioCreacion", query = "SELECT t FROM TipoDocumentos t WHERE t.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "TipoDocumentos.findByFechaCreacion", query = "SELECT t FROM TipoDocumentos t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "TipoDocumentos.findByUsuarioModificacion", query = "SELECT t FROM TipoDocumentos t WHERE t.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "TipoDocumentos.findByFechaModificacion", query = "SELECT t FROM TipoDocumentos t WHERE t.fechaModificacion = :fechaModificacion")})
public class TipoDocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;
    @Basic(optional = false)
    @Column(name = "activo")
    private String activo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    private String fechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocumento")
    private List<Titulares> titularesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocumento")
    private List<Conductores> conductoresList;

    public TipoDocumentos() {
    }

    public TipoDocumentos(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public TipoDocumentos(Integer idTipoDocumento, String activo, String nombre, String descripcion, String usuarioCreacion, Date fechaCreacion) {
        this.idTipoDocumento = idTipoDocumento;
        this.activo = activo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
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

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @XmlTransient
    public List<Titulares> getTitularesList() {
        return titularesList;
    }

    public void setTitularesList(List<Titulares> titularesList) {
        this.titularesList = titularesList;
    }

    @XmlTransient
    public List<Conductores> getConductoresList() {
        return conductoresList;
    }

    public void setConductoresList(List<Conductores> conductoresList) {
        this.conductoresList = conductoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDocumento != null ? idTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumentos)) {
            return false;
        }
        TipoDocumentos other = (TipoDocumentos) object;
        if ((this.idTipoDocumento == null && other.idTipoDocumento != null) || (this.idTipoDocumento != null && !this.idTipoDocumento.equals(other.idTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.TipoDocumentos[ idTipoDocumento=" + idTipoDocumento + " ]";
    }
    
}
