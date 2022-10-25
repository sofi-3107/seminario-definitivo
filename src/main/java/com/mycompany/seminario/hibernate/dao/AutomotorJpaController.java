
package com.mycompany.seminario.hibernate.dao;

import com.mycompany.seminario.hibernate.dao.exceptions.IllegalOrphanException;
import com.mycompany.seminario.hibernate.dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import com.mycompany.seminario.hibernate.models.Aseguradora;
import com.mycompany.seminario.hibernate.models.Automotor;
import com.mycompany.seminario.hibernate.models.Cliente;
import com.mycompany.seminario.hibernate.models.MarcaAutomotor;
import com.mycompany.seminario.hibernate.models.ModeloAutomotor;
import com.mycompany.seminario.hibernate.models.Turno;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.seminario.hibernate.models.FichaMecanica;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Sofi
 */
public class AutomotorJpaController implements Serializable {

    public AutomotorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Automotor automotor) {
        if (automotor.getTurnoList() == null) {
            automotor.setTurnoList(new ArrayList<Turno>());
        }
        if (automotor.getFichaMecanicaList() == null) {
            automotor.setFichaMecanicaList(new ArrayList<FichaMecanica>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aseguradora aseguradora = automotor.getAseguradora();
            if (aseguradora != null) {
                aseguradora = em.getReference(aseguradora.getClass(), aseguradora.getId());
                automotor.setAseguradora(aseguradora);
            }
            Cliente dueño = automotor.getDueño();
            if (dueño != null) {
                dueño = em.getReference(dueño.getClass(), dueño.getId());
                automotor.setDueño(dueño);
            }
            MarcaAutomotor marca = automotor.getMarca();
            if (marca != null) {
                marca = em.getReference(marca.getClass(), marca.getId());
                automotor.setMarca(marca);
            }
            ModeloAutomotor modelo = automotor.getModelo();
            if (modelo != null) {
                modelo = em.getReference(modelo.getClass(), modelo.getId());
                automotor.setModelo(modelo);
            }
            List<Turno> attachedTurnoList = new ArrayList<Turno>();
            for (Turno turnoListTurnoToAttach : automotor.getTurnoList()) {
                turnoListTurnoToAttach = em.getReference(turnoListTurnoToAttach.getClass(), turnoListTurnoToAttach.getId());
                attachedTurnoList.add(turnoListTurnoToAttach);
            }
            automotor.setTurnoList(attachedTurnoList);
            List<FichaMecanica> attachedFichaMecanicaList = new ArrayList<FichaMecanica>();
            for (FichaMecanica fichaMecanicaListFichaMecanicaToAttach : automotor.getFichaMecanicaList()) {
                fichaMecanicaListFichaMecanicaToAttach = em.getReference(fichaMecanicaListFichaMecanicaToAttach.getClass(), fichaMecanicaListFichaMecanicaToAttach.getId());
                attachedFichaMecanicaList.add(fichaMecanicaListFichaMecanicaToAttach);
            }
            automotor.setFichaMecanicaList(attachedFichaMecanicaList);
            em.persist(automotor);
            if (aseguradora != null) {
                aseguradora.getAutomotorList().add(automotor);
                aseguradora = em.merge(aseguradora);
            }
            if (dueño != null) {
                dueño.getAutomotorList().add(automotor);
                dueño = em.merge(dueño);
            }
            if (marca != null) {
                marca.getAutomotorList().add(automotor);
                marca = em.merge(marca);
            }
            if (modelo != null) {
                modelo.getAutomotorList().add(automotor);
                modelo = em.merge(modelo);
            }
            for (Turno turnoListTurno : automotor.getTurnoList()) {
                Automotor oldAutomotorOfTurnoListTurno = turnoListTurno.getAutomotor();
                turnoListTurno.setAutomotor(automotor);
                turnoListTurno = em.merge(turnoListTurno);
                if (oldAutomotorOfTurnoListTurno != null) {
                    oldAutomotorOfTurnoListTurno.getTurnoList().remove(turnoListTurno);
                    oldAutomotorOfTurnoListTurno = em.merge(oldAutomotorOfTurnoListTurno);
                }
            }
            for (FichaMecanica fichaMecanicaListFichaMecanica : automotor.getFichaMecanicaList()) {
                Automotor oldAutomotorOfFichaMecanicaListFichaMecanica = fichaMecanicaListFichaMecanica.getAutomotor();
                fichaMecanicaListFichaMecanica.setAutomotor(automotor);
                fichaMecanicaListFichaMecanica = em.merge(fichaMecanicaListFichaMecanica);
                if (oldAutomotorOfFichaMecanicaListFichaMecanica != null) {
                    oldAutomotorOfFichaMecanicaListFichaMecanica.getFichaMecanicaList().remove(fichaMecanicaListFichaMecanica);
                    oldAutomotorOfFichaMecanicaListFichaMecanica = em.merge(oldAutomotorOfFichaMecanicaListFichaMecanica);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Automotor automotor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Automotor persistentAutomotor = em.find(Automotor.class, automotor.getId());
            Aseguradora aseguradoraOld = persistentAutomotor.getAseguradora();
            Aseguradora aseguradoraNew = automotor.getAseguradora();
            Cliente dueñoOld = persistentAutomotor.getDueño();
            Cliente dueñoNew = automotor.getDueño();
            MarcaAutomotor marcaOld = persistentAutomotor.getMarca();
            MarcaAutomotor marcaNew = automotor.getMarca();
            ModeloAutomotor modeloOld = persistentAutomotor.getModelo();
            ModeloAutomotor modeloNew = automotor.getModelo();
            List<Turno> turnoListOld = persistentAutomotor.getTurnoList();
            List<Turno> turnoListNew = automotor.getTurnoList();
            List<FichaMecanica> fichaMecanicaListOld = persistentAutomotor.getFichaMecanicaList();
            List<FichaMecanica> fichaMecanicaListNew = automotor.getFichaMecanicaList();
            List<String> illegalOrphanMessages = null;
            for (Turno turnoListOldTurno : turnoListOld) {
                if (!turnoListNew.contains(turnoListOldTurno)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Turno " + turnoListOldTurno + " since its automotor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (aseguradoraNew != null) {
                aseguradoraNew = em.getReference(aseguradoraNew.getClass(), aseguradoraNew.getId());
                automotor.setAseguradora(aseguradoraNew);
            }
            if (dueñoNew != null) {
                dueñoNew = em.getReference(dueñoNew.getClass(), dueñoNew.getId());
                automotor.setDueño(dueñoNew);
            }
            if (marcaNew != null) {
                marcaNew = em.getReference(marcaNew.getClass(), marcaNew.getId());
                automotor.setMarca(marcaNew);
            }
            if (modeloNew != null) {
                modeloNew = em.getReference(modeloNew.getClass(), modeloNew.getId());
                automotor.setModelo(modeloNew);
            }
            List<Turno> attachedTurnoListNew = new ArrayList<Turno>();
            for (Turno turnoListNewTurnoToAttach : turnoListNew) {
                turnoListNewTurnoToAttach = em.getReference(turnoListNewTurnoToAttach.getClass(), turnoListNewTurnoToAttach.getId());
                attachedTurnoListNew.add(turnoListNewTurnoToAttach);
            }
            turnoListNew = attachedTurnoListNew;
            automotor.setTurnoList(turnoListNew);
            List<FichaMecanica> attachedFichaMecanicaListNew = new ArrayList<FichaMecanica>();
            for (FichaMecanica fichaMecanicaListNewFichaMecanicaToAttach : fichaMecanicaListNew) {
                fichaMecanicaListNewFichaMecanicaToAttach = em.getReference(fichaMecanicaListNewFichaMecanicaToAttach.getClass(), fichaMecanicaListNewFichaMecanicaToAttach.getId());
                attachedFichaMecanicaListNew.add(fichaMecanicaListNewFichaMecanicaToAttach);
            }
            fichaMecanicaListNew = attachedFichaMecanicaListNew;
            automotor.setFichaMecanicaList(fichaMecanicaListNew);
            automotor = em.merge(automotor);
            if (aseguradoraOld != null && !aseguradoraOld.equals(aseguradoraNew)) {
                aseguradoraOld.getAutomotorList().remove(automotor);
                aseguradoraOld = em.merge(aseguradoraOld);
            }
            if (aseguradoraNew != null && !aseguradoraNew.equals(aseguradoraOld)) {
                aseguradoraNew.getAutomotorList().add(automotor);
                aseguradoraNew = em.merge(aseguradoraNew);
            }
            if (dueñoOld != null && !dueñoOld.equals(dueñoNew)) {
                dueñoOld.getAutomotorList().remove(automotor);
                dueñoOld = em.merge(dueñoOld);
            }
            if (dueñoNew != null && !dueñoNew.equals(dueñoOld)) {
                dueñoNew.getAutomotorList().add(automotor);
                dueñoNew = em.merge(dueñoNew);
            }
            if (marcaOld != null && !marcaOld.equals(marcaNew)) {
                marcaOld.getAutomotorList().remove(automotor);
                marcaOld = em.merge(marcaOld);
            }
            if (marcaNew != null && !marcaNew.equals(marcaOld)) {
                marcaNew.getAutomotorList().add(automotor);
                marcaNew = em.merge(marcaNew);
            }
            if (modeloOld != null && !modeloOld.equals(modeloNew)) {
                modeloOld.getAutomotorList().remove(automotor);
                modeloOld = em.merge(modeloOld);
            }
            if (modeloNew != null && !modeloNew.equals(modeloOld)) {
                modeloNew.getAutomotorList().add(automotor);
                modeloNew = em.merge(modeloNew);
            }
            for (Turno turnoListNewTurno : turnoListNew) {
                if (!turnoListOld.contains(turnoListNewTurno)) {
                    Automotor oldAutomotorOfTurnoListNewTurno = turnoListNewTurno.getAutomotor();
                    turnoListNewTurno.setAutomotor(automotor);
                    turnoListNewTurno = em.merge(turnoListNewTurno);
                    if (oldAutomotorOfTurnoListNewTurno != null && !oldAutomotorOfTurnoListNewTurno.equals(automotor)) {
                        oldAutomotorOfTurnoListNewTurno.getTurnoList().remove(turnoListNewTurno);
                        oldAutomotorOfTurnoListNewTurno = em.merge(oldAutomotorOfTurnoListNewTurno);
                    }
                }
            }
            for (FichaMecanica fichaMecanicaListOldFichaMecanica : fichaMecanicaListOld) {
                if (!fichaMecanicaListNew.contains(fichaMecanicaListOldFichaMecanica)) {
                    fichaMecanicaListOldFichaMecanica.setAutomotor(null);
                    fichaMecanicaListOldFichaMecanica = em.merge(fichaMecanicaListOldFichaMecanica);
                }
            }
            for (FichaMecanica fichaMecanicaListNewFichaMecanica : fichaMecanicaListNew) {
                if (!fichaMecanicaListOld.contains(fichaMecanicaListNewFichaMecanica)) {
                    Automotor oldAutomotorOfFichaMecanicaListNewFichaMecanica = fichaMecanicaListNewFichaMecanica.getAutomotor();
                    fichaMecanicaListNewFichaMecanica.setAutomotor(automotor);
                    fichaMecanicaListNewFichaMecanica = em.merge(fichaMecanicaListNewFichaMecanica);
                    if (oldAutomotorOfFichaMecanicaListNewFichaMecanica != null && !oldAutomotorOfFichaMecanicaListNewFichaMecanica.equals(automotor)) {
                        oldAutomotorOfFichaMecanicaListNewFichaMecanica.getFichaMecanicaList().remove(fichaMecanicaListNewFichaMecanica);
                        oldAutomotorOfFichaMecanicaListNewFichaMecanica = em.merge(oldAutomotorOfFichaMecanicaListNewFichaMecanica);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = automotor.getId();
                if (findAutomotor(id) == null) {
                    throw new NonexistentEntityException("The automotor with id " + id + " no longer exists.");
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
            Automotor automotor;
            try {
                automotor = em.getReference(Automotor.class, id);
                automotor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The automotor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Turno> turnoListOrphanCheck = automotor.getTurnoList();
            for (Turno turnoListOrphanCheckTurno : turnoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Automotor (" + automotor + ") cannot be destroyed since the Turno " + turnoListOrphanCheckTurno + " in its turnoList field has a non-nullable automotor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Aseguradora aseguradora = automotor.getAseguradora();
            if (aseguradora != null) {
                aseguradora.getAutomotorList().remove(automotor);
                aseguradora = em.merge(aseguradora);
            }
            Cliente dueño = automotor.getDueño();
            if (dueño != null) {
                dueño.getAutomotorList().remove(automotor);
                dueño = em.merge(dueño);
            }
            MarcaAutomotor marca = automotor.getMarca();
            if (marca != null) {
                marca.getAutomotorList().remove(automotor);
                marca = em.merge(marca);
            }
            ModeloAutomotor modelo = automotor.getModelo();
            if (modelo != null) {
                modelo.getAutomotorList().remove(automotor);
                modelo = em.merge(modelo);
            }
            List<FichaMecanica> fichaMecanicaList = automotor.getFichaMecanicaList();
            for (FichaMecanica fichaMecanicaListFichaMecanica : fichaMecanicaList) {
                fichaMecanicaListFichaMecanica.setAutomotor(null);
                fichaMecanicaListFichaMecanica = em.merge(fichaMecanicaListFichaMecanica);
            }
            em.remove(automotor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Automotor> findAutomotorEntities() {
        return findAutomotorEntities(true, -1, -1);
    }

    public List<Automotor> findAutomotorEntities(int maxResults, int firstResult) {
        return findAutomotorEntities(false, maxResults, firstResult);
    }

    private List<Automotor> findAutomotorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Automotor.class));
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

    public Automotor findAutomotor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Automotor.class, id);
        } finally {
            em.close();
        }
    }

  
    
}
