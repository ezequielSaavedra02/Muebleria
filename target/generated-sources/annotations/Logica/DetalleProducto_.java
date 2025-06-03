package Logica;

import Logica.MateriaPrima;
import Logica.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-06-02T20:48:11")
@StaticMetamodel(DetalleProducto.class)
public class DetalleProducto_ { 

    public static volatile SingularAttribute<DetalleProducto, Long> idDetalleProducto;
    public static volatile SingularAttribute<DetalleProducto, Integer> cantidadUtilizada;
    public static volatile SingularAttribute<DetalleProducto, Producto> producto;
    public static volatile SingularAttribute<DetalleProducto, MateriaPrima> materiaPrima;

}