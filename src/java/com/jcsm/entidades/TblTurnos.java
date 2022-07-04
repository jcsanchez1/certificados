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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "tbl_turnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTurnos.findAll", query = "SELECT t FROM TblTurnos t")
    , @NamedQuery(name = "TblTurnos.findByIdturno", query = "SELECT t FROM TblTurnos t WHERE t.idturno = :idturno")
    , @NamedQuery(name = "TblTurnos.findByCorrelativoturno", query = "SELECT t FROM TblTurnos t WHERE t.correlativoturno = :correlativoturno")
    , @NamedQuery(name = "TblTurnos.findByFechacreacion", query = "SELECT t FROM TblTurnos t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblTurnos.findByEstado", query = "SELECT t FROM TblTurnos t WHERE t.estado = :estado")
    , @NamedQuery(name = "TblTurnos.findByTipo", query = "SELECT t FROM TblTurnos t WHERE t.tipo = :tipo")})
public class TblTurnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idturno")
    private Integer idturno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correlativoturno")
    private int correlativoturno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "idfilial", referencedColumnName = "idfilial")
    @ManyToOne(optional = false)
    private TblFiliales idfilial;
    @JoinColumn(name = "idpersona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblPersonas idpersona;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicios")
    @ManyToOne(optional = false)
    private TblServicios idservicio;
    @JoinColumn(name = "idsubservicio", referencedColumnName = "idsubservicio")
    @ManyToOne(optional = false)
    private TblSubservicios idsubservicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idturno")
    private List<TblAsignacionturno> tblAsignacionturnoList;

    public TblTurnos() {
    }

    public TblTurnos(Integer idturno) {
        this.idturno = idturno;
    }

    public TblTurnos(Integer idturno, int correlativoturno, Date fechacreacion, int estado, String tipo) {
        this.idturno = idturno;
        this.correlativoturno = correlativoturno;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Integer getIdturno() {
        return idturno;
    }

    public void setIdturno(Integer idturno) {
        this.idturno = idturno;
    }

    public int getCorrelativoturno() {
        return correlativoturno;
    }

    public void setCorrelativoturno(int correlativoturno) {
        this.correlativoturno = correlativoturno;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TblFiliales getIdfilial() {
        return idfilial;
    }

    public void setIdfilial(TblFiliales idfilial) {
        this.idfilial = idfilial;
    }

    public TblPersonas getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(TblPersonas idpersona) {
        this.idpersona = idpersona;
    }

    public TblServicios getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(TblServicios idservicio) {
        this.idservicio = idservicio;
    }

    public TblSubservicios getIdsubservicio() {
        return idsubservicio;
    }

    public void setIdsubservicio(TblSubservicios idsubservicio) {
        this.idsubservicio = idsubservicio;
    }

    @XmlTransient
    public List<TblAsignacionturno> getTblAsignacionturnoList() {
        return tblAsignacionturnoList;
    }

    public void setTblAsignacionturnoList(List<TblAsignacionturno> tblAsignacionturnoList) {
        this.tblAsignacionturnoList = tblAsignacionturnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idturno != null ? idturno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTurnos)) {
            return false;
        }
        TblTurnos other = (TblTurnos) object;
        if ((this.idturno == null && other.idturno != null) || (this.idturno != null && !this.idturno.equals(other.idturno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblTurnos[ idturno=" + idturno + " ]";
    }
    
}
