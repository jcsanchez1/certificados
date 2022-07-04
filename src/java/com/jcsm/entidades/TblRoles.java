/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcsm.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "tbl_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRoles.findAll", query = "SELECT t FROM TblRoles t")
    , @NamedQuery(name = "TblRoles.findByIdrol", query = "SELECT t FROM TblRoles t WHERE t.idrol = :idrol")
    , @NamedQuery(name = "TblRoles.findByNombrerol", query = "SELECT t FROM TblRoles t WHERE t.nombrerol = :nombrerol")
    , @NamedQuery(name = "TblRoles.findByStatus", query = "SELECT t FROM TblRoles t WHERE t.status = :status")})
public class TblRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrol")
    private Integer idrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrerol")
    private String nombrerol;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolid")
    private List<TblPermisos> tblPermisosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrol")
    private List<TblPersonas> tblPersonasList;

    public TblRoles() {
    }

    public TblRoles(Integer idrol) {
        this.idrol = idrol;
    }

    public TblRoles(Integer idrol, String nombrerol, String descripcion, int status) {
        this.idrol = idrol;
        this.nombrerol = nombrerol;
        this.descripcion = descripcion;
        this.status = status;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<TblPermisos> getTblPermisosList() {
        return tblPermisosList;
    }

    public void setTblPermisosList(List<TblPermisos> tblPermisosList) {
        this.tblPermisosList = tblPermisosList;
    }

    @XmlTransient
    public List<TblPersonas> getTblPersonasList() {
        return tblPersonasList;
    }

    public void setTblPersonasList(List<TblPersonas> tblPersonasList) {
        this.tblPersonasList = tblPersonasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRoles)) {
            return false;
        }
        TblRoles other = (TblRoles) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblRoles[ idrol=" + idrol + " ]";
    }
    
}
