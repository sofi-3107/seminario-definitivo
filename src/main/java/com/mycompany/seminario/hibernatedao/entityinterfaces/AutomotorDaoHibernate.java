
package com.mycompany.seminario.hibernatedao.entityinterfaces;

import com.mycompany.seminario.hibernate.models.Automotor;
import com.mycompany.seminario.hibernatedao.generic.GenericDao;
import java.util.List;

/**
 *
 * @author Sofy
 */
public interface AutomotorDaoHibernate extends GenericDao<Automotor,Integer>{
    
    public List<Automotor>findByOwner(int ownerId);
    
    
    
}
