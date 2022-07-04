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
@Table(name = "tbl_votospersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblVotospersona.findAll", query = "SELECT t FROM TblVotospersona t")
    , @NamedQuery(name = "TblVotospersona.findByIdvoto", query = "SELECT t FROM TblVotospersona t WHERE t.idvoto = :idvoto")
    , @NamedQuery(name = "TblVotospersona.findByFechacreacion", query = "SELECT t FROM TblVotospersona t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblVotospersona.findByEstado", query = "SELECT t FROM TblVotospersona t WHERE t.estado = :estado")})
public class TblVotospersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvoto")
    private Integer idvoto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "idpersona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblPersonas idpersona;
    @JoinColumn(name = "idopcion", referencedColumnName = "idopcion")
    @ManyToOne(optional = false)
    private TblOpcionespropuesta idopcion;

    public TblVotospersona() {
    }

    public TblVotospersona(Integer idvoto) {
        this.idvoto = idvoto;
    }

    public TblVotospersona(Integer idvoto, Date fechacreacion, int estado) {
        this.idvoto = idvoto;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getIdvoto() {
        return idvoto;
    }

    public void setIdvoto(Integer idvoto) {
        this.idvoto = idvoto;
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

    public TblPersonas getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(TblPersonas idpersona) {
        this.idpersona = idpersona;
    }

    public TblOpcionespropuesta getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(TblOpcionespropuesta idopcion) {
        this.idopcion = idopcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvoto != null ? idvoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblVotospersona)) {
            return false;
        }
        TblVotospersona other = (TblVotospersona) object;
        if ((this.idvoto == null && other.idvoto != null) || (this.idvoto != null && !this.idvoto.equals(other.idvoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblVotospersona[ idvoto=" + idvoto + " ]";
    }
    
}
