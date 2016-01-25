package servicios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.tropa.Animal;
import modelo.tropa.Categoria;
import modelo.tropa.Tropa;

public class AnimalDAOTest {

	private Tropa tropa = null;

	@Before
	public void asignarCategoriaTropa() {
		TropaDAO tropaDAO = new TropaDAO();
		tropa = tropaDAO.obtenerTropaPorNroTropa(27);
	}

	@Test
	public void salvatYobtenerAnimalDAOTest() {
		
		//TODO: ESTE TEST ANDA MAL
		//NO GUARDA LOS ANIMALES CON EL NUMERO DE GARRON INCREMENTADO MIRAR CONSULTA
		//QUEDA VERIFICAR FAENA TEST Y ULTIMO GARRON TEST
		
		CategoriaDAO cs = new CategoriaDAO();
		Categoria categoria = cs.obtenerCategoria(2);

		TropaDAO tropaDAO = new TropaDAO();

		Animal animal1 = new Animal();
		animal1.setGarron(tropaDAO.obtenerSiguienteNumeroDeGarron());
		animal1.setPeso(150);
		animal1.setCategoria(categoria);
		animal1.setTropa(tropa);

		// List<Animal> animales= new ArrayList<Animal>();
		// animales.add(animal1);
		//
		// tropa.setAnimales(animales);

		AnimalDAO animalDAO = new AnimalDAO();
		animalDAO.salvarAnimal(animal1);

		Animal animalBBDD = animalDAO.obtenerAnimalPorTropa(tropa);

		Assert.assertEquals("El numero de garron NO COINCIDEEEEE!!!!", animal1.getGarron(), animalBBDD.getGarron());

	}

}
