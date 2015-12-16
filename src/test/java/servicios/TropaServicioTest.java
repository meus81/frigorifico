package servicios;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import establecimiento.Establecimiento;
import tropa.Tropa;

public class TropaServicioTest {
	private Establecimiento establecimiento= null;
	
	@Before
	public void crearUobtenerEstablecimiento(){
		EstablecimientoServicioDatabase es= new EstablecimientoServicioDatabase();
		
		establecimiento= es.obtenerEstablecimiento(1);

		if (establecimiento == null) {
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
			es.salvarEstablecimiento(capiangos);
			establecimiento= capiangos;			
		}
	}
	
	@Test
	public void tropaServicio (){
		Tropa tropa1 = new Tropa();
		tropa1.setAnimalesRecibidos(20);
		tropa1.setNumeroTropa(34);
		tropa1.setFechaFaena(new GregorianCalendar(2015,11,1,15,20,10));
		tropa1.setFechaIngreso(new GregorianCalendar(2015,10,30,8,30,00));
		
		EstablecimientoServicioDatabase es= new EstablecimientoServicioDatabase();
		
		establecimiento.agregarTropa(tropa1);
		es.actualizarEstablecimiento(establecimiento);
		TropaServicioDatabase ts= new TropaServicioDatabase(); 
		
		for (Tropa t : ts.obtenerTropas()) {
			
			System.out.println("RESULTADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" + t.getNumeroTropa());
			System.out.println(tropa1.getNumeroTropa());
			Assert.assertTrue(t.getNumeroTropa() == tropa1.getNumeroTropa());
		}
		
	}


}
