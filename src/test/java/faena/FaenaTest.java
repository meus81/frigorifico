package faena;

import org.junit.Assert;
import org.junit.Test;

import ejecutoras.faena.Faena;
import especie.Especie;
import servicios.CategoriaDAO;
import servicios.EspecieDAO;
import servicios.ProcedenciaDAO;
import servicios.TropaReservadaDAO;
import tropa.Categoria;
import tropa.Procedencia;
import tropa.TropaReservada;

public class FaenaTest {
	
	@Test
	public void inicializarFaenaTest(){
		
		Faena faena = new Faena();
		
		ProcedenciaDAO procedenciaServicio = new ProcedenciaDAO();
		Procedencia procedencia = procedenciaServicio.obtenerProcedencia(new Long(1)); 
		EspecieDAO especieServicio = new EspecieDAO();
		Especie especie = especieServicio.obtenerEspecie(new Long(1));
		
		TropaReservadaDAO tropaReservadaServicio = new TropaReservadaDAO();
		TropaReservada tropaReservada = tropaReservadaServicio.obtenerTropaReservadaPorProcedenciaYanioActual(procedencia);
		int anteriorNumeroTropa = tropaReservada.getUltimaTropa();
		faena.inicializarFaena(procedencia, especie);
		tropaReservada = tropaReservadaServicio.obtenerTropaReservadaPorProcedenciaYanioActual(procedencia);
		int nuevoNumeroTropa = tropaReservada.getUltimaTropa();
		
		Assert.assertEquals("El anterior numero de tropa no es igual al nuevo-1", anteriorNumeroTropa, nuevoNumeroTropa - 1);
	}
	
	@Test 
	public void imprimirEtiquetaTest(){
		/*Cual es la intencion de este test?
		 * Probar que se imprimin las etiquetas
		 * Pensar como hacer eso de mejor manera
		 * 
		 */
		
		Faena faena = new Faena();
		
		ProcedenciaDAO procedenciaServicio = new ProcedenciaDAO();
		Procedencia procedencia = procedenciaServicio.obtenerProcedencia(new Long(1));
		
		EspecieDAO especieServicio = new EspecieDAO();
		Especie especie = especieServicio.obtenerEspecie(new Long(1));
		faena.inicializarFaena(procedencia, especie);
		
		CategoriaDAO categoriaServicioDatabase = new CategoriaDAO();
		Categoria categoria = categoriaServicioDatabase.obtenerCategoria(new Long(1));
		faena.imprimirEtiqueta(215.20, categoria, true);
		//TODO mockear el metodo de faena test que imprime etiquetas
	}
	
	@Test
	public void finalizarFaenaTest(){
		
	}
	
	

}
