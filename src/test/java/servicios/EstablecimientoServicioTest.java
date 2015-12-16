package servicios;

import org.junit.Assert;
import org.junit.Test;

import establecimiento.Establecimiento;

public class EstablecimientoServicioTest {
	@Test
	public void establecimientoServicio() {
		Establecimiento capiangos = new Establecimiento();
		capiangos.setCodigoEstablecimiento("01.029.0.21924/00");
		capiangos.setCuit(30714579785L);
		capiangos.setNombre("Capiangos S.R.L.");
		capiangos.setLocalidad("Chascom�s");
		capiangos.setDireccion("Calle Chascom�s");
		capiangos.setNumeroHabilitacion(4833);
		capiangos.setProvincia("Buenos Aires");
		capiangos.setTelefono("(0221) 15-5574055");
		capiangos.setTitular("El Cora");

		EstablecimientoServicioDatabase es = new EstablecimientoServicioDatabase();

		es.salvarEstablecimiento(capiangos);

		Establecimiento establecimientoDesdeLaBBDD = es.obtenerEstablecimiento(1);

		System.out.println("RESULTADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" + establecimientoDesdeLaBBDD.getNombre());
		System.out.println(capiangos.getNombre());
		Assert.assertTrue(establecimientoDesdeLaBBDD.getNombre().equals(capiangos.getNombre()));
		
		

	}
	
	@Test
	public void establecimientoInexistente(){
		EstablecimientoServicioDatabase es = new EstablecimientoServicioDatabase();
		Establecimiento e = es.obtenerEstablecimiento(120);
		Assert.assertNull("El establecimiento que estas pidiendo existe, por eso no es null y el test falla", e);
	}

}
