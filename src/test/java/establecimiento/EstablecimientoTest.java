package establecimiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import excepciones.TropaInexistenteException;
import tropa.Corral;
import tropa.DTe;
import tropa.Tropa;
import tropa.Ubicacion;

public class EstablecimientoTest {
	private Establecimiento establecimiento;

	private Tropa crearTropa(int numeroTropa, int animalesRecibidos, DTe dte, Corral corral, int cantidadPorCorral) {
		Tropa tropa = new Tropa();
		tropa.setNumeroTropa(numeroTropa);
		tropa.setAnimalesRecibidos(animalesRecibidos);
		tropa.setDte(dte);
		tropa.setFechaIngreso(new GregorianCalendar());

		Ubicacion ubicacion1 = new Ubicacion(corral, cantidadPorCorral);
		Set<Ubicacion> ubicaciones = new HashSet<Ubicacion>();
		ubicaciones.add(ubicacion1);
		tropa.setUbicaciones(ubicaciones);

		return tropa;

	}

	@Before
	public void inicializarEstablecimiento() {
		establecimiento = new Establecimiento();

		establecimiento.agregarTropa(crearTropa(1, 10, new DTe(34, 15), new Corral(1, 20), 10));
		establecimiento.agregarTropa(crearTropa(55, 45, new DTe(35, 50), new Corral(2, 50), 45));

	}

	@Test
	public void agregarTropa() {

		int cantidadPrevia = establecimiento.cantidadTropas();
		establecimiento.agregarTropa(crearTropa(2, 20, new DTe(100, 100), new Corral(3, 20), 20));
		int cantidadPosterior = establecimiento.cantidadTropas();

		assertEquals(cantidadPrevia + 1, cantidadPosterior);

		Tropa tropa;
		try {
			tropa = establecimiento.obtenerTropa(2);
			assertEquals(tropa.getDte().getNumero(), 100);
			assertTrue(tropa.getDte().getAnimalesEnviados() >= tropa.getAnimalesRecibidos());
		} catch (TropaInexistenteException e) {
			e.excErrorTropaInexistente();
			e.printStackTrace();
		}

	}

	@Test(expected = TropaInexistenteException.class)
	public void obtenerTropaException() throws TropaInexistenteException {
		establecimiento.obtenerTropa(10000);
	}

	@Test
	public void obtenerTropa() {
		try {
			establecimiento.obtenerTropa(55);
		} catch (TropaInexistenteException e) {
			e.excErrorTropaInexistente();
			e.printStackTrace();
		}
	}

	@Test
	public void eliminarTropa() {

		int cantTropasInicial = establecimiento.cantidadTotalTropas();

		establecimiento.eliminarTropa(1);

		int cantTropasFinal = establecimiento.cantidadTotalTropas();

		assertEquals(cantTropasInicial - 1, cantTropasFinal);
		assertFalse(false);
		assertFalse(establecimiento.eliminarTropa(1));

	}

}
