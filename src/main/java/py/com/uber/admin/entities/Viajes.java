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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "viajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viajes.findAll", query = "SELECT v FROM Viajes v")
    , @NamedQuery(name = "Viajes.findByIdViaje", query = "SELECT v FROM Viajes v WHERE v.idViaje = :idViaje")
    , @NamedQuery(name = "Viajes.findByFecha", query = "SELECT v FROM Viajes v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Viajes.findByRecaudacion", query = "SELECT v FROM Viajes v WHERE v.recaudacion = :recaudacion")
    , @NamedQuery(name = "Viajes.findByCombustible", query = "SELECT v FROM Viajes v WHERE v.combustible = :combustible")
    , @NamedQuery(name = "Viajes.findByGanancia", query = "SELECT v FROM Viajes v WHERE v.ganancia = :ganancia")
    , @NamedQuery(name = "Viajes.findBySaldoARecibir", query = "SELECT v FROM Viajes v WHERE v.saldoARecibir = :saldoARecibir")
    , @NamedQuery(name = "Viajes.findByFondo", query = "SELECT v FROM Viajes v WHERE v.fondo = :fondo")
    , @NamedQuery(name = "Viajes.findByPorcenajeUber", query = "SELECT v FROM Viajes v WHERE v.porcenajeUber = :porcenajeUber")})
public class Viajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_viaje")
    private Integer idViaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recaudacion")
    private int recaudacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "combustible")
    private int combustible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ganancia")
    private int ganancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_a_recibir")
    private int saldoARecibir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fondo")
    private int fondo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcenaje_uber")
    private int porcenajeUber;
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

    public Viajes(Integer idViaje, Date fecha, int recaudacion, int combustible, int ganancia, int saldoARecibir, int fondo, int porcenajeUber) {
        this.idViaje = idViaje;
        this.fecha = fecha;
        this.recaudacion = recaudacion;
        this.combustible = combustible;
        this.ganancia = ganancia;
        this.saldoARecibir = saldoARecibir;
        this.fondo = fondo;
        this.porcenajeUber = porcenajeUber;
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

    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public int getGanancia() {
        return ganancia;
    }

    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
    }

    public int getSaldoARecibir() {
        return saldoARecibir;
    }

    public void setSaldoARecibir(int saldoARecibir) {
        this.saldoARecibir = saldoARecibir;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public int getPorcenajeUber() {
        return porcenajeUber;
    }

    public void setPorcenajeUber(int porcenajeUber) {
        this.porcenajeUber = porcenajeUber;
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
        return "entity.Viajes[ idViaje=" + idViaje + " ]";
    }
    
}
