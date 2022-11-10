package com.mycompany.seminario.hibernatedao.implementations;

import com.mycompany.seminario.hibernatedao.entityinterfaces.ClienteDaoHibernate;
import com.mycompany.seminario.hibernate.models.Cliente;
import com.mycompany.seminario.hibernatedao.generic.GenericDaoImpl;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sofy
 */
public class ClienteDaoImplHibernate extends GenericDaoImpl<Cliente, Integer> implements ClienteDaoHibernate {

    @Override
    public Cliente findByTipoAndNumDocumento(int tipo,String doc) {
        EntityManager em = getEntityManager();
        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findByTipoAndNumDoc", Cliente.class);
        query.setParameter("tipo", tipo);
        query.setParameter("numero", doc);
        Cliente c=query.getSingleResult();
        return c;
    }

}
