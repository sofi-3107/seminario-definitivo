
package com.mycompany.seminario.controllers;

import com.mycompany.seminario.daoimpl.ClienteDaoImpl;
import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.models.ClienteModel;

/**
 *
 * @author Sofi
 */
public class ClienteController {
    
    
    public static ClienteModel buscarPorTipoyNumeroDocumento(int tipoDoc,String numero){
        ClienteDaoImpl cli = (ClienteDaoImpl) DaoFactory.getDaoObject("cliente");      
        return cli.findByTipoAndNumDocumento(tipoDoc, numero);
    
    }
    
}
