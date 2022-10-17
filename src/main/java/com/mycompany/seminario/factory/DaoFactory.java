package com.mycompany.seminario.factory;

import com.mycompany.seminario.daoimpl.AseguradoraDaoImpl;
import com.mycompany.seminario.daoimpl.AutomotorDaoImpl;
import com.mycompany.seminario.daoimpl.ClienteDaoImpl;
import com.mycompany.seminario.daoimpl.EspecialidadDaoImpl;
import com.mycompany.seminario.daoimpl.FichaMecanicaDaoImpl;
import com.mycompany.seminario.daoimpl.MarcaAutomotorDaoImpl;
import com.mycompany.seminario.daoimpl.MecanicoDaoImpl;
import com.mycompany.seminario.daoimpl.ModeloAutomotorDaoImpl;
import com.mycompany.seminario.daoimpl.TipoDocumentoDaoImpl;
import com.mycompany.seminario.daoimpl.TurnoDaoImpl;
import com.mycompany.seminario.database.DaoInterface;

/**
 *
 * @author Sofi
 */
public class DaoFactory {

    public static DaoInterface getDaoObject(String objectEntityName) {

        DaoInterface instance = null;

        switch (objectEntityName.toLowerCase()) {
            case "cliente":
                instance = new ClienteDaoImpl();
                break;
            case "turno":
                instance = new TurnoDaoImpl();
                break;
            case "automotor":
                instance = new AutomotorDaoImpl();
                break;
            case "fichamecanica":
                instance = new FichaMecanicaDaoImpl();
                break;
            case "tipodocumento":
                instance = new TipoDocumentoDaoImpl();
                break;
            case "marca":
                instance= new MarcaAutomotorDaoImpl();
                break;
            case "modelo":
                instance=new ModeloAutomotorDaoImpl();
                break;
            case "aseguradora":
                instance=new AseguradoraDaoImpl();
                break;
            case "especialidad":
                instance=new EspecialidadDaoImpl();
                break;
            case "mecanico":
                instance=new MecanicoDaoImpl();
                break;
        }

        return instance;

    }

}
