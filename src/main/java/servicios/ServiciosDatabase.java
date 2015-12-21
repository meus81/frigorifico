package servicios;

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

	public int obtenerUltimoNumeroGarron(Date fecha, Date fecha2) {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		Query query = em
				.createQuery("SELECT max(a.garron) FROM Tropa t inner join t.animales a where t.fechaFaena Between :fecha and :fecha2")
				.setParameter("fecha", fecha)
				.setParameter("fecha2", fecha2);
		
		int ultimoGarron = (Integer) query.getSingleResult();
		return ultimoGarron; 
	}

}
