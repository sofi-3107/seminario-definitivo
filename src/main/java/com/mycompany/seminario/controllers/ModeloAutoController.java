package com.mycompany.seminario.controllers;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.hibernate.models.ModeloAutomotor;
import com.mycompany.seminario.hibernatedao.entityinterfaces.ModeloAutomotorDaoHibernate;
import com.mycompany.seminario.models.ModeloAutomotorModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofi
 */
public class ModeloAutoController {

    private static ModeloAutomotorDaoHibernate modeloDaoH = (ModeloAutomotorDaoHibernate) DaoFactory.getHibernateDao("modeloautomotor");

    /* public static List<ModeloAutomotorModel> getModelosAutos(){
        return DaoFactory.getDaoObject("modelo").getAll();
    }*/
    public static List<ModeloAutomotorModel> getModelosAutos() {
        List<ModeloAutomotorModel> modelosAutos = new ArrayList();
        try {

            List<ModeloAutomotor> modelos = modeloDaoH.findAll();
            modelos.stream().forEach(m -> {
                ModeloAutomotorModel mo = new ModeloAutomotorModel();
                mo.setAnio(m.getAnio().getYear()+1900);
                mo.setMarca(m.getMarca().getMarca());
                mo.setModelo(m.getModelo());
                mo.setId(m.getId());

                modelosAutos.add(mo);
            });

        } catch (Exception ex) {
            Logger.getLogger(ModeloAutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelosAutos;
    }
}
