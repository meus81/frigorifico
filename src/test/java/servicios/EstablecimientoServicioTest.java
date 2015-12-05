package servicios;

import org.junit.Assert;
import org.junit.Test;

import establecimiento.Establecimiento;



public class EstablecimientoServicioTest {
	@Test
	public void establecimientoServicio (){
		Establecimiento capiangos = new Establecimiento();
		capiangos.setCodigoEstablecimiento("01.029.0.21924/00");
		capiangos.setCuit(30714579785L);
		capiangos.setNombre("Capiangos S.R.L.");
		capiangos.setLocalidad("Chascomús");
		capiangos.setDireccion("Calle Chascomús");
		capiangos.setNumeroHabilitacion(4833);
		capiangos.setProvincia("Buenos Aires");
		capiangos.setTelefono("(0221) 15-5574055");
		capiangos.setTitular("El Cora");
	
		
		EstablecimientoServicio es= new EstablecimientoServicio();
		
		es.salvarEstablecimiento(capiangos);
		
		for (Establecimiento e : es.obtenerEstablecimientos()) {
			
			System.out.println("RESULTADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" + e.getNombre());
			System.out.println(capiangos.getNombre());
			Assert.assertTrue(e.getNombre().equals(capiangos.getNombre()));
		}
		
	}

}
