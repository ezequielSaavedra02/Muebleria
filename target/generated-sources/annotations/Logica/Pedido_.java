package Logica;

import Logica.Cliente;
import Logica.Producto;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-06-02T20:48:11")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Cliente> cliente;
    public static volatile SingularAttribute<Pedido, Double> total;
    public static volatile SingularAttribute<Pedido, LocalDate> fechaPedido;
    public static volatile SingularAttribute<Pedido, Integer> cantidad;
    public static volatile SingularAttribute<Pedido, Producto> producto;
    public static volatile SingularAttribute<Pedido, Long> idPedido;

}