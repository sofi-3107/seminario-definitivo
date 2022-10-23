
package com.mycompany.seminario.hibernate.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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

/**
 *
 * @author Sofi
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
    @NamedQuery(name = "Cliente.findByTipoAndNumDoc", query = "SELECT c FROM Cliente AS c WHERE c.tipoDocumento =: tipo AND c.numDocumento =: numero"),
    @NamedQuery(name = "Cliente.findByNumDocumento", query = "SELECT c FROM Cliente c WHERE c.numDocumento = :numDocumento")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "num_documento")
    private String numDocumento;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Contacto contacto;
    
    @OneToMany(mappedBy = "cliente")
    private List<Turno> turnos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "due\u00f1o")
    private List<Automotor> automotorList;
    
    @JoinColumn(name = "tipo_documento", referencedColumnName = "id")
    @ManyToOne
    private TipoDocumento tipoDocumento;
    
    @OneToMany(mappedBy = "cliente")
    private List<FichaMecanica> fichaMecanicaList;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public List<Automotor> getAutomotorList() {
        return automotorList;
    }

    public void setAutomotorList(List<Automotor> automotorList) {
        this.automotorList = automotorList;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<FichaMecanica> getFichaMecanicaList() {
        return fichaMecanicaList;
    }

    public void setFichaMecanicaList(List<FichaMecanica> fichaMecanicaList) {
        this.fichaMecanicaList = fichaMecanicaList;
    }

   @Override
    public int hashCode() {
        
        return Objects.hash(this.numDocumento);
    }

    @Override
    public boolean equals(Object object) {
      
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.seminario.hibernate.models.Cliente[ id=" + id + " ]";
    }
    
}
