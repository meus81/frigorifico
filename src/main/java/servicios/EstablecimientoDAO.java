package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import configuracion.Aplicacion;
import modelo.establecimiento.Establecimiento;

public class EstablecimientoDAO extends DAO{

	public List<Establecimiento> obtenerEstablecimientos() {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();

		Query query = em.createQuery("SELECT e FROM Establecimiento e");
		List<Establecimiento> todosLosEstablecimientos = (List<Establecimiento>) query.getResultList();

		return todosLosEstablecimientos;
	}

	public void salvarEstablecimiento(Establecimiento establecimiento) {
		this.salvar(establecimiento);
	}
	
	public void actualizarEstablecimiento(Establecimiento establecimiento){
		this.actualizar(establecimiento);
	}

	public Establecimiento obtenerEstablecimiento(int id){
		return (Establecimiento)this.obtener(Establecimiento.class, id);
	}
}
