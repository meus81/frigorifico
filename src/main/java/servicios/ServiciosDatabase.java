package servicios;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import configuracion.Aplicacion;

public class ServiciosDatabase {

	public void salvar(Object anObject) {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(anObject);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void actualizar(Object anObject) {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(anObject);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public Object obtener(Class<?> entityClass, int primaryKey) {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		Object anObject = (Object) em.find(entityClass, primaryKey);
		return anObject;
	}

	public void eliminar() {

	}

	public int obtenerUltimoNumeroGarron(GregorianCalendar fecha) {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		Query query = em
				.createQuery("SELECT t.numeroTropa FROM Tropa t WHERE t.fechaFaena = :fecha")
				.setParameter("fecha", fecha, TemporalType.TIMESTAMP);
		
		Long ultimoGarron = (Long) query.getSingleResult();
		return ultimoGarron.intValue(); 
	}

}
