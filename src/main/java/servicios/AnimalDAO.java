package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import configuracion.Aplicacion;
import modelo.tropa.Animal;
import modelo.tropa.Tropa;

public class AnimalDAO extends DAO {

	public List<Animal> obtenerTodoLosAnimales() {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();

		Query query = em.createQuery("SELECT a FROM Animal a");
		List<Animal> todosLosAnimales = (List<Animal>) query.getResultList();

		return todosLosAnimales;
	}

	public void salvarAnimal(Animal animal) {
		this.salvar(animal);
	}

	public List<Animal> obtenerAnimalesPorTropa(Tropa tropa) {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Animal> q = cb.createQuery(Animal.class);
		Root<Animal> ar = q.from(Animal.class);

		q.select(ar).where(cb.equal(ar.get("tropa"), tropa));
		TypedQuery<Animal> query = em.createQuery(q);
		List<Animal> animales = query.getResultList();
		return animales;
	}

	public Animal obtenerAnimalPorTropaYGarron(Tropa tropa, int garron) {
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Animal> q = cb.createQuery(Animal.class);
		Root<Animal> animalRoot = q.from(Animal.class);

		q.select(animalRoot)
				.where(cb.and(cb.equal(animalRoot.get("tropa"), tropa), cb.equal(animalRoot.get("garron"), garron)));
		TypedQuery<Animal> query = em.createQuery(q);
		List<Animal> animales = query.getResultList();
		Animal animalResultado = null;
		if (animales.size() == 0) {
			// avisar que no se encontro ese animal
		} else {
			animalResultado = animales.get(0);
		}
		return animalResultado;
	}
}
