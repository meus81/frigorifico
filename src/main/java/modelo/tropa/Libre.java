package modelo.tropa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Libre extends EstadoCorral {

	@Override
	public boolean puedeGuardarAnimales() {
		return true;
	};
	
	@Override
	public String toString(){
		return "Libre";
	}
}
