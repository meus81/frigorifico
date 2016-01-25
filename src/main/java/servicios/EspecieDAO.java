package servicios;

import modelo.especie.Especie;

public class EspecieDAO extends DAO {

	public Especie obtenerEspecie(int i) {
		return (Especie) this.obtener(Especie.class, 1);
	}
	
}
