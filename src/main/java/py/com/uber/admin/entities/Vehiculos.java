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
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v")
    , @NamedQuery(name = "Vehiculos.findByIdVehiculo", query = "SELECT v FROM Vehiculos v WHERE v.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Vehiculos.findByActivo", query = "SELECT v FROM Vehiculos v WHERE v.activo = :activo")
    , @NamedQuery(name = "Vehiculos.findByAnio", query = "SELECT v FROM Vehiculos v WHERE v.anio = :anio")
    , @NamedQuery(name = "Vehiculos.findByColor", query = "SELECT v FROM Vehiculos v WHERE v.color = :color")
    , @NamedQuery(name = "Vehiculos.findByFechaCreacion", query = "SELECT v FROM Vehiculos v WHERE v.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Vehiculos.findByFechaModificacion", query = "SELECT v FROM Vehiculos v WHERE v.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Vehiculos.findByNumeroChapa", query = "SELECT v FROM Vehiculos v WHERE v.numeroChapa = :numeroChapa")
    , @NamedQuery(name = "Vehiculos.findByObservaciones", query = "SELECT v FROM Vehiculos v WHERE v.observaciones = :observaciones")
    , @NamedQuery(name = "Vehiculos.findByUsuarioCreacion", query = "SELECT v FROM Vehiculos v WHERE v.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "Vehiculos.findByUsuarioModificacion", query = "SELECT v FROM Vehiculos v WHERE v.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "Vehiculos.findByFechaCreacion1", query = "SELECT v FROM Vehiculos v WHERE v.fechaCreacion1 = :fechaCreacion1")
    , @NamedQuery(name = "Vehiculos.findByFechaModificacion1", query = "SELECT v FROM Vehiculos v WHERE v.fechaModificacion1 = :fechaModificacion1")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Basic(optional = false)
    @Column(name = "activo")
    private String activo;
    @Basic(optional = false)
    @Column(name = "anio")
    private String anio;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Basic(optional = false)
    @Column(name = "numero_chapa")
    private String numeroChapa;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Basic(optional = false)
    @Column(name = "fecha_creacion_1")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion1;
    @Column(name = "fecha_modificacion_1")
    private String fechaModificacion1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculo")
    private List<Viajes> viajesList;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    @ManyToOne(optional = false)
    private Modelos idModelo;
    @JoinColumn(name = "id_titular", referencedColumnName = "id_titular")
    @ManyToOne(optional = false)
    private Titulares idTitular;

    public Vehiculos() {
    }

    public Vehiculos(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculos(Integer idVehiculo, String activo, String anio, String color, Date fechaCreacion, String numeroChapa, String usuarioCreacion, Date fechaCreacion1) {
        this.idVehiculo = idVehiculo;
        this.activo = activo;
        this.anio = anio;
        this.color = color;
        this.fechaCreacion = fechaCreacion;
        this.numeroChapa = numeroChapa;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion1 = fechaCreacion1;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getNumeroChapa() {
        return numeroChapa;
    }

    public void setNumeroChapa(String numeroChapa) {
        this.numeroChapa = numeroChapa;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public Date getFechaCreacion1() {
        return fechaCreacion1;
    }

    public void setFechaCreacion1(Date fechaCreacion1) {
        this.fechaCreacion1 = fechaCreacion1;
    }

    public String getFechaModificacion1() {
        return fechaModificacion1;
    }

    public void setFechaModificacion1(String fechaModificacion1) {
        this.fechaModificacion1 = fechaModificacion1;
    }

    @XmlTransient
    public List<Viajes> getViajesList() {
        return viajesList;
    }

    public void setViajesList(List<Viajes> viajesList) {
        this.viajesList = viajesList;
    }

    public Modelos getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelos idModelo) {
        this.idModelo = idModelo;
    }

    public Titulares getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Titulares idTitular) {
        this.idTitular = idTitular;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Vehiculos[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
