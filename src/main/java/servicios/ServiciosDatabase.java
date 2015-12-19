package servicios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import configuracion.Aplicacion;
import tropa.Tropa;

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
		
		Query query1 = em.createQuery("select t from Tropa t");
		ArrayList<Tropa> lista = (ArrayList<Tropa>) query1.getResultList();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		for (Tropa tropa : lista) {
			System.out.println("Fecha de faena: " + tropa.getFechaFaena());
			fmt.setCalendar(tropa.getFechaFaena());
		    String fechaFormateadaBBDD = fmt.format(tropa.getFechaFaena().getTime());

			System.out.println("Fecha faena formateada: " + fechaFormateadaBBDD);
			
			System.out.println("Comparacion con equals: "+ tropa.getFechaFaena().equals(fecha));
			System.out.println("Comparacion con compareTo: "+ tropa.getFechaFaena().compareTo(fecha));
		}
		
		fmt.setCalendar(fecha);
	    String fechaFormateadaParametro = fmt.format(fecha.getTime());
	
		Query query = em
				.createQuery("SELECT max(a.garron) FROM Tropa t inner join t.animales a where to_char(t.fechaFaena, 'yyyy-MM-dd') = :fecha")
				.setParameter("fecha", fechaFormateadaParametro);
		int ultimoGarron = (Integer) query.getSingleResult();
		return ultimoGarron; 
	}

}
