package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import configuracion.Aplicacion;
import establecimiento.Establecimiento;

public class EstablecimientoServicio {

	public List<Establecimiento> obtenerEstablecimientos() {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();

		Query query = em.createQuery("SELECT e FROM Establecimiento e");
		List<Establecimiento> todosLosEstablecimientos = (List<Establecimiento>) query.getResultList();

		return todosLosEstablecimientos;
	}

	public void salvarEstablecimiento(Establecimiento establecimiento) {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(establecimiento);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}

	}
	
	public void salvarOActualizarEstablecimiento(Establecimiento establecimiento){
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(establecimiento);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		
	}

}
