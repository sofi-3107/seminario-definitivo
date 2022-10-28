
package com.mycompany.seminario.hibernatedao.entityinterfaces;

import com.mycompany.seminario.hibernate.models.Cliente;
import com.mycompany.seminario.hibernatedao.generic.GenericDao;

/**
 *
 * @author Sofy
 */
public interface ClienteDaoHibernate extends GenericDao<Cliente,Integer>{
    
    public Cliente findByTipoAndNumDocumento();
    
    
}
