package com.mycompany.seminario.hibernate.dao;

import com.mycompany.seminario.hibernate.dao.exceptions.IllegalOrphanException;
import com.mycompany.seminario.hibernate.dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.seminario.hibernate.models.Contacto;
import com.mycompany.seminario.hibernate.models.Turno;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.seminario.hibernate.models.Automotor;
import com.mycompany.seminario.hibernate.models.Cliente;
import com.mycompany.seminario.hibernate.models.FichaMecanica;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sofi
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Cliente findByTipoAndNumeroDocumento( String num, int tipoDoc) {
        EntityManager em = getEntityManager();
        Cliente c=new Cliente();
        try {
            em.getTransaction().begin();
            TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findByTipoAndNumDoc", Cliente.class);
            query.setParameter("numero", num);
            query.setParameter("tipo", tipoDoc);
            c=query.getSingleResult();
        } finally {
            em.close();
        }
        return c;
    }

    public void create(Cliente cliente) {
        if (cliente.getTurnos() == null) {
            cliente.setTurnos(new ArrayList<Turno>());
        }
        if (cliente.getAutomotorList() == null) {
            cliente.setAutomotorList(new ArrayList<Automotor>());
        }
        if (cliente.getFichaMecanicaList() == null) {
            cliente.setFichaMecanicaList(new ArrayList<FichaMecanica>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contacto contacto = cliente.getContacto();
            if (contacto != null) {
                contacto = em.getReference(contacto.getClass(), contacto.getId());
                cliente.setContacto(contacto);
            }
            List<Turno> attachedTurnos = new ArrayList<Turno>();
            for (Turno turnosTurnoToAttach : cliente.getTurnos()) {
                turnosTurnoToAttach = em.getReference(turnosTurnoToAttach.getClass(), turnosTurnoToAttach.getId());
                attachedTurnos.add(turnosTurnoToAttach);
            }
            cliente.setTurnos(attachedTurnos);
            List<Automotor> attachedAutomotorList = new ArrayList<Automotor>();
            for (Automotor automotorListAutomotorToAttach : cliente.getAutomotorList()) {
                automotorListAutomotorToAttach = em.getReference(automotorListAutomotorToAttach.getClass(), automotorListAutomotorToAttach.getId());
                attachedAutomotorList.add(automotorListAutomotorToAttach);
            }
            cliente.setAutomotorList(attachedAutomotorList);
            List<FichaMecanica> attachedFichaMecanicaList = new ArrayList<FichaMecanica>();
            for (FichaMecanica fichaMecanicaListFichaMecanicaToAttach : cliente.getFichaMecanicaList()) {
                fichaMecanicaListFichaMecanicaToAttach = em.getReference(fichaMecanicaListFichaMecanicaToAttach.getClass(), fichaMecanicaListFichaMecanicaToAttach.getId());
                attachedFichaMecanicaList.add(fichaMecanicaListFichaMecanicaToAttach);
            }
            cliente.setFichaMecanicaList(attachedFichaMecanicaList);
            em.persist(cliente);
            if (contacto != null) {
                Cliente oldClienteOfContacto = contacto.getCliente();
                if (oldClienteOfContacto != null) {
                    oldClienteOfContacto.setContacto(null);
                    oldClienteOfContacto = em.merge(oldClienteOfContacto);
                }
                contacto.setCliente(cliente);
                contacto = em.merge(contacto);
            }
            for (Turno turnosTurno : cliente.getTurnos()) {
                Cliente oldClienteOfTurnosTurno = turnosTurno.getCliente();
                turnosTurno.setCliente(cliente);
                turnosTurno = em.merge(turnosTurno);
                if (oldClienteOfTurnosTurno != null) {
                    oldClienteOfTurnosTurno.getTurnos().remove(turnosTurno);
                    oldClienteOfTurnosTurno = em.merge(oldClienteOfTurnosTurno);
                }
            }
            for (Automotor automotorListAutomotor : cliente.getAutomotorList()) {
                Cliente oldDueñoOfAutomotorListAutomotor = automotorListAutomotor.getDueño();
                automotorListAutomotor.setDueño(cliente);
                automotorListAutomotor = em.merge(automotorListAutomotor);
                if (oldDueñoOfAutomotorListAutomotor != null) {
                    oldDueñoOfAutomotorListAutomotor.getAutomotorList().remove(automotorListAutomotor);
                    oldDueñoOfAutomotorListAutomotor = em.merge(oldDueñoOfAutomotorListAutomotor);
                }
            }
            for (FichaMecanica fichaMecanicaListFichaMecanica : cliente.getFichaMecanicaList()) {
                Cliente oldClienteOfFichaMecanicaListFichaMecanica = fichaMecanicaListFichaMecanica.getCliente();
                fichaMecanicaListFichaMecanica.setCliente(cliente);
                fichaMecanicaListFichaMecanica = em.merge(fichaMecanicaListFichaMecanica);
                if (oldClienteOfFichaMecanicaListFichaMecanica != null) {
                    oldClienteOfFichaMecanicaListFichaMecanica.getFichaMecanicaList().remove(fichaMecanicaListFichaMecanica);
                    oldClienteOfFichaMecanicaListFichaMecanica = em.merge(oldClienteOfFichaMecanicaListFichaMecanica);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getId());
            Contacto contactoOld = persistentCliente.getContacto();
            Contacto contactoNew = cliente.getContacto();
            List<Turno> turnosOld = persistentCliente.getTurnos();
            List<Turno> turnosNew = cliente.getTurnos();
            List<Automotor> automotorListOld = persistentCliente.getAutomotorList();
            List<Automotor> automotorListNew = cliente.getAutomotorList();
            List<FichaMecanica> fichaMecanicaListOld = persistentCliente.getFichaMecanicaList();
            List<FichaMecanica> fichaMecanicaListNew = cliente.getFichaMecanicaList();
            List<String> illegalOrphanMessages = null;
            for (Automotor automotorListOldAutomotor : automotorListOld) {
                if (!automotorListNew.contains(automotorListOldAutomotor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Automotor " + automotorListOldAutomotor + " since its due\u00f1o field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (contactoNew != null) {
                contactoNew = em.getReference(contactoNew.getClass(), contactoNew.getId());
                cliente.setContacto(contactoNew);
            }
            List<Turno> attachedTurnosNew = new ArrayList<Turno>();
            for (Turno turnosNewTurnoToAttach : turnosNew) {
                turnosNewTurnoToAttach = em.getReference(turnosNewTurnoToAttach.getClass(), turnosNewTurnoToAttach.getId());
                attachedTurnosNew.add(turnosNewTurnoToAttach);
            }
            turnosNew = attachedTurnosNew;
            cliente.setTurnos(turnosNew);
            List<Automotor> attachedAutomotorListNew = new ArrayList<Automotor>();
            for (Automotor automotorListNewAutomotorToAttach : automotorListNew) {
                automotorListNewAutomotorToAttach = em.getReference(automotorListNewAutomotorToAttach.getClass(), automotorListNewAutomotorToAttach.getId());
                attachedAutomotorListNew.add(automotorListNewAutomotorToAttach);
            }
            automotorListNew = attachedAutomotorListNew;
            cliente.setAutomotorList(automotorListNew);
            List<FichaMecanica> attachedFichaMecanicaListNew = new ArrayList<FichaMecanica>();
            for (FichaMecanica fichaMecanicaListNewFichaMecanicaToAttach : fichaMecanicaListNew) {
                fichaMecanicaListNewFichaMecanicaToAttach = em.getReference(fichaMecanicaListNewFichaMecanicaToAttach.getClass(), fichaMecanicaListNewFichaMecanicaToAttach.getId());
                attachedFichaMecanicaListNew.add(fichaMecanicaListNewFichaMecanicaToAttach);
            }
            fichaMecanicaListNew = attachedFichaMecanicaListNew;
            cliente.setFichaMecanicaList(fichaMecanicaListNew);
            cliente = em.merge(cliente);
            if (contactoOld != null && !contactoOld.equals(contactoNew)) {
                contactoOld.setCliente(null);
                contactoOld = em.merge(contactoOld);
            }
            if (contactoNew != null && !contactoNew.equals(contactoOld)) {
                Cliente oldClienteOfContacto = contactoNew.getCliente();
                if (oldClienteOfContacto != null) {
                    oldClienteOfContacto.setContacto(null);
                    oldClienteOfContacto = em.merge(oldClienteOfContacto);
                }
                contactoNew.setCliente(cliente);
                contactoNew = em.merge(contactoNew);
            }
            for (Turno turnosOldTurno : turnosOld) {
                if (!turnosNew.contains(turnosOldTurno)) {
                    turnosOldTurno.setCliente(null);
                    turnosOldTurno = em.merge(turnosOldTurno);
                }
            }
            for (Turno turnosNewTurno : turnosNew) {
                if (!turnosOld.contains(turnosNewTurno)) {
                    Cliente oldClienteOfTurnosNewTurno = turnosNewTurno.getCliente();
                    turnosNewTurno.setCliente(cliente);
                    turnosNewTurno = em.merge(turnosNewTurno);
                    if (oldClienteOfTurnosNewTurno != null && !oldClienteOfTurnosNewTurno.equals(cliente)) {
                        oldClienteOfTurnosNewTurno.getTurnos().remove(turnosNewTurno);
                        oldClienteOfTurnosNewTurno = em.merge(oldClienteOfTurnosNewTurno);
                    }
                }
            }
            for (Automotor automotorListNewAutomotor : automotorListNew) {
                if (!automotorListOld.contains(automotorListNewAutomotor)) {
                    Cliente oldDueñoOfAutomotorListNewAutomotor = automotorListNewAutomotor.getDueño();
                    automotorListNewAutomotor.setDueño(cliente);
                    automotorListNewAutomotor = em.merge(automotorListNewAutomotor);
                    if (oldDueñoOfAutomotorListNewAutomotor != null && !oldDueñoOfAutomotorListNewAutomotor.equals(cliente)) {
                        oldDueñoOfAutomotorListNewAutomotor.getAutomotorList().remove(automotorListNewAutomotor);
                        oldDueñoOfAutomotorListNewAutomotor = em.merge(oldDueñoOfAutomotorListNewAutomotor);
                    }
                }
            }
            for (FichaMecanica fichaMecanicaListOldFichaMecanica : fichaMecanicaListOld) {
                if (!fichaMecanicaListNew.contains(fichaMecanicaListOldFichaMecanica)) {
                    fichaMecanicaListOldFichaMecanica.setCliente(null);
                    fichaMecanicaListOldFichaMecanica = em.merge(fichaMecanicaListOldFichaMecanica);
                }
            }
            for (FichaMecanica fichaMecanicaListNewFichaMecanica : fichaMecanicaListNew) {
                if (!fichaMecanicaListOld.contains(fichaMecanicaListNewFichaMecanica)) {
                    Cliente oldClienteOfFichaMecanicaListNewFichaMecanica = fichaMecanicaListNewFichaMecanica.getCliente();
                    fichaMecanicaListNewFichaMecanica.setCliente(cliente);
                    fichaMecanicaListNewFichaMecanica = em.merge(fichaMecanicaListNewFichaMecanica);
                    if (oldClienteOfFichaMecanicaListNewFichaMecanica != null && !oldClienteOfFichaMecanicaListNewFichaMecanica.equals(cliente)) {
                        oldClienteOfFichaMecanicaListNewFichaMecanica.getFichaMecanicaList().remove(fichaMecanicaListNewFichaMecanica);
                        oldClienteOfFichaMecanicaListNewFichaMecanica = em.merge(oldClienteOfFichaMecanicaListNewFichaMecanica);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cliente.getId();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Automotor> automotorListOrphanCheck = cliente.getAutomotorList();
            for (Automotor automotorListOrphanCheckAutomotor : automotorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Automotor " + automotorListOrphanCheckAutomotor + " in its automotorList field has a non-nullable due\u00f1o field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Contacto contacto = cliente.getContacto();
            if (contacto != null) {
                contacto.setCliente(null);
                contacto = em.merge(contacto);
            }
            List<Turno> turnos = cliente.getTurnos();
            for (Turno turnosTurno : turnos) {
                turnosTurno.setCliente(null);
                turnosTurno = em.merge(turnosTurno);
            }
            List<FichaMecanica> fichaMecanicaList = cliente.getFichaMecanicaList();
            for (FichaMecanica fichaMecanicaListFichaMecanica : fichaMecanicaList) {
                fichaMecanicaListFichaMecanica.setCliente(null);
                fichaMecanicaListFichaMecanica = em.merge(fichaMecanicaListFichaMecanica);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente findCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
