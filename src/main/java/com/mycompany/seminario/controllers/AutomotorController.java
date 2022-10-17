package com.mycompany.seminario.controllers;

import com.mycompany.seminario.daoimpl.AutomotorDaoImpl;
import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.models.AutomotorModel;
import java.util.List;

/**
 *
 * @author Sofi
 */
public class AutomotorController {

    public static List<AutomotorModel> buscarPorDueño(int idDueño) {
        AutomotorDaoImpl au = (AutomotorDaoImpl) DaoFactory.getDaoObject("automotor");

        return au.findByOwnerId(idDueño);
    }

}
