package servicios;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import servicios.AnimalServicioDatabase;
import tropa.Animal;
import tropa.Categoria;
import tropa.Tropa;

public class AnimalServicioTest {
	
	private Categoria categoria= null;
	private Tropa tropa= null;
		
	@Before
	public void asignarCategoriaTropa(){
		CategoriaServicioDatabase cs= new CategoriaServicioDatabase();
		categoria= cs.obtenerCategoria(1);
	
		TropaServicioDatabase ts= new TropaServicioDatabase();
		for (Tropa t : ts.obtenerTropas()) {
			tropa = t;
			break;
		}
	
	}
	
		
	@Test
	public void animalServicio (){
		Animal animal1 = new Animal();
		animal1.setGarron(14);
		animal1.setPeso(200);
		animal1.setCategoria(categoria);
		
		List<Animal> animales= new ArrayList<Animal>();
		animales.add(animal1);
				
		tropa.setAnimales(animales);
		
		AnimalServicioDatabase as= new AnimalServicioDatabase();
		
		as.salvarAnimal(animal1);
		
		for (Animal a : as.obtenerAnimales()) {
			
			System.out.println("RESULTADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" + a.getGarron());
			System.out.println(animal1.getGarron());
			Assert.assertTrue("El numero de garron es distinto del animal recien salvado al obtenido desde la bbdd", a.getGarron() == animal1.getGarron());
		}
		
	}

}
