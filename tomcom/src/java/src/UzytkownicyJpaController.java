/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import src.exceptions.NonexistentEntityException;

/**
 *
 * @author Tomek
 */
public class UzytkownicyJpaController implements Serializable {

    public UzytkownicyJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Uzytkownicy uzytkownicy) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(uzytkownicy);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Uzytkownicy uzytkownicy) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            uzytkownicy = em.merge(uzytkownicy);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = uzytkownicy.getId();
                if (findUzytkownicy(id) == null) {
                    throw new NonexistentEntityException("The uzytkownicy with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Uzytkownicy uzytkownicy;
            try {
                uzytkownicy = em.getReference(Uzytkownicy.class, id);
                uzytkownicy.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The uzytkownicy with id " + id + " no longer exists.", enfe);
            }
            em.remove(uzytkownicy);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Uzytkownicy> findUzytkownicyEntities() {
        return findUzytkownicyEntities(true, -1, -1);
    }

    public List<Uzytkownicy> findUzytkownicyEntities(int maxResults, int firstResult) {
        return findUzytkownicyEntities(false, maxResults, firstResult);
    }

    private List<Uzytkownicy> findUzytkownicyEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Uzytkownicy.class));
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

    public Uzytkownicy findUzytkownicy(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Uzytkownicy.class, id);
        } finally {
            em.close();
        }
    }

    public int getUzytkownicyCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Uzytkownicy> rt = cq.from(Uzytkownicy.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
