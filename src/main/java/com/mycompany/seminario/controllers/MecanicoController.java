
package com.mycompany.seminario.controllers;

import com.mycompany.seminario.daoimpl.MecanicoDaoImpl;
import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.models.MecanicoModel;

/**
 *
 * @author Sofi
 */
public class MecanicoController {
    
    
    public static MecanicoModel getMecanicoPorEspecialidad(int idEspecialidad){
        MecanicoDaoImpl m=(MecanicoDaoImpl) DaoFactory.getDaoObject("mecanico");
        return m.getMecanicoByTaller(idEspecialidad);
    }
    
}
