package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import configuracion.Aplicacion;
import tropa.Procedencia;
import tropa.Tropa;
import tropa.TropaReservada;

public class TropaReservadaServicioDatabase extends ServiciosDatabase{

	public TropaReservada obtenerUltimoNroDeTropa(Procedencia procedencia){
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();

		Query query = em.createQuery("SELECT tr FROM TropaReservada tr where anio = YEAR(current_date()) and ");
		List<TropaReservada> tropas = (List<TropaReservada>)query.getResultList();
		TropaReservada tropa = tropas.get(0);
		if (ultimaTropa == null)
			ultimaTropa = 0L;
		return ultimaTropa;
	}
	
	public long obtenerSiguienteNroDeTropa(){
		return this.obtenerUltimoNroDeTropa() + 1;
	}
}
