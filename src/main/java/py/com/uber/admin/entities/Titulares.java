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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "titulares")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Titulares.findAll", query = "SELECT t FROM Titulares t")
    , @NamedQuery(name = "Titulares.findByIdTitular", query = "SELECT t FROM Titulares t WHERE t.idTitular = :idTitular")
    , @NamedQuery(name = "Titulares.findByActivo", query = "SELECT t FROM Titulares t WHERE t.activo = :activo")
    , @NamedQuery(name = "Titulares.findByNombre", query = "SELECT t FROM Titulares t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Titulares.findByApellido", query = "SELECT t FROM Titulares t WHERE t.apellido = :apellido")
    , @NamedQuery(name = "Titulares.findByDocumento", query = "SELECT t FROM Titulares t WHERE t.documento = :documento")
    , @NamedQuery(name = "Titulares.findByCorreo", query = "SELECT t FROM Titulares t WHERE t.correo = :correo")
    , @NamedQuery(name = "Titulares.findByTelefono", query = "SELECT t FROM Titulares t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "Titulares.findByUsuario", query = "SELECT t FROM Titulares t WHERE t.usuario = :usuario")
    , @NamedQuery(name = "Titulares.findByUsuarioCreacion", query = "SELECT t FROM Titulares t WHERE t.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "Titulares.findByFechaCreacion", query = "SELECT t FROM Titulares t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Titulares.findByUsuarioModificacion", query = "SELECT t FROM Titulares t WHERE t.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "Titulares.findByFechaModificacion", query = "SELECT t FROM Titulares t WHERE t.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Titulares.findBySexo", query = "SELECT t FROM Titulares t WHERE t.sexo = :sexo")})
public class Titulares implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_titular")
    private Integer idTitular;
    @Basic(optional = false)
    @Column(name = "activo")
    private String activo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Basic(optional = false)
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @ManyToMany(mappedBy = "titularesList")
    private List<Conductores> conductoresList;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumentos idTipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTitular")
    private List<Vehiculos> vehiculosList;

    public Titulares() {
    }

    public Titulares(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public Titulares(Integer idTitular, String activo, String nombre, String apellido, String documento, String correo, String telefono, String usuario, String usuarioCreacion, Date fechaCreacion, String usuarioModificacion, Date fechaModificacion, String sexo) {
        this.idTitular = idTitular;
        this.activo = activo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaModificacion = fechaModificacion;
        this.sexo = sexo;
    }

    public Integer getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Integer idTitular) {
        this.idTitular = idTitular;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @XmlTransient
    public List<Conductores> getConductoresList() {
        return conductoresList;
    }

    public void setConductoresList(List<Conductores> conductoresList) {
        this.conductoresList = conductoresList;
    }

    public TipoDocumentos getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumentos idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @XmlTransient
    public List<Vehiculos> getVehiculosList() {
        return vehiculosList;
    }

    public void setVehiculosList(List<Vehiculos> vehiculosList) {
        this.vehiculosList = vehiculosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTitular != null ? idTitular.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titulares)) {
            return false;
        }
        Titulares other = (Titulares) object;
        if ((this.idTitular == null && other.idTitular != null) || (this.idTitular != null && !this.idTitular.equals(other.idTitular))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Titulares[ idTitular=" + idTitular + " ]";
    }
    
}
