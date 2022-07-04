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
@Table(name = "tbl_departamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDepartamentos.findAll", query = "SELECT t FROM TblDepartamentos t")
    , @NamedQuery(name = "TblDepartamentos.findByIddepto", query = "SELECT t FROM TblDepartamentos t WHERE t.iddepto = :iddepto")
    , @NamedQuery(name = "TblDepartamentos.findByCodigodepto", query = "SELECT t FROM TblDepartamentos t WHERE t.codigodepto = :codigodepto")
    , @NamedQuery(name = "TblDepartamentos.findByDepartamento", query = "SELECT t FROM TblDepartamentos t WHERE t.departamento = :departamento")})
public class TblDepartamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddepto")
    private Integer iddepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigodepto")
    private String codigodepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "departamento")
    private String departamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddepto")
    private List<TblMunicipios> tblMunicipiosList;

    public TblDepartamentos() {
    }

    public TblDepartamentos(Integer iddepto) {
        this.iddepto = iddepto;
    }

    public TblDepartamentos(Integer iddepto, String codigodepto, String departamento) {
        this.iddepto = iddepto;
        this.codigodepto = codigodepto;
        this.departamento = departamento;
    }

    public Integer getIddepto() {
        return iddepto;
    }

    public void setIddepto(Integer iddepto) {
        this.iddepto = iddepto;
    }

    public String getCodigodepto() {
        return codigodepto;
    }

    public void setCodigodepto(String codigodepto) {
        this.codigodepto = codigodepto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @XmlTransient
    public List<TblMunicipios> getTblMunicipiosList() {
        return tblMunicipiosList;
    }

    public void setTblMunicipiosList(List<TblMunicipios> tblMunicipiosList) {
        this.tblMunicipiosList = tblMunicipiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepto != null ? iddepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDepartamentos)) {
            return false;
        }
        TblDepartamentos other = (TblDepartamentos) object;
        if ((this.iddepto == null && other.iddepto != null) || (this.iddepto != null && !this.iddepto.equals(other.iddepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblDepartamentos[ iddepto=" + iddepto + " ]";
    }
    
}
