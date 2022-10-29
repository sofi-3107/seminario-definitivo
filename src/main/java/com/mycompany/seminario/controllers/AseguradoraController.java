package com.mycompany.seminario.controllers;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.hibernate.models.Aseguradora;
import com.mycompany.seminario.hibernatedao.entityinterfaces.AseguradoraDaoHibernate;
import com.mycompany.seminario.models.AseguradoraModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofi
 */
public class AseguradoraController {

    private static AseguradoraDaoHibernate adh = (AseguradoraDaoHibernate) DaoFactory.getHibernateDao("aseguradora");

    /* public static List<AseguradoraModel>getAllAseguradoras(){
        return DaoFactory.getDaoObject("aseguradora").getAll();
    }*/
    public static List<AseguradoraModel> getAllAseguradoras() {
        List< AseguradoraModel> aseguradoras = new ArrayList();
       
        try {
             List<Aseguradora> asegHibernate = adh.findAll();
            asegHibernate.stream().forEach(as -> {
                AseguradoraModel am=new AseguradoraModel();
                am.setNombre(as.getNombre());
                am.setId(as.getId());
                aseguradoras.add(am);
            });

        } catch (Exception ex) {
            Logger.getLogger(AseguradoraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aseguradoras;
    }

}
