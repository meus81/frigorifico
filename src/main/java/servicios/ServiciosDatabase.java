package servicios;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	public int obtenerUltimoNumeroGarron(Calendar fecha) {
		System.out.println("La fecha para buscar es: " + fecha.getTime());
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		Query query = em
				.createQuery("SELECT max(a.garron) FROM Tropa t inner join t.animales a where t.fechaFaena = :fecha")
				.setParameter("fecha", fecha);
		int ultimoGarron = (Integer) query.getSingleResult();
		return ultimoGarron;
	}

}
