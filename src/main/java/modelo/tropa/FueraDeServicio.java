package modelo.tropa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class FueraDeServicio extends EstadoCorral {

	@Override
	public String toString(){
		return "Fuera de Servicio";
	}
}
