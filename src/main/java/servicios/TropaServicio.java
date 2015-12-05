package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import configuracion.Aplicacion;
import tropa.Tropa;

public class TropaServicio {
	
	public List<Tropa> obtenerTropas() {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();

		Query query = em.createQuery("SELECT t FROM Tropa t");
		List<Tropa> todasLasTropas = (List<Tropa>) query.getResultList();

		return todasLasTropas;
	}

	public void salvarTropa(Tropa tropa) {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(tropa);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}

	}

}
