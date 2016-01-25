package modelo.tropa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-25T15:20:37.854-0300")
@StaticMetamodel(TropaReservada.class)
public class TropaReservada_ {
	public static volatile SingularAttribute<TropaReservada, Integer> idTropaReservada;
	public static volatile SingularAttribute<TropaReservada, Integer> ultimaTropa;
	public static volatile SingularAttribute<TropaReservada, Integer> desde;
	public static volatile SingularAttribute<TropaReservada, Integer> hasta;
	public static volatile SingularAttribute<TropaReservada, Integer> anio;
	public static volatile SingularAttribute<TropaReservada, Procedencia> procedencia;
}
