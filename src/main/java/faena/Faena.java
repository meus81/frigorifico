package faena;

import java.util.GregorianCalendar;

import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.type.YesNoType;

import servicios.TropaServicioDatabase;
import tropa.Animal;
import tropa.Categoria;
import tropa.Tropa;

public class Faena {
	
	private Tropa tropa;
	private int numeroDeGarron;
	private TropaServicioDatabase tropaServicio = new TropaServicioDatabase();

	public void inicializarTropa(){
		long numeroTropa= tropaServicio.obtenerSiguienteNroDeTropa();
		tropa = new Tropa();
		
		tropa.setFechaFaena(new GregorianCalendar());
		tropa.setNumeroTropa(numeroTropa);
		
		tropaServicio.salvarTropa(tropa);
		numeroDeGarron = obtenerNumeroGarronPorDia();
		
	}
	
	public void imprimirEtiqueta(double peso, Categoria categoria, boolean cabezaAlMedio){
		Animal animal = new Animal();
		animal.setCategoria(categoria);
		animal.setPeso(peso);
		animal.setGarron(numeroDeGarron);
		numeroDeGarron++;
		
		tropa.agregarAnimal(animal);
		tropaServicio.actualizar(tropa);
		
		Etiqueta etiqueta = new Etiqueta();
		etiqueta.imprimirEtiquetas(animal, cabezaAlMedio);
	}
	
	
	public void finalizarTropa(){
		
	}
	
	public int obtenerNumeroGarronPorDia(){
		throw new NotYetImplementedException();
	}
}
