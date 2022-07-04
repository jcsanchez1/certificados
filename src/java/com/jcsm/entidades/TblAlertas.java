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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "tbl_alertas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAlertas.findAll", query = "SELECT t FROM TblAlertas t")
    , @NamedQuery(name = "TblAlertas.findByIdalerta", query = "SELECT t FROM TblAlertas t WHERE t.idalerta = :idalerta")
    , @NamedQuery(name = "TblAlertas.findByDescripcion", query = "SELECT t FROM TblAlertas t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TblAlertas.findByDiaalerta", query = "SELECT t FROM TblAlertas t WHERE t.diaalerta = :diaalerta")
    , @NamedQuery(name = "TblAlertas.findByFechacreacion", query = "SELECT t FROM TblAlertas t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblAlertas.findByEstado", query = "SELECT t FROM TblAlertas t WHERE t.estado = :estado")})
public class TblAlertas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalerta")
    private Integer idalerta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diaalerta")
    private int diaalerta;
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

    public TblAlertas() {
    }

    public TblAlertas(Integer idalerta) {
        this.idalerta = idalerta;
    }

    public TblAlertas(Integer idalerta, String descripcion, int diaalerta, Date fechacreacion, int estado) {
        this.idalerta = idalerta;
        this.descripcion = descripcion;
        this.diaalerta = diaalerta;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getIdalerta() {
        return idalerta;
    }

    public void setIdalerta(Integer idalerta) {
        this.idalerta = idalerta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDiaalerta() {
        return diaalerta;
    }

    public void setDiaalerta(int diaalerta) {
        this.diaalerta = diaalerta;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalerta != null ? idalerta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAlertas)) {
            return false;
        }
        TblAlertas other = (TblAlertas) object;
        if ((this.idalerta == null && other.idalerta != null) || (this.idalerta != null && !this.idalerta.equals(other.idalerta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblAlertas[ idalerta=" + idalerta + " ]";
    }
    
}
