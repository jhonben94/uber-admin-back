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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "tipo_documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumentos.findAll", query = "SELECT t FROM TipoDocumentos t")
    , @NamedQuery(name = "TipoDocumentos.findByIdTipoDocumento", query = "SELECT t FROM TipoDocumentos t WHERE t.idTipoDocumento = :idTipoDocumento")
    , @NamedQuery(name = "TipoDocumentos.findByNombre", query = "SELECT t FROM TipoDocumentos t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoDocumentos.findByCodigo", query = "SELECT t FROM TipoDocumentos t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TipoDocumentos.findByActivo", query = "SELECT t FROM TipoDocumentos t WHERE t.activo = :activo")
    , @NamedQuery(name = "TipoDocumentos.findByUsuarioCreacion", query = "SELECT t FROM TipoDocumentos t WHERE t.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "TipoDocumentos.findByUsuarioModificacion", query = "SELECT t FROM TipoDocumentos t WHERE t.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "TipoDocumentos.findByFechaModificacion", query = "SELECT t FROM TipoDocumentos t WHERE t.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "TipoDocumentos.findByFechaCreacion", query = "SELECT t FROM TipoDocumentos t WHERE t.fechaCreacion = :fechaCreacion")})
public class TipoDocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "activo")
    private String activo;
    @Size(max = 2147483647)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Size(max = 2147483647)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JsonBackReference(value="titulares")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocumento")
    private List<Titulares> titularesList;
    @JsonBackReference(value="conductores")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocumento")
    private List<Conductores> conductoresList;

    public TipoDocumentos() {
    }

    public TipoDocumentos(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public TipoDocumentos(Integer idTipoDocumento, String nombre, String codigo, String activo) {
        this.idTipoDocumento = idTipoDocumento;
        this.nombre = nombre;
        this.codigo = codigo;
        this.activo = activo;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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
        return "entity.TipoDocumentos[ idTipoDocumento=" + idTipoDocumento + " ]";
    }
    
}
