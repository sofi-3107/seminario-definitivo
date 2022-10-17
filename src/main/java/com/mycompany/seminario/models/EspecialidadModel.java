
package com.mycompany.seminario.models;

/**
 *
 * @author Sofi
 */
public class EspecialidadModel {
    
    private int id;
    
    private String nombreEspecialidad;
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

 
    @Override
    public String toString() {
        return nombreEspecialidad;
    }
    
    
    
    
    
}
