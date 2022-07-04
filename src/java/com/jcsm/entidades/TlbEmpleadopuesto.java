/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcsm.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author juanc
 */
@Entity
@Table(name = "tlb_empleadopuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TlbEmpleadopuesto.findAll", query = "SELECT t FROM TlbEmpleadopuesto t")
    , @NamedQuery(name = "TlbEmpleadopuesto.findByFechacreacion", query = "SELECT t FROM TlbEmpleadopuesto t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TlbEmpleadopuesto.findByEstado", query = "SELECT t FROM TlbEmpleadopuesto t WHERE t.estado = :estado")
    , @NamedQuery(name = "TlbEmpleadopuesto.findByIdempleadopuesto", query = "SELECT t FROM TlbEmpleadopuesto t WHERE t.idempleadopuesto = :idempleadopuesto")})
public class TlbEmpleadopuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempleadopuesto")
    private Integer idempleadopuesto;
    @JoinColumn(name = "idpuesto", referencedColumnName = "idpuesto")
    @ManyToOne(optional = false)
    private TblPuestoservicio idpuesto;
    @JoinColumn(name = "idpersona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblPersonas idpersona;

    public TlbEmpleadopuesto() {
    }

    public TlbEmpleadopuesto(Integer idempleadopuesto) {
        this.idempleadopuesto = idempleadopuesto;
    }

    public TlbEmpleadopuesto(Integer idempleadopuesto, Date fechacreacion, int estado) {
        this.idempleadopuesto = idempleadopuesto;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Integer getIdempleadopuesto() {
        return idempleadopuesto;
    }

    public void setIdempleadopuesto(Integer idempleadopuesto) {
        this.idempleadopuesto = idempleadopuesto;
    }

    public TblPuestoservicio getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(TblPuestoservicio idpuesto) {
        this.idpuesto = idpuesto;
    }

    public TblPersonas getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(TblPersonas idpersona) {
        this.idpersona = idpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleadopuesto != null ? idempleadopuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlbEmpleadopuesto)) {
            return false;
        }
        TlbEmpleadopuesto other = (TlbEmpleadopuesto) object;
        if ((this.idempleadopuesto == null && other.idempleadopuesto != null) || (this.idempleadopuesto != null && !this.idempleadopuesto.equals(other.idempleadopuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TlbEmpleadopuesto[ idempleadopuesto=" + idempleadopuesto + " ]";
    }
    
}
