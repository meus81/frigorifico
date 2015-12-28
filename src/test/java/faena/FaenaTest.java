package faena;

import org.junit.Assert;
import org.junit.Test;

import servicios.TropaServicioDatabase;
import tropa.Tropa;

public class FaenaTest {
	@Test
	public void inicializarFaenaTest(){
		Faena faena = new Faena();
		faena.inicializarFaena();
		Tropa tropaFaena = faena.getTropa();
		
		TropaServicioDatabase ts= new TropaServicioDatabase();
		long ultimaTropaBase = ts.obtenerUltimoNroDeTropa();
		
		Assert.assertEquals("La nueva tropa no coincide con el ultimo numero de tropa + 1!!!!!!!!!!", tropaFaena.getNumeroTropa(), ultimaTropaBase);
		
		
		
	}
	
	@Test 
	public void imprimirEtiquetaTest(){
		
	}
	
	@Test
	public void finalizarFaenaTest(){
		
	}
	
	

}
