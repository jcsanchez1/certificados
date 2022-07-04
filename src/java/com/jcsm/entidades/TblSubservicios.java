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
@Table(name = "tbl_subservicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSubservicios.findAll", query = "SELECT t FROM TblSubservicios t")
    , @NamedQuery(name = "TblSubservicios.findByIdsubservicio", query = "SELECT t FROM TblSubservicios t WHERE t.idsubservicio = :idsubservicio")
    , @NamedQuery(name = "TblSubservicios.findBySubservicio", query = "SELECT t FROM TblSubservicios t WHERE t.subservicio = :subservicio")
    , @NamedQuery(name = "TblSubservicios.findByEstado", query = "SELECT t FROM TblSubservicios t WHERE t.estado = :estado")})
public class TblSubservicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubservicio")
    private Integer idsubservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "subservicio")
    private String subservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsubservicio")
    private List<TblTurnos> tblTurnosList;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicios")
    @ManyToOne(optional = false)
    private TblServicios idservicio;

    public TblSubservicios() {
    }

    public TblSubservicios(Integer idsubservicio) {
        this.idsubservicio = idsubservicio;
    }

    public TblSubservicios(Integer idsubservicio, String subservicio, int estado) {
        this.idsubservicio = idsubservicio;
        this.subservicio = subservicio;
        this.estado = estado;
    }

    public Integer getIdsubservicio() {
        return idsubservicio;
    }

    public void setIdsubservicio(Integer idsubservicio) {
        this.idsubservicio = idsubservicio;
    }

    public String getSubservicio() {
        return subservicio;
    }

    public void setSubservicio(String subservicio) {
        this.subservicio = subservicio;
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

    public TblServicios getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(TblServicios idservicio) {
        this.idservicio = idservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubservicio != null ? idsubservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSubservicios)) {
            return false;
        }
        TblSubservicios other = (TblSubservicios) object;
        if ((this.idsubservicio == null && other.idsubservicio != null) || (this.idsubservicio != null && !this.idsubservicio.equals(other.idsubservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblSubservicios[ idsubservicio=" + idsubservicio + " ]";
    }
    
}
