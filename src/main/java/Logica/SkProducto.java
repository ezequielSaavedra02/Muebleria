
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author axel
 */
@Entity
public class SkProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_skpro;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Temporal(TemporalType.DATE)
    private Date fecha_mov;

    private String tipo_mov;
    private String cantidad;

    public SkProducto() {
    }

    public SkProducto(int id_skpro, Producto producto, Date fecha_mov, String tipo_mov, String cantidad) {
        this.id_skpro = id_skpro;
        this.producto = producto;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
