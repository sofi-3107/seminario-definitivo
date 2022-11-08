package com.mycompany.seminario.controllers;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.hibernate.models.TipoDocumento;
import com.mycompany.seminario.hibernatedao.entityinterfaces.TipoDocumentoDaoHibernate;
import com.mycompany.seminario.models.TipoDocumentoModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofi
 */
public class TipoDocumentoController {

    private static TipoDocumentoDaoHibernate tipoDocDaoH = (TipoDocumentoDaoHibernate) DaoFactory.getHibernateDao("tipodocumento");

    /* public static List<TipoDocumentoModel> getTiposDeDocumento(){
        return DaoFactory.getDaoObject("tipodocumento").getAll();
    }*/

    public static List<TipoDocumentoModel> getTiposDeDocumento() {
        List<TipoDocumentoModel> tiposDoc = new ArrayList();
        try {

            List<TipoDocumento> docs = tipoDocDaoH.findAll();
            docs.stream().forEach(d->{
                TipoDocumentoModel tipo=new TipoDocumentoModel();
                tipo.setId(d.getId());
                tipo.setTipo(d.getTipo());
                tiposDoc.add(tipo);
            
            });
            
        } catch (Exception ex) {
            Logger.getLogger(TipoDocumentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiposDoc;
    }

}
