/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.DetalleProducto;
import java.io.Serializable;
import Logica.Producto;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author edeze_b1s78wk
 */
public class DetalleProductoJpaController implements Serializable {

    public DetalleProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public DetalleProductoJpaController() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_Muebleria_war_1.0-SNAPSHOTPU");
    }

    public void create(DetalleProducto detalleProducto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto = detalleProducto.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getIdProducto());
                detalleProducto.setProducto(producto);
            }
            em.persist(detalleProducto);
            if (producto != null) {
                producto.getComponentes().add(detalleProducto);
                producto = em.merge(producto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleProducto detalleProducto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleProducto persistentDetalleProducto = em.find(DetalleProducto.class, detalleProducto.getIdDetalleProducto());
            Producto productoOld = persistentDetalleProducto.getProducto();
            Producto productoNew = detalleProducto.getProducto();
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getIdProducto());
                detalleProducto.setProducto(productoNew);
            }
            detalleProducto = em.merge(detalleProducto);
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getComponentes().remove(detalleProducto);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getComponentes().add(detalleProducto);
                productoNew = em.merge(productoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = detalleProducto.getIdDetalleProducto();
                if (findDetalleProducto(id) == null) {
                    throw new NonexistentEntityException("The detalleProducto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleProducto detalleProducto;
            try {
                detalleProducto = em.getReference(DetalleProducto.class, id);
                detalleProducto.getIdDetalleProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleProducto with id " + id + " no longer exists.", enfe);
            }
            Producto producto = detalleProducto.getProducto();
            if (producto != null) {
                producto.getComponentes().remove(detalleProducto);
                producto = em.merge(producto);
            }
            em.remove(detalleProducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleProducto> findDetalleProductoEntities() {
        return findDetalleProductoEntities(true, -1, -1);
    }

    public List<DetalleProducto> findDetalleProductoEntities(int maxResults, int firstResult) {
        return findDetalleProductoEntities(false, maxResults, firstResult);
    }

    private List<DetalleProducto> findDetalleProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleProducto.class));
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

    public DetalleProducto findDetalleProducto(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleProducto.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleProducto> rt = cq.from(DetalleProducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
