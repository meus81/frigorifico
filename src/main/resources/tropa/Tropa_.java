package tropa;

import java.util.GregorianCalendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-10T16:15:07.914-0300")
@StaticMetamodel(Tropa.class)
public class Tropa_ {
	public static volatile SingularAttribute<Tropa, Integer> idTropa;
	public static volatile SingularAttribute<Tropa, Long> numeroTropa;
	public static volatile SingularAttribute<Tropa, GregorianCalendar> fechaIngreso;
	public static volatile SingularAttribute<Tropa, GregorianCalendar> fechaFaena;
	public static volatile SingularAttribute<Tropa, Integer> animalesRecibidos;
	public static volatile ListAttribute<Tropa, Animal> animales;
}
