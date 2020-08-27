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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "titulares")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Titulares.findAll", query = "SELECT t FROM Titulares t")
    , @NamedQuery(name = "Titulares.findByIdTitular", query = "SELECT t FROM Titulares t WHERE t.idTitular = :idTitular")
    , @NamedQuery(name = "Titulares.findByUsuarioCreacion", query = "SELECT t FROM Titulares t WHERE t.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "Titulares.findByNombres", query = "SELECT t FROM Titulares t WHERE t.nombres = :nombres")
    , @NamedQuery(name = "Titulares.findByApellidos", query = "SELECT t FROM Titulares t WHERE t.apellidos = :apellidos")
    , @NamedQuery(name = "Titulares.findByActivo", query = "SELECT t FROM Titulares t WHERE t.activo = :activo")
    , @NamedQuery(name = "Titulares.findByTelefono", query = "SELECT t FROM Titulares t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "Titulares.findByContrasena", query = "SELECT t FROM Titulares t WHERE t.contrasena = :contrasena")
    , @NamedQuery(name = "Titulares.findByUsername", query = "SELECT t FROM Titulares t WHERE t.username = :username")
    , @NamedQuery(name = "Titulares.findByUsuarioModificacion", query = "SELECT t FROM Titulares t WHERE t.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "Titulares.findByCedula", query = "SELECT t FROM Titulares t WHERE t.cedula = :cedula")
    , @NamedQuery(name = "Titulares.findBySexo", query = "SELECT t FROM Titulares t WHERE t.sexo = :sexo")
    , @NamedQuery(name = "Titulares.findByEmail", query = "SELECT t FROM Titulares t WHERE t.email = :email")
    , @NamedQuery(name = "Titulares.findByFechaModificacion", query = "SELECT t FROM Titulares t WHERE t.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Titulares.findByFechaCreacion", query = "SELECT t FROM Titulares t WHERE t.fechaCreacion = :fechaCreacion")})
public class Titulares implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_titular")
    private Integer idTitular;
    @Size(max = 2147483647)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "activo")
    private String activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "username")
    private String username;
    @Size(max = 2147483647)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "sexo")
    private String sexo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @ManyToMany(mappedBy = "titularesList")
    private List<Conductores> conductoresList;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumentos idTipoDocumento;

    public Titulares() {
    }

    public Titulares(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public Titulares(Integer idTitular, String nombres, String apellidos, String activo, String telefono, String contrasena, String username, String cedula, String sexo, String email) {
        this.idTitular = idTitular;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.activo = activo;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.username = username;
        this.cedula = cedula;
        this.sexo = sexo;
        this.email = email;
    }

    public Integer getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "entity.Titulares[ idTitular=" + idTitular + " ]";
    }
    
}
