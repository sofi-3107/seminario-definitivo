
package com.mycompany.seminario.hibernate.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sofi
 */
@Entity
@Table(name = "automotor")
@NamedQueries({
    @NamedQuery(name = "Automotor.findAll", query = "SELECT a FROM Automotor a"),
    @NamedQuery(name = "Automotor.findById", query = "SELECT a FROM Automotor a WHERE a.id = :id"),
    @NamedQuery(name="Automotor.findByOwner",query="SELECT a FROM Automotor AS a WHERE a.dueño=: dueño"),
    @NamedQuery(name = "Automotor.findByNumeroPoliza", query = "SELECT a FROM Automotor a WHERE a.numeroPoliza = :numeroPoliza")})
public class Automotor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "numero_poliza")
    private String numeroPoliza;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "automotor")
    private List<Turno> turnoList;
    
    @JoinColumn(name = "aseguradora", referencedColumnName = "id")
    @ManyToOne
    private Aseguradora aseguradora;
    
    @JoinColumn(name = "dueño", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente dueño;
    
    @JoinColumn(name = "marca", referencedColumnName = "id")
    @ManyToOne
    private MarcaAutomotor marca;
    
    @JoinColumn(name = "modelo", referencedColumnName = "id")
    @ManyToOne
    private ModeloAutomotor modelo;
    
    @OneToMany(mappedBy = "automotor")
    private List<FichaMecanica> fichaMecanicaList;

    public Automotor() {
    }

    public Automotor(Integer id) {
        this.id = id;
    }

    public Automotor(Integer id, String numeroPoliza) {
        this.id = id;
        this.numeroPoliza = numeroPoliza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public List<Turno> getTurnoList() {
        return turnoList;
    }

    public void setTurnoList(List<Turno> turnoList) {
        this.turnoList = turnoList;
    }

    public Aseguradora getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(Aseguradora aseguradora) {
        this.aseguradora = aseguradora;
    }

    public Cliente getDueño() {
        return dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public MarcaAutomotor getMarca() {
        return marca;
    }

    public void setMarca(MarcaAutomotor marca) {
        this.marca = marca;
    }

    public ModeloAutomotor getModelo() {
        return modelo;
    }

    public void setModelo(ModeloAutomotor modelo) {
        this.modelo = modelo;
    }

    public List<FichaMecanica> getFichaMecanicaList() {
        return fichaMecanicaList;
    }

    public void setFichaMecanicaList(List<FichaMecanica> fichaMecanicaList) {
        this.fichaMecanicaList = fichaMecanicaList;
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
        if (!(object instanceof Automotor)) {
            return false;
        }
        Automotor other = (Automotor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.seminario.hibernate.models.Automotor[ id=" + id + " ]";
    }
    
}
