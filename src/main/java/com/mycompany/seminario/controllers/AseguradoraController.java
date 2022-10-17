
package com.mycompany.seminario.controllers;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.models.AseguradoraModel;
import java.util.List;


/**
 *
 * @author Sofi
 */
public class AseguradoraController {
    
    
    public static List<AseguradoraModel>getAllAseguradoras(){
        return DaoFactory.getDaoObject("aseguradora").getAll();
    }
  
    
}
