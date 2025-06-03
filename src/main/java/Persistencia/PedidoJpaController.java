package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Cliente;
import Logica.Pedido;
import Persistencia.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PedidoJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public PedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PedidoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_Muebleria_war_1.0-SNAPSHOTPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Cliente cliente = pedido.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getIdCliente());
                pedido.setCliente(cliente);
            }

            em.persist(pedido);

            if (cliente != null) {
                cliente.getPedidos().add(pedido);
                em.merge(cliente);
            }

            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public void edit(Pedido pedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Pedido persistentPedido = em.find(Pedido.class, pedido.getIdPedido());
            Cliente clienteOld = persistentPedido.getCliente();
            Cliente clienteNew = pedido.getCliente();

            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getIdCliente());
                pedido.setCliente(clienteNew);
            }

            pedido = em.merge(pedido);

            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getPedidos().remove(pedido);
                em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getPedidos().add(pedido);
                em.merge(clienteNew);
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if ((msg == null || msg.length() == 0) && findPedido(pedido.getIdPedido()) == null) {
                throw new NonexistentEntityException("El pedido con id " + pedido.getIdPedido() + " ya no existe.");
            }
            throw ex;
        } finally {
            if (em != null) em.close();
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getIdPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El pedido con id " + id + " no existe.", enfe);
            }

            Cliente cliente = pedido.getCliente();
            if (cliente != null && cliente.getPedidos() != null) {
                cliente.getPedidos().remove(pedido);
                em.merge(cliente);
            }

            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Pedido> cq = em.getCriteriaBuilder().createQuery(Pedido.class);
            Root<Pedido> rt = cq.from(Pedido.class);
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

    public Pedido findPedido(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            Long count = (Long) q.getSingleResult();
            return count != null ? count.intValue() : 0;
        } finally {
            em.close();
        }
    }
}
