package com.mycompany.seminario.controllers;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.hibernate.models.Automotor;
import com.mycompany.seminario.hibernatedao.entityinterfaces.AutomotorDaoHibernate;
import com.mycompany.seminario.models.AutomotorModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sofi
 */
public class AutomotorController {
    
    private static AutomotorDaoHibernate adh= (AutomotorDaoHibernate) DaoFactory.getHibernateDao("automotor");

   /* public static List<AutomotorModel> buscarPorDueño(int idDueño) {
        AutomotorDaoImpl au = (AutomotorDaoImpl) DaoFactory.getDaoObject("automotor");

        return au.findByOwnerId(idDueño);
    }*/
    
    public static List<AutomotorModel>buscarPorDueño(int idDuenio){
        List<AutomotorModel>autos=new ArrayList();
        List<Automotor>amh=adh.findByOwner(idDuenio);
        amh.stream().forEach(ah->{
            AutomotorModel am=new AutomotorModel();
            am.setAnio(Integer.parseInt(ah.getModelo().getAnio().toString()));
            am.setModelo(ah.getModelo().getModelo());
            am.setAseguradora(ah.getAseguradora().getNombre());
            am.setMarca(ah.getMarca().getMarca());
            autos.add(am);
        });
        return autos;
    }

}
