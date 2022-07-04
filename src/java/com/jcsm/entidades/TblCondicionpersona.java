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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "tbl_condicionpersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCondicionpersona.findAll", query = "SELECT t FROM TblCondicionpersona t")
    , @NamedQuery(name = "TblCondicionpersona.findByIdpersona", query = "SELECT t FROM TblCondicionpersona t WHERE t.idpersona = :idpersona")
    , @NamedQuery(name = "TblCondicionpersona.findByDiscapacidad", query = "SELECT t FROM TblCondicionpersona t WHERE t.discapacidad = :discapacidad")
    , @NamedQuery(name = "TblCondicionpersona.findByEmbarazado", query = "SELECT t FROM TblCondicionpersona t WHERE t.embarazado = :embarazado")})
public class TblCondicionpersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersona")
    private Integer idpersona;
    @Column(name = "discapacidad")
    private Integer discapacidad;
    @Column(name = "embarazado")
    private Integer embarazado;
    @JoinColumn(name = "idpersona", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TblPersonas tblPersonas;

    public TblCondicionpersona() {
    }

    public TblCondicionpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Integer getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Integer discapacidad) {
        this.discapacidad = discapacidad;
    }

    public Integer getEmbarazado() {
        return embarazado;
    }

    public void setEmbarazado(Integer embarazado) {
        this.embarazado = embarazado;
    }

    public TblPersonas getTblPersonas() {
        return tblPersonas;
    }

    public void setTblPersonas(TblPersonas tblPersonas) {
        this.tblPersonas = tblPersonas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCondicionpersona)) {
            return false;
        }
        TblCondicionpersona other = (TblCondicionpersona) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblCondicionpersona[ idpersona=" + idpersona + " ]";
    }
    
}
