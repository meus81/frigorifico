package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import configuracion.Aplicacion;
import tropa.Procedencia;
import tropa.Tropa;
import tropa.TropaReservada;

public class TropaReservadaServicioDatabase extends ServiciosDatabase{

	public TropaReservada obtenerUltimoNroDeTropa(Procedencia procedencia){
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TropaReservada> q = cb.createQuery(TropaReservada.class); 
		Root<TropaReservada> tr = q.from(TropaReservada.class);
		
		Expression<java.sql.Date> date = cb.currentDate();
		Expression<Integer> aYear = cb.function("year", Integer.class, date);
		q.select(tr).where(
				cb.and(
						cb.equal(tr.get("anio"), aYear),
						cb.equal(tr.get("procedencia"), procedencia)
					  )
				);
		TypedQuery<TropaReservada> query = em.createQuery(q);
		List<TropaReservada> tropas = query.getResultList();
		TropaReservada tropaReservadaResultado = null;
		if (tropas.size() == 0){
			//ERROR
		}else{
			tropaReservadaResultado = tropas.get(0);
		}
		return tropaReservadaResultado;
	}
	
	public TropaReservada obtenerSiguienteNroDeTropa(Procedencia procedencia){
		//TODO cuando grabamos que dimos el ultimo nro de tropa???
		TropaReservada tropaReservada = this.obtenerUltimoNroDeTropa(procedencia);
		tropaReservada.obtenerSiguienteNroDeTropa();
		return tropaReservada;
	}
}
