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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "tbl_configuracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblConfiguracion.findAll", query = "SELECT t FROM TblConfiguracion t")
    , @NamedQuery(name = "TblConfiguracion.findById", query = "SELECT t FROM TblConfiguracion t WHERE t.id = :id")
    , @NamedQuery(name = "TblConfiguracion.findByLogo", query = "SELECT t FROM TblConfiguracion t WHERE t.logo = :logo")
    , @NamedQuery(name = "TblConfiguracion.findByLogopeque", query = "SELECT t FROM TblConfiguracion t WHERE t.logopeque = :logopeque")
    , @NamedQuery(name = "TblConfiguracion.findByNombre", query = "SELECT t FROM TblConfiguracion t WHERE t.nombre = :nombre")})
public class TblConfiguracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "logo")
    private String logo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "logopeque")
    private String logopeque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombre")
    private String nombre;

    public TblConfiguracion() {
    }

    public TblConfiguracion(Integer id) {
        this.id = id;
    }

    public TblConfiguracion(Integer id, String logo, String logopeque, String nombre) {
        this.id = id;
        this.logo = logo;
        this.logopeque = logopeque;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogopeque() {
        return logopeque;
    }

    public void setLogopeque(String logopeque) {
        this.logopeque = logopeque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblConfiguracion)) {
            return false;
        }
        TblConfiguracion other = (TblConfiguracion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblConfiguracion[ id=" + id + " ]";
    }
    
}
