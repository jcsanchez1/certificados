/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcsm.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author juanc
 */
@Embeddable
public class TblFilialservicioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idfilial")
    private int idfilial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idservicio")
    private int idservicio;

    public TblFilialservicioPK() {
    }

    public TblFilialservicioPK(int idfilial, int idservicio) {
        this.idfilial = idfilial;
        this.idservicio = idservicio;
    }

    public int getIdfilial() {
        return idfilial;
    }

    public void setIdfilial(int idfilial) {
        this.idfilial = idfilial;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idfilial;
        hash += (int) idservicio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFilialservicioPK)) {
            return false;
        }
        TblFilialservicioPK other = (TblFilialservicioPK) object;
        if (this.idfilial != other.idfilial) {
            return false;
        }
        if (this.idservicio != other.idservicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcsm.entidades.TblFilialservicioPK[ idfilial=" + idfilial + ", idservicio=" + idservicio + " ]";
    }
    
}
