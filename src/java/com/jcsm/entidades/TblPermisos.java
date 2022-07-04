/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcsm.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "tbl_permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPermisos.findAll", query = "SELECT t FROM TblPermisos t")
    , @NamedQuery(name = "TblPermisos.findByIdpermiso", query = "SELECT t FROM TblPermisos t WHERE t.idpermiso = :idpermiso")
    , @NamedQuery(name = "TblPermisos.findByR", query = "SELECT t FROM TblPermisos t WHERE t.r = :r")
    , @NamedQuery(name = "TblPermisos.findByW", query = "SELECT t FROM TblPermisos t WHERE t.w = :w")
    , @NamedQuery(name = "TblPermisos.findByU", query = "SELECT t FROM TblPermisos t WHERE t.u = :u")
    , @NamedQuery(name = "TblPermisos.findByD", query = "SELECT t FROM TblPermisos t WHERE t.d = :d")})
public class TblPermisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpermiso")
    private Integer idpermiso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "r")
    private int r;
    @Basic(optional = false)
    @NotNull
    @Column(name = "w")
    private int w;
    @Basic(optional = false)
    @NotNull
    @Column(name = "u")
    private int u;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d")
    private int d;
    @JoinColumn(name = "rolid", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private TblRoles rolid;
    @JoinColumn(name = "moduloid", referencedColumnName = "idmodulo")
    @ManyToOne(optional = false)
    private TblModulos moduloid;

    public TblPermisos() {
    }

    public TblPermisos(Integer idpermiso) {
        this.idpermiso = idpermiso;
    }

    public TblPermisos(Integer idpermiso, int r, int w, int u, int d) {
        this.idpermiso = idpermiso;
        this.r = r;
        this.w = w;
        this.u = u;
        this.d = d;
    }

    public Integer getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(Integer idpermiso) {
        this.idpermiso = idpermiso;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public TblRoles getRolid() {
        return rolid;
    }

    public void setRolid(TblRoles rolid) {
        this.rolid = rolid;
    }

    public TblModulos getModuloid() {
        return moduloid;
    }

    public void setModuloid(TblModulos moduloid) {
        this.moduloid = moduloid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpermiso != null ? idpermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPermisos)) {
            return false;
        }
        TblPermisos other = (TblPermisos) object;
        if ((this.idpermiso == null && other.idpermiso != null) || (this.idpermiso != null && !this.idpermiso.equals(other.idpermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblPermisos[ idpermiso=" + idpermiso + " ]";
    }
    
}
