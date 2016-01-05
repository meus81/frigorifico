package faena;

import org.junit.Assert;
import org.junit.Test;

import servicios.CategoriaServicioDatabase;
import servicios.TropaServicioDatabase;
import tropa.Categoria;
import tropa.Tropa;

public class FaenaTest {
	
	
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
		Faena faena = new Faena();
		faena.inicializarFaena();
		
		CategoriaServicioDatabase categoriaServicioDatabase = new CategoriaServicioDatabase();
		Categoria categoria = categoriaServicioDatabase.obtenerCategoria(1);
		faena.imprimirEtiqueta(215.20, categoria, true);
			
	}
	
	@Test
	public void finalizarFaenaTest(){
		
	}
	
	

}
