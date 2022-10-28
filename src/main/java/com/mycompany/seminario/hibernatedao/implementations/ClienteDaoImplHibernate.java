package com.mycompany.seminario.hibernatedao.implementations;

import com.mycompany.seminario.hibernatedao.entityinterfaces.ClienteDaoHibernate;
import com.mycompany.seminario.hibernate.models.Cliente;
import com.mycompany.seminario.hibernatedao.generic.GenericDaoImpl;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Sofy
 */
public class ClienteDaoImplHibernate extends GenericDaoImpl<Cliente, Integer> implements ClienteDaoHibernate {

    @Override
    public Cliente findByTipoAndNumDocumento() {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb= em.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> root =cq.from(Cliente.class);
      
        
        
        return null;
    }

}
