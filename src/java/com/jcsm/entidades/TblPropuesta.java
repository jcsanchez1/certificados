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
 * @author juanc
 */
@Entity
@Table(name = "tbl_propuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPropuesta.findAll", query = "SELECT t FROM TblPropuesta t")
    , @NamedQuery(name = "TblPropuesta.findByIdpropuesta", query = "SELECT t FROM TblPropuesta t WHERE t.idpropuesta = :idpropuesta")
    , @NamedQuery(name = "TblPropuesta.findByPropuesta", query = "SELECT t FROM TblPropuesta t WHERE t.propuesta = :propuesta")
    , @NamedQuery(name = "TblPropuesta.findByFechacreacion", query = "SELECT t FROM TblPropuesta t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblPropuesta.findByEstado", query = "SELECT t FROM TblPropuesta t WHERE t.estado = :estado")})
public class TblPropuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpropuesta")
    private Integer idpropuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "propuesta")
    private String propuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpropuesta")
    private List<TblOpcionespropuesta> tblOpcionespropuestaList;

    public TblPropuesta() {
    }

    public TblPropuesta(Integer idpropuesta) {
        this.idpropuesta = idpropuesta;
    }

    public TblPropuesta(Integer idpropuesta, String propuesta, Date fechacreacion, int estado) {
        this.idpropuesta = idpropuesta;
        this.propuesta = propuesta;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getIdpropuesta() {
        return idpropuesta;
    }

    public void setIdpropuesta(Integer idpropuesta) {
        this.idpropuesta = idpropuesta;
    }

    public String getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(String propuesta) {
        this.propuesta = propuesta;
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

    @XmlTransient
    public List<TblOpcionespropuesta> getTblOpcionespropuestaList() {
        return tblOpcionespropuestaList;
    }

    public void setTblOpcionespropuestaList(List<TblOpcionespropuesta> tblOpcionespropuestaList) {
        this.tblOpcionespropuestaList = tblOpcionespropuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpropuesta != null ? idpropuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPropuesta)) {
            return false;
        }
        TblPropuesta other = (TblPropuesta) object;
        if ((this.idpropuesta == null && other.idpropuesta != null) || (this.idpropuesta != null && !this.idpropuesta.equals(other.idpropuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblPropuesta[ idpropuesta=" + idpropuesta + " ]";
    }
    
}
