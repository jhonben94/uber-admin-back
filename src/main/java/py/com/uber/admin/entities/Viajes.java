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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "viajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viajes.findAll", query = "SELECT v FROM Viajes v")
    , @NamedQuery(name = "Viajes.findByIdViaje", query = "SELECT v FROM Viajes v WHERE v.idViaje = :idViaje")
    , @NamedQuery(name = "Viajes.findByFecha", query = "SELECT v FROM Viajes v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Viajes.findByCombustible", query = "SELECT v FROM Viajes v WHERE v.combustible = :combustible")
    , @NamedQuery(name = "Viajes.findByPorcentajeUber", query = "SELECT v FROM Viajes v WHERE v.porcentajeUber = :porcentajeUber")
    , @NamedQuery(name = "Viajes.findByRecaudacion", query = "SELECT v FROM Viajes v WHERE v.recaudacion = :recaudacion")
    , @NamedQuery(name = "Viajes.findByFondo", query = "SELECT v FROM Viajes v WHERE v.fondo = :fondo")
    , @NamedQuery(name = "Viajes.findBySaldoARecibir", query = "SELECT v FROM Viajes v WHERE v.saldoARecibir = :saldoARecibir")
    , @NamedQuery(name = "Viajes.findByGastoExtra", query = "SELECT v FROM Viajes v WHERE v.gastoExtra = :gastoExtra")
    , @NamedQuery(name = "Viajes.findByObservacion", query = "SELECT v FROM Viajes v WHERE v.observacion = :observacion")})
public class Viajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_viaje")
    private Integer idViaje;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "combustible")
    private Integer combustible;
    @Basic(optional = false)
    @Column(name = "porcentaje_uber")
    private int porcentajeUber;
    @Basic(optional = false)
    @Column(name = "recaudacion")
    private int recaudacion;
    @Basic(optional = false)
    @Column(name = "fondo")
    private int fondo;
    @Basic(optional = false)
    @Column(name = "saldo_a_recibir")
    private String saldoARecibir;
    @Column(name = "gasto_extra")
    private Integer gastoExtra;
    @Basic(optional = false)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_conductor", referencedColumnName = "id_conductor")
    @ManyToOne(optional = false)
    private Conductores idConductor;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false)
    private Vehiculos idVehiculo;

    public Viajes() {
    }

    public Viajes(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Viajes(Integer idViaje, Date fecha, int porcentajeUber, int recaudacion, int fondo, String saldoARecibir, String observacion) {
        this.idViaje = idViaje;
        this.fecha = fecha;
        this.porcentajeUber = porcentajeUber;
        this.recaudacion = recaudacion;
        this.fondo = fondo;
        this.saldoARecibir = saldoARecibir;
        this.observacion = observacion;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCombustible() {
        return combustible;
    }

    public void setCombustible(Integer combustible) {
        this.combustible = combustible;
    }

    public int getPorcentajeUber() {
        return porcentajeUber;
    }

    public void setPorcentajeUber(int porcentajeUber) {
        this.porcentajeUber = porcentajeUber;
    }

    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public String getSaldoARecibir() {
        return saldoARecibir;
    }

    public void setSaldoARecibir(String saldoARecibir) {
        this.saldoARecibir = saldoARecibir;
    }

    public Integer getGastoExtra() {
        return gastoExtra;
    }

    public void setGastoExtra(Integer gastoExtra) {
        this.gastoExtra = gastoExtra;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Conductores getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Conductores idConductor) {
        this.idConductor = idConductor;
    }

    public Vehiculos getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculos idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idViaje != null ? idViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viajes)) {
            return false;
        }
        Viajes other = (Viajes) object;
        if ((this.idViaje == null && other.idViaje != null) || (this.idViaje != null && !this.idViaje.equals(other.idViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Viajes[ idViaje=" + idViaje + " ]";
    }
    
}
