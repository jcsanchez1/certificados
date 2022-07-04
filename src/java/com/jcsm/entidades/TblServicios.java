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
@Table(name = "tbl_servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServicios.findAll", query = "SELECT t FROM TblServicios t")
    , @NamedQuery(name = "TblServicios.findByIdservicios", query = "SELECT t FROM TblServicios t WHERE t.idservicios = :idservicios")
    , @NamedQuery(name = "TblServicios.findByServicio", query = "SELECT t FROM TblServicios t WHERE t.servicio = :servicio")
    , @NamedQuery(name = "TblServicios.findByEstado", query = "SELECT t FROM TblServicios t WHERE t.estado = :estado")})
public class TblServicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservicios")
    private Integer idservicios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "servicio")
    private String servicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicio")
    private List<TblTurnos> tblTurnosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicio")
    private List<TblPuestoservicio> tblPuestoservicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicio")
    private List<TblSubservicios> tblSubserviciosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblServicios")
    private List<TblFilialservicio> tblFilialservicioList;

    public TblServicios() {
    }

    public TblServicios(Integer idservicios) {
        this.idservicios = idservicios;
    }

    public TblServicios(Integer idservicios, String servicio, int estado) {
        this.idservicios = idservicios;
        this.servicio = servicio;
        this.estado = estado;
    }

    public Integer getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(Integer idservicios) {
        this.idservicios = idservicios;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<TblTurnos> getTblTurnosList() {
        return tblTurnosList;
    }

    public void setTblTurnosList(List<TblTurnos> tblTurnosList) {
        this.tblTurnosList = tblTurnosList;
    }

    @XmlTransient
    public List<TblPuestoservicio> getTblPuestoservicioList() {
        return tblPuestoservicioList;
    }

    public void setTblPuestoservicioList(List<TblPuestoservicio> tblPuestoservicioList) {
        this.tblPuestoservicioList = tblPuestoservicioList;
    }

    @XmlTransient
    public List<TblSubservicios> getTblSubserviciosList() {
        return tblSubserviciosList;
    }

    public void setTblSubserviciosList(List<TblSubservicios> tblSubserviciosList) {
        this.tblSubserviciosList = tblSubserviciosList;
    }

    @XmlTransient
    public List<TblFilialservicio> getTblFilialservicioList() {
        return tblFilialservicioList;
    }

    public void setTblFilialservicioList(List<TblFilialservicio> tblFilialservicioList) {
        this.tblFilialservicioList = tblFilialservicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservicios != null ? idservicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServicios)) {
            return false;
        }
        TblServicios other = (TblServicios) object;
        if ((this.idservicios == null && other.idservicios != null) || (this.idservicios != null && !this.idservicios.equals(other.idservicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblServicios[ idservicios=" + idservicios + " ]";
    }
    
}
