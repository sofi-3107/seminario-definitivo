
package com.mycompany.seminario.controllers;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.models.ModeloAutomotorModel;
import java.util.List;

/**
 *
 * @author Sofi
 */
public class ModeloAutoController {
    
    public static List<ModeloAutomotorModel> getModelosAutos(){
        return DaoFactory.getDaoObject("modelo").getAll();
    }
}
