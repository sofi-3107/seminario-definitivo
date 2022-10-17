
package com.mycompany.seminario.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Educacion
 */

@Getter @Setter @NoArgsConstructor
public class InsumoModel {
    
    private int id;
    
    private String nombre;
    
    private double costoUnitario;
    
}
