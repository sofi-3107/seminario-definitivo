/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seminario.hibernate.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sofi
 */
@Entity
@Table(name = "turno")
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t"),
    @NamedQuery(name = "Turno.findById", query = "SELECT t FROM Turno t WHERE t.id = :id"),
    @NamedQuery(name = "Turno.findByFecha", query = "SELECT t FROM Turno t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Turno.findByAsistencia", query = "SELECT t FROM Turno t WHERE t.asistencia = :asistencia")})
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "asistencia")
    private Boolean asistencia;
    @JoinColumn(name = "horario", referencedColumnName = "id")
    @ManyToOne
    private Horario horario;
    @JoinColumn(name = "mecanico", referencedColumnName = "id")
    @ManyToOne
    private Empleado mecanico;
    @JoinColumn(name = "automotor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Automotor automotor;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente cliente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "turno")
    private FichaMecanica fichaMecanica;

    public Turno() {
    }

    public Turno(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Empleado getMecanico() {
        return mecanico;
    }

    public void setMecanico(Empleado mecanico) {
        this.mecanico = mecanico;
    }

    public Automotor getAutomotor() {
        return automotor;
    }

    public void setAutomotor(Automotor automotor) {
        this.automotor = automotor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FichaMecanica getFichaMecanica() {
        return fichaMecanica;
    }

    public void setFichaMecanica(FichaMecanica fichaMecanica) {
        this.fichaMecanica = fichaMecanica;
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
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.seminario.hibernate.models.Turno[ id=" + id + " ]";
    }
    
}
