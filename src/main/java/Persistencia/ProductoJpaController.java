package Persistencia;

import java.io.Serializable;
import Logica.DetalleProducto;
import java.util.ArrayList;
import java.util.List;
import Logica.Producto;
import Persistencia.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ProductoJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ProductoJpaController() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_Muebleria_war_1.0-SNAPSHOTPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        if (producto.getComponentes() == null) {
            producto.setComponentes(new ArrayList<DetalleProducto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            List<DetalleProducto> attachedComponentes = new ArrayList<>();
            for (DetalleProducto componente : producto.getComponentes()) {
                componente = em.getReference(componente.getClass(), componente.getIdDetalleProducto());
                attachedComponentes.add(componente);
            }
            producto.setComponentes(attachedComponentes);

            em.persist(producto);

            for (DetalleProducto componente : producto.getComponentes()) {
                Producto oldProducto = componente.getProducto();
                componente.setProducto(producto);
                componente = em.merge(componente);
                if (oldProducto != null && !oldProducto.equals(producto)) {
                    oldProducto.getComponentes().remove(componente);
                    em.merge(oldProducto);
                }
            }

            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            List<DetalleProducto> componentesOld = persistentProducto.getComponentes();
            List<DetalleProducto> componentesNew = producto.getComponentes();

            List<DetalleProducto> attachedComponentesNew = new ArrayList<>();
            for (DetalleProducto componente : componentesNew) {
                componente = em.getReference(componente.getClass(), componente.getIdDetalleProducto());
                attachedComponentesNew.add(componente);
            }
            componentesNew = attachedComponentesNew;
            producto.setComponentes(componentesNew);

            producto = em.merge(producto);

            for (DetalleProducto componenteOld : componentesOld) {
                if (!componentesNew.contains(componenteOld)) {
                    componenteOld.setProducto(null);
                    em.merge(componenteOld);
                }
            }

            for (DetalleProducto componenteNew : componentesNew) {
                if (!componentesOld.contains(componenteNew)) {
                    Producto oldProducto = componenteNew.getProducto();
                    componenteNew.setProducto(producto);
                    em.merge(componenteNew);
                    if (oldProducto != null && !oldProducto.equals(producto)) {
                        oldProducto.getComponentes().remove(componenteNew);
                        em.merge(oldProducto);
                    }
                }
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.isEmpty()) {
                Long id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("El producto con id " + id + " ya no existe.");
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

            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El producto con id " + id + " ya no existe.", enfe);
            }

            List<DetalleProducto> componentes = producto.getComponentes();
            for (DetalleProducto componente : componentes) {
                componente.setProducto(null);
                em.merge(componente);
            }

            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Producto> cq = em.getCriteriaBuilder().createQuery(Producto.class);
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(rt);
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

    public Producto findProducto(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
