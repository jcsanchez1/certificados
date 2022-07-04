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
@Table(name = "tbl_modulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblModulos.findAll", query = "SELECT t FROM TblModulos t")
    , @NamedQuery(name = "TblModulos.findByIdmodulo", query = "SELECT t FROM TblModulos t WHERE t.idmodulo = :idmodulo")
    , @NamedQuery(name = "TblModulos.findByTitulo", query = "SELECT t FROM TblModulos t WHERE t.titulo = :titulo")
    , @NamedQuery(name = "TblModulos.findByStatus", query = "SELECT t FROM TblModulos t WHERE t.status = :status")})
public class TblModulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmodulo")
    private Integer idmodulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "titulo")
    private String titulo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduloid")
    private List<TblPermisos> tblPermisosList;

    public TblModulos() {
    }

    public TblModulos(Integer idmodulo) {
        this.idmodulo = idmodulo;
    }

    public TblModulos(Integer idmodulo, String titulo, String descripcion, int status) {
        this.idmodulo = idmodulo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.status = status;
    }

    public Integer getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(Integer idmodulo) {
        this.idmodulo = idmodulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodulo != null ? idmodulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblModulos)) {
            return false;
        }
        TblModulos other = (TblModulos) object;
        if ((this.idmodulo == null && other.idmodulo != null) || (this.idmodulo != null && !this.idmodulo.equals(other.idmodulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblModulos[ idmodulo=" + idmodulo + " ]";
    }
    
}
