package com.mycompany.seminario.hibernatedao.implementations;

import com.mycompany.seminario.hibernatedao.entityinterfaces.AutomotorDaoHibernate;
import com.mycompany.seminario.hibernate.models.Automotor;
import com.mycompany.seminario.hibernate.models.Cliente;
import com.mycompany.seminario.hibernatedao.generic.GenericDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sofy
 */
public class AutomotorDaoImplHibernate extends GenericDaoImpl<Automotor, Integer> implements AutomotorDaoHibernate {

    @Override
    public List<Automotor> findByOwner(int ownerId) {
        List<Automotor> autos = new ArrayList();
        EntityManager em = getEntityManager();
        TypedQuery<Automotor> query = em.createNamedQuery("Automotor.findByOwner", Automotor.class);
        query.setParameter("dueño", ownerId);
        autos = query.getResultList();
        return autos;

    }

}
