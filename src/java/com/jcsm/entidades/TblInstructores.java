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
@Table(name = "tbl_instructores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblInstructores.findAll", query = "SELECT t FROM TblInstructores t")
    , @NamedQuery(name = "TblInstructores.findByInstid", query = "SELECT t FROM TblInstructores t WHERE t.instid = :instid")
    , @NamedQuery(name = "TblInstructores.findByNombre", query = "SELECT t FROM TblInstructores t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblInstructores.findByApellido", query = "SELECT t FROM TblInstructores t WHERE t.apellido = :apellido")
    , @NamedQuery(name = "TblInstructores.findByCorreo", query = "SELECT t FROM TblInstructores t WHERE t.correo = :correo")
    , @NamedQuery(name = "TblInstructores.findByGenero", query = "SELECT t FROM TblInstructores t WHERE t.genero = :genero")
    , @NamedQuery(name = "TblInstructores.findByTelefono", query = "SELECT t FROM TblInstructores t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TblInstructores.findByFechanacimiento", query = "SELECT t FROM TblInstructores t WHERE t.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "TblInstructores.findByFechacreacion", query = "SELECT t FROM TblInstructores t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblInstructores.findByEstado", query = "SELECT t FROM TblInstructores t WHERE t.estado = :estado")
    , @NamedQuery(name = "TblInstructores.findByIdentidad", query = "SELECT t FROM TblInstructores t WHERE t.identidad = :identidad")})
public class TblInstructores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "instid")
    private Integer instid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
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
    @Size(min = 1, max = 15)
    @Column(name = "identidad")
    private String identidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instid")
    private List<TblCursos> tblCursosList;

    public TblInstructores() {
    }

    public TblInstructores(Integer instid) {
        this.instid = instid;
    }

    public TblInstructores(Integer instid, String nombre, String apellido, String correo, String genero, String telefono, Date fechanacimiento, Date fechacreacion, int estado, String identidad) {
        this.instid = instid;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.genero = genero;
        this.telefono = telefono;
        this.fechanacimiento = fechanacimiento;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
        this.identidad = identidad;
    }

    public Integer getInstid() {
        return instid;
    }

    public void setInstid(Integer instid) {
        this.instid = instid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
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

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    @XmlTransient
    public List<TblCursos> getTblCursosList() {
        return tblCursosList;
    }

    public void setTblCursosList(List<TblCursos> tblCursosList) {
        this.tblCursosList = tblCursosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instid != null ? instid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblInstructores)) {
            return false;
        }
        TblInstructores other = (TblInstructores) object;
        if ((this.instid == null && other.instid != null) || (this.instid != null && !this.instid.equals(other.instid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblInstructores[ instid=" + instid + " ]";
    }
    
}
