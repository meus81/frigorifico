package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import configuracion.Aplicacion;
import modelo.tropa.Procedencia;
import modelo.tropa.TropaReservada;

public class TropaReservadaDAO extends DAO {

	public TropaReservada obtenerTropaReservadaPorProcedenciaYanioActual(Procedencia procedencia) {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TropaReservada> q = cb.createQuery(TropaReservada.class);
		Root<TropaReservada> tr = q.from(TropaReservada.class);

		Expression<java.sql.Date> date = cb.currentDate();
		Expression<Integer> aYear = cb.function("year", Integer.class, date);
		q.select(tr).where(cb.and(cb.equal(tr.get("anio"), aYear), cb.equal(tr.get("procedencia"), procedencia)));
		TypedQuery<TropaReservada> query = em.createQuery(q);
		List<TropaReservada> tropas = query.getResultList();
		TropaReservada tropaReservadaResultado = null;
		if (tropas.size() == 0) {
			// ERROR
		} else {
			tropaReservadaResultado = tropas.get(0);
			System.out.println("TROPA RESULTADO POR PRCEDENCIA============" + tropaReservadaResultado.getAnio() + 
			"DESDE: " + tropaReservadaResultado.getDesde() + "Hasta: " + tropaReservadaResultado.getHasta() + 
			" Ultima tropaaaaa " + tropaReservadaResultado.getUltimaTropa() );
		}
		return tropaReservadaResultado;
	}
}
