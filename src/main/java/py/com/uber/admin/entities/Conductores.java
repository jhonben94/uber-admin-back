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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 59599
 */
@Entity
@Table(name = "conductores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conductores.findAll", query = "SELECT c FROM Conductores c")
    , @NamedQuery(name = "Conductores.findByIdConductor", query = "SELECT c FROM Conductores c WHERE c.idConductor = :idConductor")
    , @NamedQuery(name = "Conductores.findByActivo", query = "SELECT c FROM Conductores c WHERE c.activo = :activo")
    , @NamedQuery(name = "Conductores.findByNombre", query = "SELECT c FROM Conductores c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Conductores.findByApellido", query = "SELECT c FROM Conductores c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Conductores.findByDocumento", query = "SELECT c FROM Conductores c WHERE c.documento = :documento")
    , @NamedQuery(name = "Conductores.findByCorreo", query = "SELECT c FROM Conductores c WHERE c.correo = :correo")
    , @NamedQuery(name = "Conductores.findByTelefono", query = "SELECT c FROM Conductores c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Conductores.findByUsuario", query = "SELECT c FROM Conductores c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "Conductores.findByUsuarioCreacion", query = "SELECT c FROM Conductores c WHERE c.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "Conductores.findByFechaCreacion", query = "SELECT c FROM Conductores c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Conductores.findByUsuarioModificacion", query = "SELECT c FROM Conductores c WHERE c.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "Conductores.findBySexo", query = "SELECT c FROM Conductores c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "Conductores.findByFechaModificacion", query = "SELECT c FROM Conductores c WHERE c.fechaModificacion = :fechaModificacion")})
public class Conductores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conductor")
    private Integer idConductor;
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
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @JoinTable(name = "titulares_conductores", joinColumns = {
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

    public Conductores(Integer idConductor, String activo, String nombre, String apellido, String documento, String correo, String telefono, String usuario, String usuarioCreacion, Date fechaCreacion, String sexo) {
        this.idConductor = idConductor;
        this.activo = activo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.sexo = sexo;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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
        return "com.mycompany.mavenproject1.Conductores[ idConductor=" + idConductor + " ]";
    }
    
}
