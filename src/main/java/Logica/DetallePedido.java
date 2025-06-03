package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetallePedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetallePedido;
    private int cantidad;
    private double subtotal;

    // Relación M:1 con Pedido (muchos detalles de pedido pertenecen a un pedido)
    @ManyToOne
    @JoinColumn(name = "pedido_id") // Columna de clave foránea en la tabla DetallePedido
    private Pedido pedido;

    // Relación M:1 con Producto (muchos detalles de pedido se refieren a un producto)
    @ManyToOne
    @JoinColumn(name = "producto_id") // Columna de clave foránea en la tabla DetallePedido
    private Producto producto;

    public DetallePedido() {
    }

    public DetallePedido(Long idDetallePedido, int cantidad, double subtotal, Pedido pedido, Producto producto) {
        this.idDetallePedido = idDetallePedido;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.pedido = pedido;
        this.producto = producto;
    }

    // Getters y Setters
    public Long getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Long idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}