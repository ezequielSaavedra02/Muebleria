package Logica;

import Logica.Pedido;
import Logica.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-06-02T20:48:11")
@StaticMetamodel(DetallePedido.class)
public class DetallePedido_ { 

    public static volatile SingularAttribute<DetallePedido, Double> subtotal;
    public static volatile SingularAttribute<DetallePedido, Pedido> pedido;
    public static volatile SingularAttribute<DetallePedido, Integer> cantidad;
    public static volatile SingularAttribute<DetallePedido, Producto> producto;
    public static volatile SingularAttribute<DetallePedido, Long> idDetallePedido;

}