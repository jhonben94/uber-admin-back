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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "conductores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conductores.findAll", query = "SELECT c FROM Conductores c")
    , @NamedQuery(name = "Conductores.findByIdConductor", query = "SELECT c FROM Conductores c WHERE c.idConductor = :idConductor")
    , @NamedQuery(name = "Conductores.findByUsuarioCreacion", query = "SELECT c FROM Conductores c WHERE c.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "Conductores.findByNombres", query = "SELECT c FROM Conductores c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "Conductores.findByApellidos", query = "SELECT c FROM Conductores c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Conductores.findByTelefono", query = "SELECT c FROM Conductores c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Conductores.findByContrasena", query = "SELECT c FROM Conductores c WHERE c.contrasena = :contrasena")
    , @NamedQuery(name = "Conductores.findByUsername", query = "SELECT c FROM Conductores c WHERE c.username = :username")
    , @NamedQuery(name = "Conductores.findByUsuarioModificacion", query = "SELECT c FROM Conductores c WHERE c.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "Conductores.findByDocumento", query = "SELECT c FROM Conductores c WHERE c.documento = :documento")
    , @NamedQuery(name = "Conductores.findBySexo", query = "SELECT c FROM Conductores c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "Conductores.findByEmail", query = "SELECT c FROM Conductores c WHERE c.email = :email")
    , @NamedQuery(name = "Conductores.findByFechaModificacion", query = "SELECT c FROM Conductores c WHERE c.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Conductores.findByFechaCreacion", query = "SELECT c FROM Conductores c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Conductores.findByActivo", query = "SELECT c FROM Conductores c WHERE c.activo = :activo")})
public class Conductores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conductor")
    private Integer idConductor;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Email invalido")//if the field contains email address consider using this annotation to enforce field validation
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "activo")
    private String activo;
    @JoinTable(name = "conductores_titulares", joinColumns = {
        @JoinColumn(name = "id_conductor", referencedColumnName = "id_conductor")}, inverseJoinColumns = {
        @JoinColumn(name = "id_titular", referencedColumnName = "id_titular")})
    @ManyToMany
    private List<Titulares> titularesList;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumentos idTipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConductor")
    private List<Viajes> viajesList;

    public Conductores() {
    }

    public Conductores(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Conductores(Integer idConductor, String nombres, String apellidos, String telefono, String contrasena, String username, String usuarioModificacion, String documento, String sexo, String email, String activo) {
        this.idConductor = idConductor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.username = username;
        this.usuarioModificacion = usuarioModificacion;
        this.documento = documento;
        this.sexo = sexo;
        this.email = email;
        this.activo = activo;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Titulares> getTitularesList() {
        return titularesList;
    }

    public void setTitularesList(List<Titulares> titularesList) {
        this.titularesList = titularesList;
    }

    public TipoDocumentos getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumentos idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @XmlTransient
    public List<Viajes> getViajesList() {
        return viajesList;
    }

    public void setViajesList(List<Viajes> viajesList) {
        this.viajesList = viajesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConductor != null ? idConductor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductores)) {
            return false;
        }
        Conductores other = (Conductores) object;
        if ((this.idConductor == null && other.idConductor != null) || (this.idConductor != null && !this.idConductor.equals(other.idConductor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Conductores[ idConductor=" + idConductor + " ]";
    }
    
}
