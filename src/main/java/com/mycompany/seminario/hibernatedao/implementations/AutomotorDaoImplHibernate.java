
package com.mycompany.seminario.hibernatedao.implementations;

import com.mycompany.seminario.hibernatedao.entityinterfaces.AutomotorDaoHibernate;
import com.mycompany.seminario.hibernate.models.Automotor;
import com.mycompany.seminario.hibernatedao.generic.GenericDaoImpl;
import java.util.List;

/**
 *
 * @author Sofy
 */
public class AutomotorDaoImplHibernate extends GenericDaoImpl<Automotor,Integer> implements AutomotorDaoHibernate{

    @Override
    public List<Automotor> findByOwner(int ownerId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
