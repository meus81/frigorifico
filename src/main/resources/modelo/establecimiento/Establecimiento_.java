package modelo.establecimiento;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.tropa.Tropa;

@Generated(value="Dali", date="2016-02-01T16:14:59.672-0300")
@StaticMetamodel(Establecimiento.class)
public class Establecimiento_ {
	public static volatile SingularAttribute<Establecimiento, Integer> idEstablecimiento;
	public static volatile SingularAttribute<Establecimiento, String> codigoEstablecimiento;
	public static volatile SingularAttribute<Establecimiento, String> titular;
	public static volatile SingularAttribute<Establecimiento, String> nombre;
	public static volatile SingularAttribute<Establecimiento, Long> cuit;
	public static volatile SingularAttribute<Establecimiento, Integer> numeroHabilitacion;
	public static volatile SingularAttribute<Establecimiento, String> telefono;
	public static volatile SingularAttribute<Establecimiento, String> direccion;
	public static volatile SingularAttribute<Establecimiento, String> localidad;
	public static volatile SingularAttribute<Establecimiento, String> provincia;
	public static volatile ListAttribute<Establecimiento, Tropa> tropas;
}
