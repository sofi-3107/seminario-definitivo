
package com.mycompany.seminario.controllers;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.hibernate.models.MarcaAutomotor;
import com.mycompany.seminario.hibernatedao.implementations.MarcaAutomotorDaoImplHibernate;
import com.mycompany.seminario.models.MarcaAutomotorModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofi
 */
public class MarcaAutoController {
    
    private static MarcaAutomotorDaoImplHibernate marcaDaoH= (MarcaAutomotorDaoImplHibernate) DaoFactory.getHibernateDao("marcaautomotor");
    
    /*public static List<MarcaAutomotorModel> getMarcasAutos(){
        return DaoFactory.getDaoObject("marca").getAll();
    }*/
    
    public static List<MarcaAutomotorModel> getMarcasAutos(){
        List<MarcaAutomotorModel>marcas= new ArrayList();
        try {
            
            List<MarcaAutomotor>marcasH=marcaDaoH.findAll();
            marcasH.stream().forEach(ma->{
                MarcaAutomotorModel marca=new MarcaAutomotorModel();
                marca.setId(ma.getId());
                marca.setMarca(ma.getMarca());
                marcas.add(marca);
            
            });
        } catch (Exception ex) {
            Logger.getLogger(MarcaAutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return marcas;
    }
}
