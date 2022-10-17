
package com.mycompany.seminario.models;




/**
 *
 * @author Sofi
 */


public class AutomotorModel {
    
    private int id;
    
    private String marca;
    
    
    private String modelo;
    
    
    private int anio;
    
    private String poliza;
    
    private String aseguradora;
    
    private int idAseguradora;
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public int getIdAseguradora() {
        return idAseguradora;
    }

    public void setIdAseguradora(int idAseguradora) {
        this.idAseguradora = idAseguradora;
    }
    
    

    @Override
    public String toString() {
        return marca+","+modelo+","+anio;
    }
    
    
    
}
