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
 * @author juanc
 */
@Entity
@Table(name = "tbl_feedbackturno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFeedbackturno.findAll", query = "SELECT t FROM TblFeedbackturno t")
    , @NamedQuery(name = "TblFeedbackturno.findByIdfeedback", query = "SELECT t FROM TblFeedbackturno t WHERE t.idfeedback = :idfeedback")
    , @NamedQuery(name = "TblFeedbackturno.findByCalificacion", query = "SELECT t FROM TblFeedbackturno t WHERE t.calificacion = :calificacion")
    , @NamedQuery(name = "TblFeedbackturno.findByFechacreacion", query = "SELECT t FROM TblFeedbackturno t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblFeedbackturno.findByEstado", query = "SELECT t FROM TblFeedbackturno t WHERE t.estado = :estado")})
public class TblFeedbackturno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfeedback")
    private Integer idfeedback;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private int calificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "idasignacion", referencedColumnName = "idasignacion")
    @ManyToOne(optional = false)
    private TblAsignacionturno idasignacion;

    public TblFeedbackturno() {
    }

    public TblFeedbackturno(Integer idfeedback) {
        this.idfeedback = idfeedback;
    }

    public TblFeedbackturno(Integer idfeedback, int calificacion, Date fechacreacion, int estado) {
        this.idfeedback = idfeedback;
        this.calificacion = calificacion;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getIdfeedback() {
        return idfeedback;
    }

    public void setIdfeedback(Integer idfeedback) {
        this.idfeedback = idfeedback;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
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

    public TblAsignacionturno getIdasignacion() {
        return idasignacion;
    }

    public void setIdasignacion(TblAsignacionturno idasignacion) {
        this.idasignacion = idasignacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfeedback != null ? idfeedback.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFeedbackturno)) {
            return false;
        }
        TblFeedbackturno other = (TblFeedbackturno) object;
        if ((this.idfeedback == null && other.idfeedback != null) || (this.idfeedback != null && !this.idfeedback.equals(other.idfeedback))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblFeedbackturno[ idfeedback=" + idfeedback + " ]";
    }
    
}
