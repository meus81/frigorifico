package servicios;

import org.junit.Assert;
import org.junit.Test;

import establecimiento.Establecimiento;

public class EstablecimientoDAOTest {
	
	@Test
	public void salvarYobtenerEstablecimientoDAOTest() {
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

		EstablecimientoDAO etablecimeintoDAO = new EstablecimientoDAO();
		etablecimeintoDAO.salvarEstablecimiento(capiangos);
		Establecimiento establecimientoDesdeLaBBDD = etablecimeintoDAO.obtenerEstablecimiento(1);

//		System.out.println("RESULTADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" + establecimientoDesdeLaBBDD.getNombre());
//		System.out.println(capiangos.getNombre());

		Assert.assertTrue(establecimientoDesdeLaBBDD.getNombre().equals(capiangos.getNombre()));
		/* TODO: agregar asserts para que compare el resto de los atributos del objeto*/
	}

	@Test
	public void obtenerEstablecimientoInexistenteDAOTest() {
		EstablecimientoDAO es = new EstablecimientoDAO();
		Establecimiento e = es.obtenerEstablecimiento(120);
		Assert.assertNull("El establecimiento que estas pidiendo existe, por eso no es null y el test falla", e);
	}

	public void actualizarEstablecimientoTest(){
		
	}
}
