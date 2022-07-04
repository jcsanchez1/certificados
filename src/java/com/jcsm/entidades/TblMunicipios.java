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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMunicipios.findAll", query = "SELECT t FROM TblMunicipios t")
    , @NamedQuery(name = "TblMunicipios.findByIdtblMunicipios", query = "SELECT t FROM TblMunicipios t WHERE t.idtblMunicipios = :idtblMunicipios")
    , @NamedQuery(name = "TblMunicipios.findByCodigomunicipio", query = "SELECT t FROM TblMunicipios t WHERE t.codigomunicipio = :codigomunicipio")
    , @NamedQuery(name = "TblMunicipios.findByMunicipio", query = "SELECT t FROM TblMunicipios t WHERE t.municipio = :municipio")})
public class TblMunicipios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbl_municipios")
    private Integer idtblMunicipios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigomunicipio")
    private String codigomunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "municipio")
    private String municipio;
    @JoinColumn(name = "iddepto", referencedColumnName = "iddepto")
    @ManyToOne(optional = false)
    private TblDepartamentos iddepto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private List<TblFiliales> tblFilialesList;

    public TblMunicipios() {
    }

    public TblMunicipios(Integer idtblMunicipios) {
        this.idtblMunicipios = idtblMunicipios;
    }

    public TblMunicipios(Integer idtblMunicipios, String codigomunicipio, String municipio) {
        this.idtblMunicipios = idtblMunicipios;
        this.codigomunicipio = codigomunicipio;
        this.municipio = municipio;
    }

    public Integer getIdtblMunicipios() {
        return idtblMunicipios;
    }

    public void setIdtblMunicipios(Integer idtblMunicipios) {
        this.idtblMunicipios = idtblMunicipios;
    }

    public String getCodigomunicipio() {
        return codigomunicipio;
    }

    public void setCodigomunicipio(String codigomunicipio) {
        this.codigomunicipio = codigomunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public TblDepartamentos getIddepto() {
        return iddepto;
    }

    public void setIddepto(TblDepartamentos iddepto) {
        this.iddepto = iddepto;
    }

    @XmlTransient
    public List<TblFiliales> getTblFilialesList() {
        return tblFilialesList;
    }

    public void setTblFilialesList(List<TblFiliales> tblFilialesList) {
        this.tblFilialesList = tblFilialesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtblMunicipios != null ? idtblMunicipios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMunicipios)) {
            return false;
        }
        TblMunicipios other = (TblMunicipios) object;
        if ((this.idtblMunicipios == null && other.idtblMunicipios != null) || (this.idtblMunicipios != null && !this.idtblMunicipios.equals(other.idtblMunicipios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblMunicipios[ idtblMunicipios=" + idtblMunicipios + " ]";
    }
    
}
