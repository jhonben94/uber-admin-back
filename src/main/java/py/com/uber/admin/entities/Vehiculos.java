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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v")
    , @NamedQuery(name = "Vehiculos.findByIdVehiculo", query = "SELECT v FROM Vehiculos v WHERE v.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Vehiculos.findByNumeroChapa", query = "SELECT v FROM Vehiculos v WHERE v.numeroChapa = :numeroChapa")
    , @NamedQuery(name = "Vehiculos.findByColor", query = "SELECT v FROM Vehiculos v WHERE v.color = :color")
    , @NamedQuery(name = "Vehiculos.findByObservaciones", query = "SELECT v FROM Vehiculos v WHERE v.observaciones = :observaciones")
    , @NamedQuery(name = "Vehiculos.findByActivo", query = "SELECT v FROM Vehiculos v WHERE v.activo = :activo")
    , @NamedQuery(name = "Vehiculos.findByFechaModificacion", query = "SELECT v FROM Vehiculos v WHERE v.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Vehiculos.findByUsuarioCreacion", query = "SELECT v FROM Vehiculos v WHERE v.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "Vehiculos.findByUsuarioModificacion", query = "SELECT v FROM Vehiculos v WHERE v.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "Vehiculos.findByFechaCreacion", query = "SELECT v FROM Vehiculos v WHERE v.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Vehiculos.findByIdTitular", query = "SELECT v FROM Vehiculos v WHERE v.idTitular = :idTitular")
    , @NamedQuery(name = "Vehiculos.findByAnio", query = "SELECT v FROM Vehiculos v WHERE v.anio = :anio")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "numero_chapa")
    private String numeroChapa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "activo")
    private String activo;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Size(max = 2147483647)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Size(max = 2147483647)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_titular")
    private int idTitular;
    @Column(name = "anio")
    private Integer anio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculo")
    private List<Viajes> viajesList;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private Marcas idMarca;

    public Vehiculos() {
    }

    public Vehiculos(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculos(Integer idVehiculo, String numeroChapa, String color, String observaciones, String activo, int idTitular) {
        this.idVehiculo = idVehiculo;
        this.numeroChapa = numeroChapa;
        this.color = color;
        this.observaciones = observaciones;
        this.activo = activo;
        this.idTitular = idTitular;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNumeroChapa() {
        return numeroChapa;
    }

    public void setNumeroChapa(String numeroChapa) {
        this.numeroChapa = numeroChapa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(int idTitular) {
        this.idTitular = idTitular;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @XmlTransient
    public List<Viajes> getViajesList() {
        return viajesList;
    }

    public void setViajesList(List<Viajes> viajesList) {
        this.viajesList = viajesList;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
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
        return "entity.Vehiculos[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
