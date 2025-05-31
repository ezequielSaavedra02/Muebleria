
package Logica;

import Persistencia.ControladoraPersistencia;

/**
 *
 * @author axel
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearProdcuto (Producto producto){
        controlPersis.crearProducto(producto);
    }
    
    
    
    
    
    
    
    
    
}
