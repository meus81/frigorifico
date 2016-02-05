package jaxrsBeans;

import java.util.ArrayList;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-05T17:05:26.365-0300")
@StaticMetamodel(TropaJaxrsBean.class)
public class TropaJaxrsBean_ {
	public static volatile SingularAttribute<TropaJaxrsBean, Integer> idTropa;
	public static volatile SingularAttribute<TropaJaxrsBean, Integer> numeroTropa;
	public static volatile SingularAttribute<TropaJaxrsBean, Date> fechaIngreso;
	public static volatile SingularAttribute<TropaJaxrsBean, Date> fechaFaena;
	public static volatile SingularAttribute<TropaJaxrsBean, Integer> animalesRecibidos;
	public static volatile SingularAttribute<TropaJaxrsBean, Integer> idEstablecimiento;
	public static volatile SingularAttribute<TropaJaxrsBean, Integer> idEspecie;
	public static volatile SingularAttribute<TropaJaxrsBean, Integer> idDte;
	public static volatile SingularAttribute<TropaJaxrsBean, ArrayList> idCorrales;
}
