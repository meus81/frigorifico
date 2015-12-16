package servicios;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import servicios.AnimalServicio;
import tropa.Animal;
import tropa.Categoria;
import tropa.Tropa;

public class AnimalServicioTest {
	
	private Categoria categoria= null;
	private Tropa tropa= null;
		
	@Before
	public void asignarCategoriaTropa(){
		CategoriaServicio cs= new CategoriaServicio();
		categoria= cs.obtenerCategoria();
	
		TropaServicio ts= new TropaServicio();
		for (Tropa t : ts.obtenerTropas()) {
			tropa = t;
			break;
		}
	
	}
	
		
	@Test
	public void animalServicio (){
		Animal animal1 = new Animal();
		animal1.setGarron(12);
		animal1.setPeso(150);
		animal1.setCategoria(categoria);
		
		List<Animal> animales= new ArrayList<Animal>();
		animales.add(animal1);
				
		tropa.setAnimales(animales);
		
		AnimalServicio as= new AnimalServicio();
		
		as.salvarAnimal(animal1);
		
		for (Animal a : as.obtenerAnimales()) {
			
			System.out.println("RESULTADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" + a.getGarron());
			System.out.println(animal1.getGarron());
			Assert.assertTrue(a.getGarron() == animal1.getGarron());
		}
		
	}

}
