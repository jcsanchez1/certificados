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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "tbl_opcionespropuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblOpcionespropuesta.findAll", query = "SELECT t FROM TblOpcionespropuesta t")
    , @NamedQuery(name = "TblOpcionespropuesta.findByIdopcion", query = "SELECT t FROM TblOpcionespropuesta t WHERE t.idopcion = :idopcion")
    , @NamedQuery(name = "TblOpcionespropuesta.findByOpcion", query = "SELECT t FROM TblOpcionespropuesta t WHERE t.opcion = :opcion")
    , @NamedQuery(name = "TblOpcionespropuesta.findByFechacreacion", query = "SELECT t FROM TblOpcionespropuesta t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblOpcionespropuesta.findByEstado", query = "SELECT t FROM TblOpcionespropuesta t WHERE t.estado = :estado")})
public class TblOpcionespropuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idopcion")
    private Integer idopcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "opcion")
    private String opcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "idpropuesta", referencedColumnName = "idpropuesta")
    @ManyToOne(optional = false)
    private TblPropuesta idpropuesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idopcion")
    private List<TblVotospersona> tblVotospersonaList;

    public TblOpcionespropuesta() {
    }

    public TblOpcionespropuesta(Integer idopcion) {
        this.idopcion = idopcion;
    }

    public TblOpcionespropuesta(Integer idopcion, String opcion, Date fechacreacion, int estado) {
        this.idopcion = idopcion;
        this.opcion = opcion;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(Integer idopcion) {
        this.idopcion = idopcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
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

    public TblPropuesta getIdpropuesta() {
        return idpropuesta;
    }

    public void setIdpropuesta(TblPropuesta idpropuesta) {
        this.idpropuesta = idpropuesta;
    }

    @XmlTransient
    public List<TblVotospersona> getTblVotospersonaList() {
        return tblVotospersonaList;
    }

    public void setTblVotospersonaList(List<TblVotospersona> tblVotospersonaList) {
        this.tblVotospersonaList = tblVotospersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idopcion != null ? idopcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpcionespropuesta)) {
            return false;
        }
        TblOpcionespropuesta other = (TblOpcionespropuesta) object;
        if ((this.idopcion == null && other.idopcion != null) || (this.idopcion != null && !this.idopcion.equals(other.idopcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblOpcionespropuesta[ idopcion=" + idopcion + " ]";
    }
    
}
