package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import configuracion.Aplicacion;
import tropa.Tropa;

public class TropaServicioDatabase extends ServiciosDatabase{
	
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

}
