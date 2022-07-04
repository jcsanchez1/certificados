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
@Table(name = "tbl_asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAsistencia.findAll", query = "SELECT t FROM TblAsistencia t")
    , @NamedQuery(name = "TblAsistencia.findByIdasistencia", query = "SELECT t FROM TblAsistencia t WHERE t.idasistencia = :idasistencia")
    , @NamedQuery(name = "TblAsistencia.findByFechacreacion", query = "SELECT t FROM TblAsistencia t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblAsistencia.findByEstado", query = "SELECT t FROM TblAsistencia t WHERE t.estado = :estado")})
public class TblAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasistencia")
    private Integer idasistencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "tblcurso", referencedColumnName = "curid")
    @ManyToOne(optional = false)
    private TblCursos tblcurso;
    @JoinColumn(name = "tblapersona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblPersonas tblapersona;

    public TblAsistencia() {
    }

    public TblAsistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public TblAsistencia(Integer idasistencia, Date fechacreacion, int estado) {
        this.idasistencia = idasistencia;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
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

    public TblCursos getTblcurso() {
        return tblcurso;
    }

    public void setTblcurso(TblCursos tblcurso) {
        this.tblcurso = tblcurso;
    }

    public TblPersonas getTblapersona() {
        return tblapersona;
    }

    public void setTblapersona(TblPersonas tblapersona) {
        this.tblapersona = tblapersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasistencia != null ? idasistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAsistencia)) {
            return false;
        }
        TblAsistencia other = (TblAsistencia) object;
        if ((this.idasistencia == null && other.idasistencia != null) || (this.idasistencia != null && !this.idasistencia.equals(other.idasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblAsistencia[ idasistencia=" + idasistencia + " ]";
    }
    
}
