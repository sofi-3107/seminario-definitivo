/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seminario.hibernate.models;

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

/**
 *
 * @author Sofi
 */
@Entity
@Table(name = "modelo_automotor")
@NamedQueries({
    @NamedQuery(name = "ModeloAutomotor.findAll", query = "SELECT m FROM ModeloAutomotor m"),
    @NamedQuery(name = "ModeloAutomotor.findById", query = "SELECT m FROM ModeloAutomotor m WHERE m.id = :id"),
    @NamedQuery(name = "ModeloAutomotor.findByModelo", query = "SELECT m FROM ModeloAutomotor m WHERE m.modelo = :modelo"),
    @NamedQuery(name = "ModeloAutomotor.findByAnio", query = "SELECT m FROM ModeloAutomotor m WHERE m.anio = :anio")})
public class ModeloAutomotor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "anio")
    @Temporal(TemporalType.DATE)
    private Date anio;
    @OneToMany(mappedBy = "modelo")
    private List<Automotor> automotorList;
    @JoinColumn(name = "marca", referencedColumnName = "id")
    @ManyToOne
    private MarcaAutomotor marca;

    public ModeloAutomotor() {
    }

    public ModeloAutomotor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public List<Automotor> getAutomotorList() {
        return automotorList;
    }

    public void setAutomotorList(List<Automotor> automotorList) {
        this.automotorList = automotorList;
    }

    public MarcaAutomotor getMarca() {
        return marca;
    }

    public void setMarca(MarcaAutomotor marca) {
        this.marca = marca;
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
        if (!(object instanceof ModeloAutomotor)) {
            return false;
        }
        ModeloAutomotor other = (ModeloAutomotor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.seminario.hibernate.models.ModeloAutomotor[ id=" + id + " ]";
    }
    
}
