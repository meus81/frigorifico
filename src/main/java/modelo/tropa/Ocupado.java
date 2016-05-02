package modelo.tropa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Ocupado extends EstadoCorral {

	@Override
	public String toString(){
		return "Ocupado";
	}
}
