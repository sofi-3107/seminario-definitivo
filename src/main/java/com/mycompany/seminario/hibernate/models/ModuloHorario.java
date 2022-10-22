/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seminario.hibernate.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sofi
 */
@Entity
@Table(name = "modulo_horario")
@NamedQueries({
    @NamedQuery(name = "ModuloHorario.findAll", query = "SELECT m FROM ModuloHorario m"),
    @NamedQuery(name = "ModuloHorario.findById", query = "SELECT m FROM ModuloHorario m WHERE m.id = :id"),
    @NamedQuery(name = "ModuloHorario.findByRangoHorario", query = "SELECT m FROM ModuloHorario m WHERE m.rangoHorario = :rangoHorario")})
public class ModuloHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "rango_horario")
    private String rangoHorario;

    public ModuloHorario() {
    }

    public ModuloHorario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRangoHorario() {
        return rangoHorario;
    }

    public void setRangoHorario(String rangoHorario) {
        this.rangoHorario = rangoHorario;
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
        if (!(object instanceof ModuloHorario)) {
            return false;
        }
        ModuloHorario other = (ModuloHorario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.seminario.hibernate.models.ModuloHorario[ id=" + id + " ]";
    }
    
}
