/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Producto;

/**
 *
 * @author edeze_b1s78wk
 */
public class ControladoraPersistencia {
    ProductoJpaController proJpa = new ProductoJpaController();
    
    public void crearProducto (Producto producto){
        proJpa.create(producto);
    }
    
}
