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
@Table(name = "tbl_cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCursos.findAll", query = "SELECT t FROM TblCursos t")
    , @NamedQuery(name = "TblCursos.findByCurid", query = "SELECT t FROM TblCursos t WHERE t.curid = :curid")
    , @NamedQuery(name = "TblCursos.findByNombrecurso", query = "SELECT t FROM TblCursos t WHERE t.nombrecurso = :nombrecurso")
    , @NamedQuery(name = "TblCursos.findByFechainicio", query = "SELECT t FROM TblCursos t WHERE t.fechainicio = :fechainicio")
    , @NamedQuery(name = "TblCursos.findByFechafinal", query = "SELECT t FROM TblCursos t WHERE t.fechafinal = :fechafinal")
    , @NamedQuery(name = "TblCursos.findByFechacreacion", query = "SELECT t FROM TblCursos t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblCursos.findByEstado", query = "SELECT t FROM TblCursos t WHERE t.estado = :estado")
    , @NamedQuery(name = "TblCursos.findByDescripcion", query = "SELECT t FROM TblCursos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TblCursos.findByImagen", query = "SELECT t FROM TblCursos t WHERE t.imagen = :imagen")
    , @NamedQuery(name = "TblCursos.findByDependenciaid", query = "SELECT t FROM TblCursos t WHERE t.dependenciaid = :dependenciaid")
    , @NamedQuery(name = "TblCursos.findByUrl", query = "SELECT t FROM TblCursos t WHERE t.url = :url")})
public class TblCursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "curid")
    private Integer curid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombrecurso")
    private int nombrecurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafinal")
    @Temporal(TemporalType.DATE)
    private Date fechafinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "dependenciaid")
    private Integer dependenciaid;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "instid", referencedColumnName = "instid")
    @ManyToOne(optional = false)
    private TblInstructores instid;
    @JoinColumn(name = "categoriaid", referencedColumnName = "catid")
    @ManyToOne
    private TblCategoriacursos categoriaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursoid")
    private List<TblParticipantescursos> tblParticipantescursosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private List<TblCertificaciones> tblCertificacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblcurso")
    private List<TblAsistencia> tblAsistenciaList;

    public TblCursos() {
    }

    public TblCursos(Integer curid) {
        this.curid = curid;
    }

    public TblCursos(Integer curid, int nombrecurso, Date fechainicio, Date fechafinal, Date fechacreacion, int estado) {
        this.curid = curid;
        this.nombrecurso = nombrecurso;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public Integer getCurid() {
        return curid;
    }

    public void setCurid(Integer curid) {
        this.curid = curid;
    }

    public int getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(int nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getDependenciaid() {
        return dependenciaid;
    }

    public void setDependenciaid(Integer dependenciaid) {
        this.dependenciaid = dependenciaid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TblInstructores getInstid() {
        return instid;
    }

    public void setInstid(TblInstructores instid) {
        this.instid = instid;
    }

    public TblCategoriacursos getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(TblCategoriacursos categoriaid) {
        this.categoriaid = categoriaid;
    }

    @XmlTransient
    public List<TblParticipantescursos> getTblParticipantescursosList() {
        return tblParticipantescursosList;
    }

    public void setTblParticipantescursosList(List<TblParticipantescursos> tblParticipantescursosList) {
        this.tblParticipantescursosList = tblParticipantescursosList;
    }

    @XmlTransient
    public List<TblCertificaciones> getTblCertificacionesList() {
        return tblCertificacionesList;
    }

    public void setTblCertificacionesList(List<TblCertificaciones> tblCertificacionesList) {
        this.tblCertificacionesList = tblCertificacionesList;
    }

    @XmlTransient
    public List<TblAsistencia> getTblAsistenciaList() {
        return tblAsistenciaList;
    }

    public void setTblAsistenciaList(List<TblAsistencia> tblAsistenciaList) {
        this.tblAsistenciaList = tblAsistenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curid != null ? curid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCursos)) {
            return false;
        }
        TblCursos other = (TblCursos) object;
        if ((this.curid == null && other.curid != null) || (this.curid != null && !this.curid.equals(other.curid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblCursos[ curid=" + curid + " ]";
    }
    
}
