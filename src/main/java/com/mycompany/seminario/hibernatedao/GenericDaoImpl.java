package com.mycompany.seminario.hibernatedao;

import com.mycompany.seminario.hibernate.controllers.EntityManagerProvider;
import com.mycompany.seminario.hibernate.dao.exceptions.IllegalOrphanException;
import com.mycompany.seminario.hibernate.dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Sofy
 */
public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

   
    EntityManagerFactory emf = EntityManagerProvider.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void saveOrUpdate(T e) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public T getId(ID id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            return em.find(getEntityClass(), id);
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(ID id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            /* Solo tiene inicializado el id, es mas ligero y mejor para eliminar*/
            T t = em.getReference(getEntityClass(), id);
            em.remove(t);
        } catch (EntityNotFoundException e) {
            throw new NonexistentEntityException("La entidad " + getEntityClass().getName() + " id: " + id + " no existe.", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<T> findAll() throws Exception {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(getEntityClass()));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
