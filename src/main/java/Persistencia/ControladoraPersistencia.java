/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Cliente;
import Logica.DetalleProducto;
import Logica.MateriaPrima;
import Logica.Pedido;
import Logica.Producto;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edeze_b1s78wk
 */
public class ControladoraPersistencia {
    DetalleProductoJpaController detalleJpa = new DetalleProductoJpaController();
    ProductoJpaController productoJpa = new ProductoJpaController();
    MateriaPrimaJpaController materiaJpa = new MateriaPrimaJpaController();

    
    public void crearMateriaPrima(MateriaPrima materia) {
        materiaJpa.create(materia);
    }
    
    public List<MateriaPrima> traerMateriasPrimas() {
        return materiaJpa.findMateriaPrimaEntities();
    }

    
    public MateriaPrima traerMateriaPrima(int id) {
        return materiaJpa.findMateriaPrima((long)id);
    }

    public void editarMateriaPrima(MateriaPrima m) {
        try {
            materiaJpa.edit(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public MateriaPrima buscarMateriaPorNombre(String nombre) {
    List<MateriaPrima> materias = materiaJpa.findMateriaPrimaEntities();
    for (MateriaPrima m : materias) {
        if (m.getNombre().equalsIgnoreCase(nombre)) {
            return m;
        }
    }
    return null;
}

    
    public void modificarMateriaPrima(MateriaPrima materia) {
    try {
        materiaJpa.edit(materia);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
    
    public void eliminarMateriaPrima(Long idMateriaPrima) {
    try {
        materiaJpa.destroy(idMateriaPrima);
    } catch (Exception e) {
        e.printStackTrace();
    }
}



    public void crearProducto(Producto p) {
        productoJpa.create(p);
    }
    
    public List<Producto> traerProductos() {
        return productoJpa.findProductoEntities();
    }
    
    // Busca un producto por id
    public Producto buscarProducto(Long idProducto) {
        return productoJpa.findProducto(idProducto);
    }

    // Edita un producto (actualiza en BD)
    public void editarProducto(Producto producto) {
        try {
            productoJpa.edit(producto);
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores que quieras agregar
        }
    }
    
    public void eliminarProducto(Long idProducto) {
    try {
        ProductoJpaController productoJpa = new ProductoJpaController();
        productoJpa.destroy(idProducto);
    } catch (Exception e) {
        e.printStackTrace(); // o loguealo como corresponda
    }
}


    public void crearDetalleProducto(DetalleProducto dp) {
        detalleJpa.create(dp);
    }
    
    public Producto buscarProductoPorNombre(String nombre) {
    List<Producto> productos = productoJpa.findProductoEntities();
    for (Producto p : productos) {
        if (p.getNombre().equalsIgnoreCase(nombre)) {
            return p;
        }
    }
    return null;
}
    
    public List<DetalleProducto> traerDetalleProductos() {
    return detalleJpa.findDetalleProductoEntities();
}
    
    
    ClienteJpaController Cjpa = new ClienteJpaController();
    ProductoJpaController ProdJpa = new ProductoJpaController();
    PedidoJpaController Pjpa = new PedidoJpaController();

    // --- Métodos de Cliente ---
    public List<Cliente> traerCliente() {
        return Cjpa.findClienteEntities();
    }

    public void crearCliente(Cliente clien) {
        Cjpa.create(clien);
    }

    // Si tu entidad Cliente tiene 'int idCliente', este método está bien.
    // Si tiene 'Long idCliente', deberás cambiar el parámetro a Long y el JpaController.
    public Cliente traerCliente(Long id) {
        return Cjpa.findCliente(id);
    }

    public void modificarCliente(Cliente cliente) {
        try {
            Cjpa.edit(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            // Aquí podrías manejar la excepción con más detalle o lanzar una excepción personalizada
        }
    }

    public void eliminarCliente(int idCliente) {
        try {
            Cjpa.destroy((long) idCliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // --- Métodos de Pedidos ---
    public void crearPedido(Pedido pedido) {
        Pjpa.create(pedido);
    }

    public List<Pedido> traerPedido() {
        return Pjpa.findPedidoEntities();
    }

    // --- Métodos para traer todas las entidades (listados) ---
    public List<Cliente> traerTodosLosClientes() {
        return Cjpa.findClienteEntities();
    }
    
     // --- Métodos para la Edición (Implementados y corregidos) ---

    /**
     * Trae un Pedido específico por su ID.
     * *IMPORTANTE: EL PARÁMETRO 'idPedido' AHORA ES DE TIPO LONG.*
     * @param idPedido El ID del pedido a buscar.
     * @return El objeto Pedido si se encuentra, o null si no existe.
     */
    public Pedido traerPedido(Long idPedido) { // CAMBIADO DE 'int' A 'Long'
        // Delega la búsqueda al PedidoJpaController, que ahora debe aceptar Long
        return Pjpa.findPedido(idPedido);
    }

    /**
     * Modifica un Pedido existente en la base de datos.
     * @param pedido El objeto Pedido con los datos actualizados.
     */
    public void modificarPedido(Pedido pedido) {
        try {
            // Delega la modificación al PedidoJpaController
            Pjpa.edit(pedido);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Trae un Producto específico por su ID.
     * *IMPORTANTE: EL PARÁMETRO 'idProducto' AHORA ES DE TIPO LONG.*
     * @param idProducto El ID del producto a buscar.
     * @return El objeto Producto si se encuentra, o null si no existe.
     */
    public Producto traerProducto(Long idProducto) { // CAMBIADO DE 'int' A 'Long'
        // Delega la búsqueda al ProductoJpaController, que ahora debe aceptar Long
        return ProdJpa.findProducto(idProducto);
    }
    
    // ¡¡¡ELIMINA ESTE MÉTODO DUPLICADO E INCORRECTO!!!
    // public Pedido traerPedido(Long idPedido) {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }

    public void eliminarPedido(Long idPedido) {
  try {
            Pjpa.destroy(idPedido); // El método destroy del JpaController debe aceptar Long
        } catch (NonexistentEntityException ex) {
            // Manejo de la excepción si el pedido no existe
            // Puedes loggear el error o lanzar una excepción más específica
            System.out.println("Error: El pedido con ID " + idPedido + " no existe.");
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}


    
    

