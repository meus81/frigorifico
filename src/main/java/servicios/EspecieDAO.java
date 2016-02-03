package servicios;

import modelo.especie.Especie;

public class EspecieDAO extends DAO {

	public Especie obtenerEspecie(int id) {
		return (Especie) this.obtener(Especie.class, id);
	}
	
}
