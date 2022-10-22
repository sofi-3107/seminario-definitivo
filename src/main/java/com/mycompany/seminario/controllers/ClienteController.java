
package com.mycompany.seminario.controllers;

import com.mycompany.seminario.hibernate.dao.ClienteJpaController;
import com.mycompany.seminario.hibernate.dao.EntityManagerProvider;
import com.mycompany.seminario.hibernate.models.Cliente;
import com.mycompany.seminario.models.ClienteModel;

/**
 *
 * @author Sofi
 */
public class ClienteController {
    
    /*
    public static ClienteModel buscarPorTipoyNumeroDocumento(int tipoDoc,String numero){
        ClienteDaoImpl cli = (ClienteDaoImpl) DaoFactory.getDaoObject("cliente");      
        return cli.findByTipoAndNumDocumento(tipoDoc, numero);
    
    }*/
    
    private ClienteJpaController clienteDao=new ClienteJpaController(EntityManagerProvider.getEntityManagerFactory());
    
     public static ClienteModel buscarPorTipoyNumeroDocumento(int tipoDoc,String numero){
         ClienteModel c=new ClienteModel();
        
         return c;
     }
    
}
