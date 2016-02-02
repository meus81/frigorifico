package modelo.tropa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-01T16:14:59.673-0300")
@StaticMetamodel(Animal.class)
public class Animal_ {
	public static volatile SingularAttribute<Animal, Integer> idAnimal;
	public static volatile SingularAttribute<Animal, Integer> garron;
	public static volatile SingularAttribute<Animal, Double> peso;
	public static volatile SingularAttribute<Animal, Categoria> categoria;
	public static volatile SingularAttribute<Animal, Tropa> tropa;
}
