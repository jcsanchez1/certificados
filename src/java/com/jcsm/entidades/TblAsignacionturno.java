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
@Table(name = "tbl_asignacionturno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAsignacionturno.findAll", query = "SELECT t FROM TblAsignacionturno t")
    , @NamedQuery(name = "TblAsignacionturno.findByIdasignacion", query = "SELECT t FROM TblAsignacionturno t WHERE t.idasignacion = :idasignacion")
    , @NamedQuery(name = "TblAsignacionturno.findByFechainicioatencion", query = "SELECT t FROM TblAsignacionturno t WHERE t.fechainicioatencion = :fechainicioatencion")
    , @NamedQuery(name = "TblAsignacionturno.findByFechafinalatencion", query = "SELECT t FROM TblAsignacionturno t WHERE t.fechafinalatencion = :fechafinalatencion")
    , @NamedQuery(name = "TblAsignacionturno.findByEstado", query = "SELECT t FROM TblAsignacionturno t WHERE t.estado = :estado")})
public class TblAsignacionturno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasignacion")
    private Integer idasignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicioatencion")
    @Temporal(TemporalType.DATE)
    private Date fechainicioatencion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafinalatencion")
    @Temporal(TemporalType.DATE)
    private Date fechafinalatencion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idasignacion")
    private List<TblFeedbackturno> tblFeedbackturnoList;
    @JoinColumn(name = "idturno", referencedColumnName = "idturno")
    @ManyToOne(optional = false)
    private TblTurnos idturno;
    @JoinColumn(name = "idpuesto", referencedColumnName = "idpuesto")
    @ManyToOne(optional = false)
    private TblPuestoservicio idpuesto;

    public TblAsignacionturno() {
    }

    public TblAsignacionturno(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public TblAsignacionturno(Integer idasignacion, Date fechainicioatencion, Date fechafinalatencion, int estado) {
        this.idasignacion = idasignacion;
        this.fechainicioatencion = fechainicioatencion;
        this.fechafinalatencion = fechafinalatencion;
        this.estado = estado;
    }

    public Integer getIdasignacion() {
        return idasignacion;
    }

    public void setIdasignacion(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public Date getFechainicioatencion() {
        return fechainicioatencion;
    }

    public void setFechainicioatencion(Date fechainicioatencion) {
        this.fechainicioatencion = fechainicioatencion;
    }

    public Date getFechafinalatencion() {
        return fechafinalatencion;
    }

    public void setFechafinalatencion(Date fechafinalatencion) {
        this.fechafinalatencion = fechafinalatencion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<TblFeedbackturno> getTblFeedbackturnoList() {
        return tblFeedbackturnoList;
    }

    public void setTblFeedbackturnoList(List<TblFeedbackturno> tblFeedbackturnoList) {
        this.tblFeedbackturnoList = tblFeedbackturnoList;
    }

    public TblTurnos getIdturno() {
        return idturno;
    }

    public void setIdturno(TblTurnos idturno) {
        this.idturno = idturno;
    }

    public TblPuestoservicio getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(TblPuestoservicio idpuesto) {
        this.idpuesto = idpuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasignacion != null ? idasignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAsignacionturno)) {
            return false;
        }
        TblAsignacionturno other = (TblAsignacionturno) object;
        if ((this.idasignacion == null && other.idasignacion != null) || (this.idasignacion != null && !this.idasignacion.equals(other.idasignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblAsignacionturno[ idasignacion=" + idasignacion + " ]";
    }
    
}
