
package com.mycompany.seminario.controllers;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.hibernate.models.Cliente;
import com.mycompany.seminario.hibernatedao.entityinterfaces.ClienteDaoHibernate;
import com.mycompany.seminario.models.ClienteModel;

/**
 *
 * @author Sofi
 */
public class ClienteController {
    /*JDBC*/
    /*
    public static ClienteModel buscarPorTipoyNumeroDocumento(int tipoDoc,String numero){
        ClienteDaoImpl cli = (ClienteDaoImpl) DaoFactory.getDaoObject("cliente");      
        return cli.findByTipoAndNumDocumento(tipoDoc, numero);
    
    }*/
    
   
    //private ClienteJpaController clienteDao=new ClienteJpaController(EntityManagerProvider.getEntityManagerFactory());
     /*Hibernate*/
     public static ClienteModel buscarPorTipoyNumeroDocumento(int tipoDoc,String numero){
        ClienteModel cm=new ClienteModel();
        ClienteDaoHibernate cdh= (ClienteDaoHibernate) DaoFactory.getHibernateDao("cliente");
        Cliente c=cdh.findByTipoAndNumDocumento();
        cm.setApellido(c.getApellido());
        cm.setNombre(c.getNombre());
        cm.setId(c.getId());
        cm.setTelefono(c.getContacto().getTelefono().toString());
         return cm;
     }
    
}
