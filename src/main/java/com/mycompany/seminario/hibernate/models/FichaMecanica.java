/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seminario.hibernate.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Sofi
 */
@Entity
@Table(name = "ficha_mecanica")
@NamedQueries({
    @NamedQuery(name = "FichaMecanica.findAll", query = "SELECT f FROM FichaMecanica f"),
    @NamedQuery(name = "FichaMecanica.findById", query = "SELECT f FROM FichaMecanica f WHERE f.id = :id"),
    @NamedQuery(name = "FichaMecanica.findByCostoManoObra", query = "SELECT f FROM FichaMecanica f WHERE f.costoManoObra = :costoManoObra"),
    @NamedQuery(name = "FichaMecanica.findByDetalleTrabajo", query = "SELECT f FROM FichaMecanica f WHERE f.detalleTrabajo = :detalleTrabajo"),
    @NamedQuery(name = "FichaMecanica.findByConformidadCliente", query = "SELECT f FROM FichaMecanica f WHERE f.conformidadCliente = :conformidadCliente"),
    @NamedQuery(name = "FichaMecanica.findByDescargo", query = "SELECT f FROM FichaMecanica f WHERE f.descargo = :descargo"),
    @NamedQuery(name = "FichaMecanica.findByTiempoEmpleado", query = "SELECT f FROM FichaMecanica f WHERE f.tiempoEmpleado = :tiempoEmpleado")})
public class FichaMecanica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_mano_obra")
    private BigDecimal costoManoObra;
    @Column(name = "detalle_trabajo")
    private String detalleTrabajo;
    @Column(name = "conformidad_cliente")
    private Boolean conformidadCliente;
    @Column(name = "descargo")
    private String descargo;
    @Column(name = "tiempo_empleado")
    private Short tiempoEmpleado;
    @JoinColumn(name = "automotor", referencedColumnName = "id")
    @ManyToOne
    private Automotor automotor;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente cliente;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Turno turno;
    @JoinColumn(name = "mecanico", referencedColumnName = "id")
    @ManyToOne
    private Empleado mecanico;

    public FichaMecanica() {
    }

    public FichaMecanica(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCostoManoObra() {
        return costoManoObra;
    }

    public void setCostoManoObra(BigDecimal costoManoObra) {
        this.costoManoObra = costoManoObra;
    }

    public String getDetalleTrabajo() {
        return detalleTrabajo;
    }

    public void setDetalleTrabajo(String detalleTrabajo) {
        this.detalleTrabajo = detalleTrabajo;
    }

    public Boolean getConformidadCliente() {
        return conformidadCliente;
    }

    public void setConformidadCliente(Boolean conformidadCliente) {
        this.conformidadCliente = conformidadCliente;
    }

    public String getDescargo() {
        return descargo;
    }

    public void setDescargo(String descargo) {
        this.descargo = descargo;
    }

    public Short getTiempoEmpleado() {
        return tiempoEmpleado;
    }

    public void setTiempoEmpleado(Short tiempoEmpleado) {
        this.tiempoEmpleado = tiempoEmpleado;
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

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Empleado getMecanico() {
        return mecanico;
    }

    public void setMecanico(Empleado mecanico) {
        this.mecanico = mecanico;
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
        if (!(object instanceof FichaMecanica)) {
            return false;
        }
        FichaMecanica other = (FichaMecanica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.seminario.hibernate.models.FichaMecanica[ id=" + id + " ]";
    }
    
}
