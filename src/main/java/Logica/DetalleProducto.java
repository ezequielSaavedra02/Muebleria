
package Logica;

/**
 *
 * @author axel
 */
public class DetalleProducto {

private int id_detalle; 
private int id_producto;
private int id_mp;
private int cantidad;

    public DetalleProducto() {
    }

    public DetalleProducto(int id_detalle, int id_producto, int id_mp, int cantidad) {
        this.id_detalle = id_detalle;
        this.id_producto = id_producto;
        this.id_mp = id_mp;
        this.cantidad = cantidad;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_mp() {
        return id_mp;
    }

    public void setId_mp(int id_mp) {
        this.id_mp = id_mp;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
