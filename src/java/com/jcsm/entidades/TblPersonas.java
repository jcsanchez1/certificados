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
import javax.persistence.OneToOne;
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
@Table(name = "tbl_personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPersonas.findAll", query = "SELECT t FROM TblPersonas t")
    , @NamedQuery(name = "TblPersonas.findById", query = "SELECT t FROM TblPersonas t WHERE t.id = :id")
    , @NamedQuery(name = "TblPersonas.findByIdafiliacion", query = "SELECT t FROM TblPersonas t WHERE t.idafiliacion = :idafiliacion")
    , @NamedQuery(name = "TblPersonas.findByNombre", query = "SELECT t FROM TblPersonas t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblPersonas.findByApellido", query = "SELECT t FROM TblPersonas t WHERE t.apellido = :apellido")
    , @NamedQuery(name = "TblPersonas.findByTelefono", query = "SELECT t FROM TblPersonas t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TblPersonas.findByEmail", query = "SELECT t FROM TblPersonas t WHERE t.email = :email")
    , @NamedQuery(name = "TblPersonas.findByPassword", query = "SELECT t FROM TblPersonas t WHERE t.password = :password")
    , @NamedQuery(name = "TblPersonas.findByTokenRecovery", query = "SELECT t FROM TblPersonas t WHERE t.tokenRecovery = :tokenRecovery")
    , @NamedQuery(name = "TblPersonas.findByFechacreacion", query = "SELECT t FROM TblPersonas t WHERE t.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "TblPersonas.findByFechamodificacion", query = "SELECT t FROM TblPersonas t WHERE t.fechamodificacion = :fechamodificacion")
    , @NamedQuery(name = "TblPersonas.findByEstado", query = "SELECT t FROM TblPersonas t WHERE t.estado = :estado")
    , @NamedQuery(name = "TblPersonas.findByFechanacimiento", query = "SELECT t FROM TblPersonas t WHERE t.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "TblPersonas.findByGenero", query = "SELECT t FROM TblPersonas t WHERE t.genero = :genero")
    , @NamedQuery(name = "TblPersonas.findByFoto", query = "SELECT t FROM TblPersonas t WHERE t.foto = :foto")})
public class TblPersonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idafiliacion")
    private long idafiliacion;
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
    @Column(name = "telefono")
    private int telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Size(max = 200)
    @Column(name = "token_recovery")
    private String tokenRecovery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.DATE)
    private Date fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Size(max = 1)
    @Column(name = "genero")
    private String genero;
    @Size(max = 255)
    @Column(name = "foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private List<TblTurnos> tblTurnosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private List<TblVotospersona> tblVotospersonaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblPersonas")
    private TblCondicionpersona tblCondicionpersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private List<TlbEmpleadopuesto> tlbEmpleadopuestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaid")
    private List<TblParticipantescursos> tblParticipantescursosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private List<TblAlertas> tblAlertasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblapersona")
    private List<TblAsistencia> tblAsistenciaList;
    @JoinColumn(name = "id_filial", referencedColumnName = "idfilial")
    @ManyToOne
    private TblFiliales idFilial;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private TblRoles idrol;

    public TblPersonas() {
    }

    public TblPersonas(Integer id) {
        this.id = id;
    }

    public TblPersonas(Integer id, long idafiliacion, String nombre, String apellido, int telefono, String email, String password, Date fechacreacion, int estado, Date fechanacimiento) {
        this.id = id;
        this.idafiliacion = idafiliacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
        this.fechanacimiento = fechanacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getIdafiliacion() {
        return idafiliacion;
    }

    public void setIdafiliacion(long idafiliacion) {
        this.idafiliacion = idafiliacion;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTokenRecovery() {
        return tokenRecovery;
    }

    public void setTokenRecovery(String tokenRecovery) {
        this.tokenRecovery = tokenRecovery;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public List<TblTurnos> getTblTurnosList() {
        return tblTurnosList;
    }

    public void setTblTurnosList(List<TblTurnos> tblTurnosList) {
        this.tblTurnosList = tblTurnosList;
    }

    @XmlTransient
    public List<TblVotospersona> getTblVotospersonaList() {
        return tblVotospersonaList;
    }

    public void setTblVotospersonaList(List<TblVotospersona> tblVotospersonaList) {
        this.tblVotospersonaList = tblVotospersonaList;
    }

    public TblCondicionpersona getTblCondicionpersona() {
        return tblCondicionpersona;
    }

    public void setTblCondicionpersona(TblCondicionpersona tblCondicionpersona) {
        this.tblCondicionpersona = tblCondicionpersona;
    }

    @XmlTransient
    public List<TlbEmpleadopuesto> getTlbEmpleadopuestoList() {
        return tlbEmpleadopuestoList;
    }

    public void setTlbEmpleadopuestoList(List<TlbEmpleadopuesto> tlbEmpleadopuestoList) {
        this.tlbEmpleadopuestoList = tlbEmpleadopuestoList;
    }

    @XmlTransient
    public List<TblParticipantescursos> getTblParticipantescursosList() {
        return tblParticipantescursosList;
    }

    public void setTblParticipantescursosList(List<TblParticipantescursos> tblParticipantescursosList) {
        this.tblParticipantescursosList = tblParticipantescursosList;
    }

    @XmlTransient
    public List<TblAlertas> getTblAlertasList() {
        return tblAlertasList;
    }

    public void setTblAlertasList(List<TblAlertas> tblAlertasList) {
        this.tblAlertasList = tblAlertasList;
    }

    @XmlTransient
    public List<TblAsistencia> getTblAsistenciaList() {
        return tblAsistenciaList;
    }

    public void setTblAsistenciaList(List<TblAsistencia> tblAsistenciaList) {
        this.tblAsistenciaList = tblAsistenciaList;
    }

    public TblFiliales getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(TblFiliales idFilial) {
        this.idFilial = idFilial;
    }

    public TblRoles getIdrol() {
        return idrol;
    }

    public void setIdrol(TblRoles idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPersonas)) {
            return false;
        }
        TblPersonas other = (TblPersonas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblPersonas[ id=" + id + " ]";
    }
    
}
