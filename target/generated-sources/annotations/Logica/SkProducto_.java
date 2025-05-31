package Logica;

import Logica.Producto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-05-30T23:18:15")
@StaticMetamodel(SkProducto.class)
public class SkProducto_ { 

    public static volatile SingularAttribute<SkProducto, String> tipo_mov;
    public static volatile SingularAttribute<SkProducto, Producto> producto;
    public static volatile SingularAttribute<SkProducto, String> cantidad;
    public static volatile SingularAttribute<SkProducto, Integer> id_skpro;
    public static volatile SingularAttribute<SkProducto, Date> fecha_mov;

}