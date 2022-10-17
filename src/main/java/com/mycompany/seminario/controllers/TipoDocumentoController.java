
package com.mycompany.seminario.controllers;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.models.TipoDocumentoModel;
import java.util.List;

/**
 *
 * @author Sofi
 */
public class TipoDocumentoController {
    
    public static List<TipoDocumentoModel> getTiposDeDocumento(){
        return DaoFactory.getDaoObject("tipodocumento").getAll();
    }
    
}
