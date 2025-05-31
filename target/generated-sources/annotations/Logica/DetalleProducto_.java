package Logica;

import Logica.MateriaPrima;
import Logica.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-05-30T23:18:15")
@StaticMetamodel(DetalleProducto.class)
public class DetalleProducto_ { 

    public static volatile SingularAttribute<DetalleProducto, Integer> id_detalle;
    public static volatile SingularAttribute<DetalleProducto, Producto> producto;
    public static volatile SingularAttribute<DetalleProducto, Integer> cantidad;
    public static volatile SingularAttribute<DetalleProducto, MateriaPrima> materiaPrima;

}