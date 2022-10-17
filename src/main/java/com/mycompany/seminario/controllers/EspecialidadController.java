
package com.mycompany.seminario.controllers;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.models.EspecialidadModel;
import java.util.List;

/**
 *
 * @author Sofi
 */
public class EspecialidadController {
    
    
    public static List<EspecialidadModel> getEspecialidadesMecanicas(){
        return DaoFactory.getDaoObject("especialidad").getAll();
    }
    
}
