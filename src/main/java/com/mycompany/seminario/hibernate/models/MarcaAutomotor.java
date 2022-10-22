/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seminario.hibernate.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sofi
 */
@Entity
@Table(name = "marca_automotor")
@NamedQueries({
    @NamedQuery(name = "MarcaAutomotor.findAll", query = "SELECT m FROM MarcaAutomotor m"),
    @NamedQuery(name = "MarcaAutomotor.findById", query = "SELECT m FROM MarcaAutomotor m WHERE m.id = :id"),
    @NamedQuery(name = "MarcaAutomotor.findByMarca", query = "SELECT m FROM MarcaAutomotor m WHERE m.marca = :marca")})
public class MarcaAutomotor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "marca")
    private String marca;
    @OneToMany(mappedBy = "marca")
    private List<Automotor> automotorList;
    @OneToMany(mappedBy = "marca")
    private List<ModeloAutomotor> modeloAutomotorList;

    public MarcaAutomotor() {
    }

    public MarcaAutomotor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Automotor> getAutomotorList() {
        return automotorList;
    }

    public void setAutomotorList(List<Automotor> automotorList) {
        this.automotorList = automotorList;
    }

    public List<ModeloAutomotor> getModeloAutomotorList() {
        return modeloAutomotorList;
    }

    public void setModeloAutomotorList(List<ModeloAutomotor> modeloAutomotorList) {
        this.modeloAutomotorList = modeloAutomotorList;
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
        if (!(object instanceof MarcaAutomotor)) {
            return false;
        }
        MarcaAutomotor other = (MarcaAutomotor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.seminario.hibernate.models.MarcaAutomotor[ id=" + id + " ]";
    }
    
}
