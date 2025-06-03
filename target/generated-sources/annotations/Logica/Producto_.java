package Logica;

import Logica.DetalleProducto;
import Logica.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-06-02T20:48:11")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile ListAttribute<Producto, DetalleProducto> componentes;
    public static volatile SingularAttribute<Producto, Double> precioUnitario;
    public static volatile SingularAttribute<Producto, Long> idProducto;
    public static volatile ListAttribute<Producto, Pedido> pedidos;
    public static volatile SingularAttribute<Producto, Integer> stock;
    public static volatile SingularAttribute<Producto, String> nombre;

}