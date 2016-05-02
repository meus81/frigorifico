package modelo.tropa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-04-28T15:40:45.796-0300")
@StaticMetamodel(TropaCorral.class)
public class TropaCorral_ {
	public static volatile SingularAttribute<TropaCorral, Integer> tropa_id_tropa;
	public static volatile SingularAttribute<TropaCorral, Integer> corral_id_corral;
	public static volatile SingularAttribute<TropaCorral, Integer> ocupacion;
	public static volatile SingularAttribute<TropaCorral, Date> fechaEgreso;
	public static volatile SingularAttribute<TropaCorral, Tropa> tropa;
	public static volatile SingularAttribute<TropaCorral, Corral> corral;
}
