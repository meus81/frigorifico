package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import configuracion.Aplicacion;
import modelo.especie.Especie;

public class EspecieDAO extends DAO {

	public Especie obtenerEspecie(int id) {
		return (Especie) this.obtener(Especie.class, id);
	}

	public List<Especie> obtenerEspecies() {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();

		Query query = em.createQuery("SELECT e FROM Especie e");
		List<Especie> todasLasEspecies = (List<Especie>) query.getResultList();

		return todasLasEspecies;
	}
	
}
