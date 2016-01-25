package modelo.tropa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.especie.Especie;
import modelo.establecimiento.Establecimiento;

@Generated(value="Dali", date="2016-01-25T15:20:37.854-0300")
@StaticMetamodel(Tropa.class)
public class Tropa_ {
	public static volatile SingularAttribute<Tropa, Integer> idTropa;
	public static volatile SingularAttribute<Tropa, Long> numeroTropa;
	public static volatile SingularAttribute<Tropa, Date> fechaIngreso;
	public static volatile SingularAttribute<Tropa, Date> fechaFaena;
	public static volatile SingularAttribute<Tropa, Integer> animalesRecibidos;
	public static volatile ListAttribute<Tropa, Animal> animales;
	public static volatile SingularAttribute<Tropa, Establecimiento> establecimiento;
	public static volatile SingularAttribute<Tropa, Especie> especie;
}
