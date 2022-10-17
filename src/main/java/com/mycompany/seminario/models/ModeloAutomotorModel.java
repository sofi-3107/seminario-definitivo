
package com.mycompany.seminario.models;



/**
 *
 * @author Sofi
 */

public class ModeloAutomotorModel {
    
    private int id;
    
    private String marca;
    
    private String modelo;
    
    private int anio;
    

    @Override
    public String toString() {
        return modelo+","+anio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    
    
    
}
