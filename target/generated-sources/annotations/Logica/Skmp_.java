package Logica;

import Logica.MateriaPrima;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-05-30T23:18:15")
@StaticMetamodel(Skmp.class)
public class Skmp_ { 

    public static volatile SingularAttribute<Skmp, Integer> id_kmp;
    public static volatile SingularAttribute<Skmp, String> tipo_mov;
    public static volatile SingularAttribute<Skmp, Integer> cantidad;
    public static volatile SingularAttribute<Skmp, Date> fecha_mov;
    public static volatile SingularAttribute<Skmp, MateriaPrima> materiaPrima;

}