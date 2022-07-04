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
@Table(name = "tbl_certificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCertificaciones.findAll", query = "SELECT t FROM TblCertificaciones t")
    , @NamedQuery(name = "TblCertificaciones.findByIdcertificacion", query = "SELECT t FROM TblCertificaciones t WHERE t.idcertificacion = :idcertificacion")
    , @NamedQuery(name = "TblCertificaciones.findByFechacreacion", query = "SELECT t FROM TblCertificaciones t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblCertificaciones.findByEstado", query = "SELECT t FROM TblCertificaciones t WHERE t.estado = :estado")})
public class TblCertificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcertificacion")
    private Integer idcertificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "idcurso", referencedColumnName = "curid")
    @ManyToOne(optional = false)
    private TblCursos idcurso;
    @JoinColumn(name = "curparid", referencedColumnName = "curparid")
    @ManyToOne
    private TblParticipantescursos curparid;

    public TblCertificaciones() {
    }

    public TblCertificaciones(Integer idcertificacion) {
        this.idcertificacion = idcertificacion;
    }

    public TblCertificaciones(Integer idcertificacion, Date fechacreacion, int estado) {
        this.idcertificacion = idcertificacion;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getIdcertificacion() {
        return idcertificacion;
    }

    public void setIdcertificacion(Integer idcertificacion) {
        this.idcertificacion = idcertificacion;
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

    public TblCursos getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(TblCursos idcurso) {
        this.idcurso = idcurso;
    }

    public TblParticipantescursos getCurparid() {
        return curparid;
    }

    public void setCurparid(TblParticipantescursos curparid) {
        this.curparid = curparid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcertificacion != null ? idcertificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCertificaciones)) {
            return false;
        }
        TblCertificaciones other = (TblCertificaciones) object;
        if ((this.idcertificacion == null && other.idcertificacion != null) || (this.idcertificacion != null && !this.idcertificacion.equals(other.idcertificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblCertificaciones[ idcertificacion=" + idcertificacion + " ]";
    }
    
}
