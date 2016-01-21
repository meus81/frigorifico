package faena;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import servicios.CategoriaServicioDatabase;
import servicios.ProcedenciaServicioDatabase;
import servicios.TropaReservadaServicioDatabase;
import servicios.TropaServicioDatabase;
import tropa.Categoria;
import tropa.Procedencia;
import tropa.Tropa;
import tropa.TropaReservada;

public class FaenaTest {
	
	@Test
	public void inicializarFaenaTest(){
		
		Faena faena = new Faena();
		
		ProcedenciaServicioDatabase procedenciaServicio = new ProcedenciaServicioDatabase();
		Procedencia procedencia = procedenciaServicio.obtenerProcedencia(1); 

		TropaReservadaServicioDatabase tropaReservadaServicio = new TropaReservadaServicioDatabase();
		TropaReservada tropaReservada = tropaReservadaServicio.obtenerUltimoNroDeTropa(procedencia);
		int anteriorNumeroTropa = tropaReservada.getUltimaTropa();
		faena.inicializarFaena(procedencia);
		tropaReservada = tropaReservadaServicio.obtenerUltimoNroDeTropa(procedencia);
		int nuevoNumeroTropa = tropaReservada.getUltimaTropa();
	}
	
	@Test 
	public void imprimirEtiquetaTest(){
		/*Cual es la intencion de este test?
		 * Probar que se imprimin las etiquetas
		 * Pensar como hacer eso de mejor manera
		 * 
		 */
		
		Faena faena = new Faena();
		
		ProcedenciaServicioDatabase procedenciaServicio = new ProcedenciaServicioDatabase();
		Procedencia procedencia = procedenciaServicio.obtenerProcedencia(1); 
		faena.inicializarFaena(procedencia);
		
		CategoriaServicioDatabase categoriaServicioDatabase = new CategoriaServicioDatabase();
		Categoria categoria = categoriaServicioDatabase.obtenerCategoria(1);
		faena.imprimirEtiqueta(215.20, categoria, true);
			
	}
	
	@Test
	public void finalizarFaenaTest(){
		
	}
	
	

}
