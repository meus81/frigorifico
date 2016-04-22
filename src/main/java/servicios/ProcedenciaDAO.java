package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import configuracion.Aplicacion;
import modelo.tropa.Procedencia;

public class ProcedenciaDAO extends DAO {
		
	public Procedencia obtenerProcedencia(int id){
		return (Procedencia)this.obtener(Procedencia.class, id);
	}
	
	public List<Procedencia> obtenerProcedencias() {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();

		Query query = em.createQuery("SELECT p FROM Procedencia p");
		List<Procedencia> todasLasProcedencias = (List<Procedencia>) query.getResultList();

		return todasLasProcedencias;
	}
}
