package modelo.tropa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.especie.Especie;
import modelo.establecimiento.Establecimiento;

@Generated(value="Dali", date="2016-02-05T16:59:48.386-0300")
@StaticMetamodel(Tropa1.class)
public class Tropa1_ {
	public static volatile SingularAttribute<Tropa1, Integer> idTropa;
	public static volatile SingularAttribute<Tropa1, Integer> numeroTropa;
	public static volatile SingularAttribute<Tropa1, Date> fechaIngreso;
	public static volatile SingularAttribute<Tropa1, Date> fechaFaena;
	public static volatile SingularAttribute<Tropa1, Integer> animalesRecibidos;
	public static volatile SingularAttribute<Tropa1, Establecimiento> establecimiento;
	public static volatile SingularAttribute<Tropa1, Especie> especie;
}
