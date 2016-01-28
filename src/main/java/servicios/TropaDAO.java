package servicios;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import configuracion.Aplicacion;
import modelo.tropa.Tropa;

public class TropaDAO extends DAO{
	
	public List<Tropa> obtenerTropas() {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();

		Query query = em.createQuery("SELECT t FROM Tropa t");
		List<Tropa> todasLasTropas = (List<Tropa>) query.getResultList();

		return todasLasTropas;
	}

	public void salvarTropa(Tropa tropa) {
		this.salvar(tropa);
	}
	
	public Tropa obtenerTropa(int id){
		return (Tropa) this.obtener(Tropa.class, id);
	}
	
	public Tropa obtenerTropaPorNroTropa(int nroTropa){
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		
		Query query = em.createQuery("SELECT t FROM Tropa t WHERE t.numeroTropa = :nroTropa")
				.setParameter("nroTropa", nroTropa);
	
		Tropa tropa = (Tropa) query.getResultList().get(0);
		return tropa;
	}
	
	public int obtenerUltimoGarronDeUnDiaDeterminado(GregorianCalendar fecha){
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		GregorianCalendar fecha1 = new GregorianCalendar();
		fecha1.set(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE));
		fecha1.set(Calendar.HOUR_OF_DAY, 0);
		fecha1.set(Calendar.MINUTE, 0);
		fecha1.set(Calendar.SECOND, 0);		
		fecha1.set(Calendar.MILLISECOND, 0);	
		GregorianCalendar fecha2 = new GregorianCalendar();
		fecha2.set(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE));
		fecha2.set(Calendar.HOUR_OF_DAY, 23);
		fecha2.set(Calendar.MINUTE, 59);		
		fecha2.set(Calendar.SECOND, 59);
		fecha2.set(Calendar.MILLISECOND, 1000);
		Query query = em
				.createQuery(
						"SELECT max(a.garron) FROM Tropa t inner join t.animales a where t.fechaFaena Between :fecha1 and :fecha2")
				.setParameter("fecha1", fecha1.getTime()).setParameter("fecha2", fecha2.getTime());
		int ultimoGarron;
		try {
			ultimoGarron = (Integer) query.getSingleResult();
		} catch (NullPointerException nre) {
			ultimoGarron = 0;
		}

		return ultimoGarron;
	}
	
	public int obtenerUltimoNumeroGarronDelDia() {
		return this.obtenerUltimoGarronDeUnDiaDeterminado(new GregorianCalendar());
	}
	
	public int obtenerSiguienteNumeroDeGarron() {
		return this.obtenerUltimoNumeroGarronDelDia() + 1;
	}
}
