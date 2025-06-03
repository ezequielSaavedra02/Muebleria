package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetalleProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleProducto;
    private int cantidadUtilizada;

    // Relación M:1 con Producto (muchos detalles de producto pertenecen a un producto)
    @ManyToOne
    @JoinColumn(name = "producto_id") // Columna de clave foránea en la tabla DetalleProducto
    private Producto producto;

    // Relación M:1 con MateriaPrima (muchos detalles de producto utilizan una materia prima)
    @ManyToOne
    @JoinColumn(name = "materia_prima_id") // Columna de clave foránea en la tabla DetalleProducto
    private MateriaPrima materiaPrima;

    public DetalleProducto() {
    }

    public DetalleProducto(Long idDetalleProducto, int cantidadUtilizada, Producto producto, MateriaPrima materiaPrima) {
        this.idDetalleProducto = idDetalleProducto;
        this.cantidadUtilizada = cantidadUtilizada;
        this.producto = producto;
        this.materiaPrima = materiaPrima;
    }

    // Getters y Setters
    public Long getIdDetalleProducto() {
        return idDetalleProducto;
    }

    public void setIdDetalleProducto(Long idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    public int getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public void setCantidadUtilizada(int cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }
}