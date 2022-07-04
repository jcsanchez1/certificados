/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcsm.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "tbl_participantescursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblParticipantescursos.findAll", query = "SELECT t FROM TblParticipantescursos t")
    , @NamedQuery(name = "TblParticipantescursos.findByCurparid", query = "SELECT t FROM TblParticipantescursos t WHERE t.curparid = :curparid")
    , @NamedQuery(name = "TblParticipantescursos.findByFechacreacion", query = "SELECT t FROM TblParticipantescursos t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblParticipantescursos.findByEstado", query = "SELECT t FROM TblParticipantescursos t WHERE t.estado = :estado")})
public class TblParticipantescursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "curparid")
    private Integer curparid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "cursoid", referencedColumnName = "curid")
    @ManyToOne(optional = false)
    private TblCursos cursoid;
    @JoinColumn(name = "personaid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblPersonas personaid;
    @OneToMany(mappedBy = "curparid")
    private List<TblCertificaciones> tblCertificacionesList;

    public TblParticipantescursos() {
    }

    public TblParticipantescursos(Integer curparid) {
        this.curparid = curparid;
    }

    public TblParticipantescursos(Integer curparid, Date fechacreacion, int estado) {
        this.curparid = curparid;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getCurparid() {
        return curparid;
    }

    public void setCurparid(Integer curparid) {
        this.curparid = curparid;
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

    public TblCursos getCursoid() {
        return cursoid;
    }

    public void setCursoid(TblCursos cursoid) {
        this.cursoid = cursoid;
    }

    public TblPersonas getPersonaid() {
        return personaid;
    }

    public void setPersonaid(TblPersonas personaid) {
        this.personaid = personaid;
    }

    @XmlTransient
    public List<TblCertificaciones> getTblCertificacionesList() {
        return tblCertificacionesList;
    }

    public void setTblCertificacionesList(List<TblCertificaciones> tblCertificacionesList) {
        this.tblCertificacionesList = tblCertificacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curparid != null ? curparid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblParticipantescursos)) {
            return false;
        }
        TblParticipantescursos other = (TblParticipantescursos) object;
        if ((this.curparid == null && other.curparid != null) || (this.curparid != null && !this.curparid.equals(other.curparid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblParticipantescursos[ curparid=" + curparid + " ]";
    }
    
}
