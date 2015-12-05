package servicios;

import org.junit.Assert;
import org.junit.Test;

import servicios.AnimalServicio;
import tropa.Animal;

public class AnimalServicioTest {
	
	@Test
	public void animalServicio (){
		Animal animal1 = new Animal();
		animal1.setGarron(12);
		animal1.setPeso(150);
		
		AnimalServicio as= new AnimalServicio();
		
		as.salvarAnimal(animal1);
		
		for (Animal a : as.obtenerAnimales()) {
			
			System.out.println("RESULTADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" + a.getGarron());
			System.out.println(animal1.getGarron());
			Assert.assertTrue(a.getGarron() == animal1.getGarron());
		}
		
	}

}
