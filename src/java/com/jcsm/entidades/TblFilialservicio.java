/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcsm.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "tbl_filialservicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFilialservicio.findAll", query = "SELECT t FROM TblFilialservicio t")
    , @NamedQuery(name = "TblFilialservicio.findByIdfilial", query = "SELECT t FROM TblFilialservicio t WHERE t.tblFilialservicioPK.idfilial = :idfilial")
    , @NamedQuery(name = "TblFilialservicio.findByIdservicio", query = "SELECT t FROM TblFilialservicio t WHERE t.tblFilialservicioPK.idservicio = :idservicio")
    , @NamedQuery(name = "TblFilialservicio.findByFechacreacion", query = "SELECT t FROM TblFilialservicio t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblFilialservicio.findByEstado", query = "SELECT t FROM TblFilialservicio t WHERE t.estado = :estado")})
public class TblFilialservicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblFilialservicioPK tblFilialservicioPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "idfilial", referencedColumnName = "idfilial", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblFiliales tblFiliales;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicios", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblServicios tblServicios;

    public TblFilialservicio() {
    }

    public TblFilialservicio(TblFilialservicioPK tblFilialservicioPK) {
        this.tblFilialservicioPK = tblFilialservicioPK;
    }

    public TblFilialservicio(TblFilialservicioPK tblFilialservicioPK, Date fechacreacion, int estado) {
        this.tblFilialservicioPK = tblFilialservicioPK;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public TblFilialservicio(int idfilial, int idservicio) {
        this.tblFilialservicioPK = new TblFilialservicioPK(idfilial, idservicio);
    }

    public TblFilialservicioPK getTblFilialservicioPK() {
        return tblFilialservicioPK;
    }

    public void setTblFilialservicioPK(TblFilialservicioPK tblFilialservicioPK) {
        this.tblFilialservicioPK = tblFilialservicioPK;
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

    public TblFiliales getTblFiliales() {
        return tblFiliales;
    }

    public void setTblFiliales(TblFiliales tblFiliales) {
        this.tblFiliales = tblFiliales;
    }

    public TblServicios getTblServicios() {
        return tblServicios;
    }

    public void setTblServicios(TblServicios tblServicios) {
        this.tblServicios = tblServicios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblFilialservicioPK != null ? tblFilialservicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFilialservicio)) {
            return false;
        }
        TblFilialservicio other = (TblFilialservicio) object;
        if ((this.tblFilialservicioPK == null && other.tblFilialservicioPK != null) || (this.tblFilialservicioPK != null && !this.tblFilialservicioPK.equals(other.tblFilialservicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblFilialservicio[ tblFilialservicioPK=" + tblFilialservicioPK + " ]";
    }
    
}
