package servicios;

import javax.persistence.EntityManager;
import configuracion.Aplicacion;
import tropa.Categoria;

public class CategoriaServicio {

	public Categoria obtenerCategoria() {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();

		Categoria categoria = (Categoria) em.createQuery("SELECT c FROM Categoria c where c.idCategoria = :cat")
				.setParameter("cat", 1).getSingleResult();

		return categoria;
	}

}
