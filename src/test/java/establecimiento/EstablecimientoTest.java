package establecimiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import excepciones.TropaInexistenteException;
import tropa.Corral;
import tropa.DTe;
import tropa.Tropa;
import tropa.Ubicacion;

public class EstablecimientoTest {
	final static Logger logger = Logger.getLogger(EstablecimientoTest.class);
	private Establecimiento establecimiento;

	@Before
	public void inicializarEstablecimiento() {
		logger.debug("Estamos inicializando el @Test en el @Before");
		establecimiento = new Establecimiento();

		Ubicacion ubicacion = new Ubicacion(new Corral(1, 20), 10);
		Set<Ubicacion> ubicaciones1 = new HashSet<Ubicacion>();
		ubicaciones1.add(ubicacion);

		Ubicacion ubicacion2 = new Ubicacion(new Corral(2, 50), 45);
		Set<Ubicacion> ubicaciones2 = new HashSet<Ubicacion>();
		ubicaciones2.add(ubicacion2);

		establecimiento.agregarTropa(new Tropa(1, 10, new DTe(34, 15), ubicaciones1));
		establecimiento.agregarTropa(new Tropa(55, 45, new DTe(35, 50), ubicaciones2));

	}

	@Test
	public void agregarTropa() {
		logger.debug("Estamos en el @Test agregarTropa...");
		Ubicacion ubicacion = new Ubicacion(new Corral(3, 20), 20);
		Set<Ubicacion> ubicaciones = new HashSet<Ubicacion>();
		ubicaciones.add(ubicacion);

		int cantidadPrevia = establecimiento.cantidadTropas();
		establecimiento.agregarTropa(new Tropa(2, 20, new DTe(100, 100), ubicaciones));
		int cantidadPosterior = establecimiento.cantidadTropas();

		assertEquals(cantidadPrevia + 1, cantidadPosterior);

		Tropa tropa;
		try {
			tropa = establecimiento.obtenerTropa(2);
			assertEquals(tropa.getDte().getNumeroDte(), 100);
			assertTrue(tropa.getDte().getAnimalesEnviados() >= tropa.getAnimalesRecibidos());
		} catch (TropaInexistenteException e) {
			e.excErrorTropaInexistente();
			e.printStackTrace();
		}

	}

	@Test(expected = TropaInexistenteException.class)
	public void obtenerTropaException() throws TropaInexistenteException {
		logger.debug("Estamos en el @Test obtenerTropaException...");

		establecimiento.obtenerTropa(10000);
	}

	@Test
	public void obtenerTropa() {
		logger.debug("Estamos en el @Test obtenerTropa...");

		try {
			establecimiento.obtenerTropa(55);
		} catch (TropaInexistenteException e) {
			e.excErrorTropaInexistente();
			e.printStackTrace();
		}
	}

	@Test
	public void eliminarTropa() {
		logger.debug("Estamos en el @Test eliminarTropa...");


		int cantTropasInicial = establecimiento.cantidadTropas();

		establecimiento.eliminarTropa(1);

		int cantTropasFinal = establecimiento.cantidadTropas();

		assertEquals(cantTropasInicial - 1, cantTropasFinal);
		assertFalse(false);
		assertFalse(establecimiento.eliminarTropa(1));

	}

}
