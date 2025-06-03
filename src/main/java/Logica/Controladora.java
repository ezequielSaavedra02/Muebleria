/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author edeze_b1s78wk
 */
public class Controladora {
     ControladoraPersistencia controlPersis = new ControladoraPersistencia();
     ControladoraPersistencia cp = new ControladoraPersistencia();

     
     public void crearMateriaPrima(MateriaPrima materia) {
        controlPersis.crearMateriaPrima(materia);
    }
     
     public List<MateriaPrima> traerMateriasPrimas() {
        return controlPersis.traerMateriasPrimas();
    }
     
    public MateriaPrima traerMateriaPrima(int id) {
        return controlPersis.traerMateriaPrima(id);
    }

    public void editarMateriaPrima(MateriaPrima m) {
        controlPersis.editarMateriaPrima(m);
    }
    
    public MateriaPrima buscarMateriaPorNombre(String nombre) {
        return controlPersis.buscarMateriaPorNombre(nombre);
    }
    
    public void modificarMateriaPrima(MateriaPrima materia) {
    controlPersis.modificarMateriaPrima(materia);
}
    
    public void eliminarMateriaPrima(Long idMateriaPrima) {
    controlPersis.eliminarMateriaPrima(idMateriaPrima);
}



    public void crearProducto(Producto p) {
        controlPersis.crearProducto(p);
    }

    public void crearDetalleProducto(DetalleProducto dp) {
        controlPersis.crearDetalleProducto(dp);
    }
    
    public Producto buscarProductoPorNombre(String nombre) {
    return controlPersis.buscarProductoPorNombre(nombre);
}
    
    // Obtener producto por id para edición
    public Producto obtenerProducto(Long idProducto) {
        return controlPersis.buscarProducto(idProducto);
    }

    // Actualizar producto con nuevos datos
    public void actualizarProducto(Producto producto) {
        controlPersis.editarProducto(producto);
    }
    
    public void eliminarProducto(Long idProducto) {
    controlPersis.eliminarProducto(idProducto);
}

    
    public List<DetalleProducto> traerDetalleProductos() {
    return controlPersis.traerDetalleProductos();
}

    public List<Producto> traerProductos() {
        return controlPersis.traerProductos();
    }
    
    
    // --- MÉTODOS DE CLIENTE ---
    public void crearCliente(Cliente clien){
        cp.crearCliente(clien);
    }

    public List<Cliente> traerCliente() {
        return cp.traerCliente();
    }

    // Asegúrate de que el ID del Cliente sea 'int' en tu entidad si mantienes este método así.
    public Cliente traerCliente(Long id) { 
        return cp.traerCliente(id);
    }

    public void modificarCliente(Cliente cliente) {
        cp.modificarCliente(cliente);
    }

    public void eliminarCliente(int idCliente) {
        cp.eliminarCliente(idCliente);
    }
    
    // --- MÉTODOS DE PEDIDOS ---
    public List<Pedido> traerPedidos() {
        return cp.traerPedido();
    }

    public void crearPedido(Pedido pedido) {
        cp.crearPedido(pedido);
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> traerClientes() {
        return cp.traerTodosLosClientes();
    }
    
     // --- MÉTODOS MODIFICADOS PARA LA EDICIÓN DE PEDIDOS ---

    /**
     * Trae un Pedido específico por su ID desde la capa de persistencia.
     * *IMPORTANTE: EL PARÁMETRO 'idPedido' AHORA ES DE TIPO LONG.*
     * Necesario para cargar los datos del pedido en el formulario de edición.
     * @param idPedido El ID del pedido a buscar.
     * @return El objeto Pedido si se encuentra, o null si no existe.
     */
    public Pedido traerPedido(Long idPedido) { // CAMBIADO DE 'int' A 'Long'
        // Llama al método correspondiente en ControladoraPersistencia, que también debe aceptar Long
        return cp.traerPedido(idPedido);
    }

    /**
     * Modifica un Pedido existente en la base de datos a través de la capa de persistencia.
     * @param pedido El objeto Pedido con los datos actualizados.
     */
    public void modificarPedido(Pedido pedido) {
        cp.modificarPedido(pedido);
    }

    /**
     * Trae un Producto específico por su ID desde la capa de persistencia.
     * *IMPORTANTE: EL PARÁMETRO 'idProducto' AHORA ES DE TIPO LONG.*
     * Este método es útil si necesitas obtener un objeto Producto individualmente.
     * @param idProducto El ID del producto a buscar.
     * @return El objeto Producto si se encuentra, o null si no existe.
     */
    public Producto traerProducto(Long idProducto) { // CAMBIADO DE 'int' A 'Long'
        return cp.traerProducto(idProducto);
    }
    // ELIMINA EL MÉTODO DUPLICADO E INCORRECTO:
    // public Pedido traerPedido(Long idEditar) {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }

    public void eliminarPedido(Long idPedido) {
          cp.eliminarPedido(idPedido);
    }
    
    
    
}
