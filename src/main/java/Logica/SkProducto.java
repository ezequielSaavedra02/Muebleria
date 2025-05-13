
package Logica;

import java.util.Date;

/**
 *
 * @author axel
 */
public class SkProducto {
 
    
    private int id_skpro;
    private int id_producto;
    private Date fecha_mov;
    private String tipo_mov;
    private String cantidad;

    public SkProducto() {
    }

    public SkProducto(int id_skpro, int id_producto, Date fecha_mov, String tipo_mov, String cantidad) {
        this.id_skpro = id_skpro;
        this.id_producto = id_producto;
        this.fecha_mov = fecha_mov;
        this.tipo_mov = tipo_mov;
        this.cantidad = cantidad;
    }

    public int getId_skpro() {
        return id_skpro;
    }

    public void setId_skpro(int id_skpro) {
        this.id_skpro = id_skpro;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Date getFecha_mov() {
        return fecha_mov;
    }

    public void setFecha_mov(Date fecha_mov) {
        this.fecha_mov = fecha_mov;
    }

    public String getTipo_mov() {
        return tipo_mov;
    }

    public void setTipo_mov(String tipo_mov) {
        this.tipo_mov = tipo_mov;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
