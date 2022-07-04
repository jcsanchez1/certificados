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
@Table(name = "tbl_filiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFiliales.findAll", query = "SELECT t FROM TblFiliales t")
    , @NamedQuery(name = "TblFiliales.findByIdfilial", query = "SELECT t FROM TblFiliales t WHERE t.idfilial = :idfilial")
    , @NamedQuery(name = "TblFiliales.findByNombrefilial", query = "SELECT t FROM TblFiliales t WHERE t.nombrefilial = :nombrefilial")
    , @NamedQuery(name = "TblFiliales.findByDireccion", query = "SELECT t FROM TblFiliales t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "TblFiliales.findByLatitud", query = "SELECT t FROM TblFiliales t WHERE t.latitud = :latitud")
    , @NamedQuery(name = "TblFiliales.findByLongitud", query = "SELECT t FROM TblFiliales t WHERE t.longitud = :longitud")
    , @NamedQuery(name = "TblFiliales.findByTelefono", query = "SELECT t FROM TblFiliales t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TblFiliales.findByCorreo", query = "SELECT t FROM TblFiliales t WHERE t.correo = :correo")
    , @NamedQuery(name = "TblFiliales.findByHorariosemana", query = "SELECT t FROM TblFiliales t WHERE t.horariosemana = :horariosemana")
    , @NamedQuery(name = "TblFiliales.findByHorariofinsemana", query = "SELECT t FROM TblFiliales t WHERE t.horariofinsemana = :horariofinsemana")})
public class TblFiliales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfilial")
    private Integer idfilial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrefilial")
    private String nombrefilial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud")
    private float latitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private float longitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @Size(max = 255)
    @Column(name = "horariosemana")
    private String horariosemana;
    @Size(max = 255)
    @Column(name = "horariofinsemana")
    private String horariofinsemana;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfilial")
    private List<TblTurnos> tblTurnosList;
    @JoinColumn(name = "idmunicipio", referencedColumnName = "idtbl_municipios")
    @ManyToOne(optional = false)
    private TblMunicipios idmunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblFiliales")
    private List<TblFilialservicio> tblFilialservicioList;
    @OneToMany(mappedBy = "idFilial")
    private List<TblPersonas> tblPersonasList;

    public TblFiliales() {
    }

    public TblFiliales(Integer idfilial) {
        this.idfilial = idfilial;
    }

    public TblFiliales(Integer idfilial, String nombrefilial, String direccion, float latitud, float longitud, String telefono, String correo) {
        this.idfilial = idfilial;
        this.nombrefilial = nombrefilial;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Integer getIdfilial() {
        return idfilial;
    }

    public void setIdfilial(Integer idfilial) {
        this.idfilial = idfilial;
    }

    public String getNombrefilial() {
        return nombrefilial;
    }

    public void setNombrefilial(String nombrefilial) {
        this.nombrefilial = nombrefilial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHorariosemana() {
        return horariosemana;
    }

    public void setHorariosemana(String horariosemana) {
        this.horariosemana = horariosemana;
    }

    public String getHorariofinsemana() {
        return horariofinsemana;
    }

    public void setHorariofinsemana(String horariofinsemana) {
        this.horariofinsemana = horariofinsemana;
    }

    @XmlTransient
    public List<TblTurnos> getTblTurnosList() {
        return tblTurnosList;
    }

    public void setTblTurnosList(List<TblTurnos> tblTurnosList) {
        this.tblTurnosList = tblTurnosList;
    }

    public TblMunicipios getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(TblMunicipios idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    @XmlTransient
    public List<TblFilialservicio> getTblFilialservicioList() {
        return tblFilialservicioList;
    }

    public void setTblFilialservicioList(List<TblFilialservicio> tblFilialservicioList) {
        this.tblFilialservicioList = tblFilialservicioList;
    }

    @XmlTransient
    public List<TblPersonas> getTblPersonasList() {
        return tblPersonasList;
    }

    public void setTblPersonasList(List<TblPersonas> tblPersonasList) {
        this.tblPersonasList = tblPersonasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfilial != null ? idfilial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFiliales)) {
            return false;
        }
        TblFiliales other = (TblFiliales) object;
        if ((this.idfilial == null && other.idfilial != null) || (this.idfilial != null && !this.idfilial.equals(other.idfilial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblFiliales[ idfilial=" + idfilial + " ]";
    }
    
}
