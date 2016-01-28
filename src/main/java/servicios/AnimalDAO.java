package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import configuracion.Aplicacion;
import modelo.tropa.Animal;
import modelo.tropa.Tropa;
import modelo.tropa.TropaReservada;

public class AnimalDAO extends DAO{

	public List<Animal> obtenerAnimales(){
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		
		Query query = em.createQuery("SELECT a FROM Animal a");
		List<Animal> todosLosAnimales = (List<Animal>) query.getResultList();
		
		return todosLosAnimales;
	}
	
	public void salvarAnimal(Animal animal){
		this.salvar(animal);
	}

	public Animal obtenerAnimalPorTropa(Tropa tropa) {
		//TODO: cambiar este metodo a obtener animaleSSSS por tropa y devolcer la lista de animales 
		Aplicacion ap = Aplicacion.getInstance();
		EntityManager em = ap.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Animal> q = cb.createQuery(Animal.class); 
		Root<Animal> ar = q.from(Animal.class);
		
		q.select(ar).where(
						cb.equal(ar.get("tropa"), tropa)
				);
		TypedQuery<Animal> query = em.createQuery(q);
		List<Animal> animales = query.getResultList();
		Animal animalResultado=null;
		if (animales.size() == 0){
			//avisar que no se encontro ese animal
		}else{
			animalResultado = animales.get(0);
		}
		return animalResultado;
	}
	
	
}
