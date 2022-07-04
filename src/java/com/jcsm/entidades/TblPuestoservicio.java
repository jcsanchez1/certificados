/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcsm.entidades;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "tbl_puestoservicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPuestoservicio.findAll", query = "SELECT t FROM TblPuestoservicio t")
    , @NamedQuery(name = "TblPuestoservicio.findByIdpuesto", query = "SELECT t FROM TblPuestoservicio t WHERE t.idpuesto = :idpuesto")
    , @NamedQuery(name = "TblPuestoservicio.findByFechacreacion", query = "SELECT t FROM TblPuestoservicio t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblPuestoservicio.findByEstado", query = "SELECT t FROM TblPuestoservicio t WHERE t.estado = :estado")
    , @NamedQuery(name = "TblPuestoservicio.findByNumeroventanilla", query = "SELECT t FROM TblPuestoservicio t WHERE t.numeroventanilla = :numeroventanilla")})
public class TblPuestoservicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpuesto")
    private Integer idpuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Column(name = "numeroventanilla")
    private Integer numeroventanilla;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicios")
    @ManyToOne(optional = false)
    private TblServicios idservicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpuesto")
    private List<TlbEmpleadopuesto> tlbEmpleadopuestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpuesto")
    private List<TblAsignacionturno> tblAsignacionturnoList;

    public TblPuestoservicio() {
    }

    public TblPuestoservicio(Integer idpuesto) {
        this.idpuesto = idpuesto;
    }

    public TblPuestoservicio(Integer idpuesto, Date fechacreacion, int estado) {
        this.idpuesto = idpuesto;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(Integer idpuesto) {
        this.idpuesto = idpuesto;
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

    public Integer getNumeroventanilla() {
        return numeroventanilla;
    }

    public void setNumeroventanilla(Integer numeroventanilla) {
        this.numeroventanilla = numeroventanilla;
    }

    public TblServicios getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(TblServicios idservicio) {
        this.idservicio = idservicio;
    }

    @XmlTransient
    public List<TlbEmpleadopuesto> getTlbEmpleadopuestoList() {
        return tlbEmpleadopuestoList;
    }

    public void setTlbEmpleadopuestoList(List<TlbEmpleadopuesto> tlbEmpleadopuestoList) {
        this.tlbEmpleadopuestoList = tlbEmpleadopuestoList;
    }

    @XmlTransient
    public List<TblAsignacionturno> getTblAsignacionturnoList() {
        return tblAsignacionturnoList;
    }

    public void setTblAsignacionturnoList(List<TblAsignacionturno> tblAsignacionturnoList) {
        this.tblAsignacionturnoList = tblAsignacionturnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpuesto != null ? idpuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPuestoservicio)) {
            return false;
        }
        TblPuestoservicio other = (TblPuestoservicio) object;
        if ((this.idpuesto == null && other.idpuesto != null) || (this.idpuesto != null && !this.idpuesto.equals(other.idpuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblPuestoservicio[ idpuesto=" + idpuesto + " ]";
    }
    
}
