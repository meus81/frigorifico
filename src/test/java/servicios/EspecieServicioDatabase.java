package servicios;

import especie.Especie;

public class EspecieServicioDatabase extends ServiciosDatabase {

	public Especie obtenerEspecie(int i) {
		return (Especie) this.obtener(Especie.class, 1);
	}
	
}
