
package com.mycompany.seminario.controllers;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.models.MarcaAutomotorModel;
import java.util.List;

/**
 *
 * @author Sofi
 */
public class MarcaAutoController {
    
    
    public static List<MarcaAutomotorModel> getMarcasAutos(){
        return DaoFactory.getDaoObject("marca").getAll();
    }
    
}
