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
@Table(name = "tbl_categoriacursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCategoriacursos.findAll", query = "SELECT t FROM TblCategoriacursos t")
    , @NamedQuery(name = "TblCategoriacursos.findByCatid", query = "SELECT t FROM TblCategoriacursos t WHERE t.catid = :catid")
    , @NamedQuery(name = "TblCategoriacursos.findByNombrecategoria", query = "SELECT t FROM TblCategoriacursos t WHERE t.nombrecategoria = :nombrecategoria")
    , @NamedQuery(name = "TblCategoriacursos.findByFechacreacion", query = "SELECT t FROM TblCategoriacursos t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblCategoriacursos.findByEstado", query = "SELECT t FROM TblCategoriacursos t WHERE t.estado = :estado")})
public class TblCategoriacursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "catid")
    private Integer catid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombrecategoria")
    private String nombrecategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @OneToMany(mappedBy = "categoriaid")
    private List<TblCursos> tblCursosList;

    public TblCategoriacursos() {
    }

    public TblCategoriacursos(Integer catid) {
        this.catid = catid;
    }

    public TblCategoriacursos(Integer catid, String nombrecategoria, Date fechacreacion, int estado) {
        this.catid = catid;
        this.nombrecategoria = nombrecategoria;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
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
    public List<TblCursos> getTblCursosList() {
        return tblCursosList;
    }

    public void setTblCursosList(List<TblCursos> tblCursosList) {
        this.tblCursosList = tblCursosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catid != null ? catid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCategoriacursos)) {
            return false;
        }
        TblCategoriacursos other = (TblCategoriacursos) object;
        if ((this.catid == null && other.catid != null) || (this.catid != null && !this.catid.equals(other.catid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblCategoriacursos[ catid=" + catid + " ]";
    }
    
}
