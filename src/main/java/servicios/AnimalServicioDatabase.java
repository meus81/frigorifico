package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import configuracion.Aplicacion;
import tropa.Animal;

public class AnimalServicioDatabase extends ServiciosDatabase{

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
	
	
}
