package establecimiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import establecimiento.Establecimiento;
import excepciones.TropaInexistenteException;
import tropa.Corral;
import tropa.DTe;
import tropa.Tropa;

public class EstablecimientoTest {
	final static Logger logger = Logger.getLogger(EstablecimientoTest.class);
	private Establecimiento establecimiento;

	@Before
	public void setUp() {
		logger.debug("Estamos inicializando el @Test en el @Before");
		establecimiento = new Establecimiento();

		Set<Corral> corrales1 = new HashSet<Corral>();
		Corral corral1 = new Corral(1, 20);
		Corral corral2 = new Corral(2, 30);
		
		corral1.setOcupacion(20);
		corral2.setOcupacion(15);
		corrales1.add(corral1);
		corrales1.add(corral2);
		

		Set<Corral> corrales2 = new HashSet<Corral>();
		Corral corral3 = new Corral(3, 50);
		corral3.setOcupacion(45);
		corrales2.add(corral3);
		
		establecimiento.agregarTropa(new Tropa(1, 10, new DTe(34, 15), corrales1));
		establecimiento.agregarTropa(new Tropa(55, 45, new DTe(35, 50), corrales2));

	}

	@Test
	public void agregarTropaTest() {
		logger.debug("Estamos en el @Test agregarTropa...");
		Set<Corral> corrales = new HashSet<Corral>();
		Corral corral4 = new Corral(4, 30);
		corral4.setOcupacion(20);
		corrales.add(corral4);

		int cantidadPrevia = establecimiento.cantidadTropas();
		establecimiento.agregarTropa(new Tropa(2, 20, new DTe(100, 100), corrales));
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
	public void obtenerTropaExceptionTest() throws TropaInexistenteException {
		logger.debug("Estamos en el @Test obtenerTropaException...");

		establecimiento.obtenerTropa(10000);
	}

	@Test
	public void obtenerTropaTest() {
		logger.debug("Estamos en el @Test obtenerTropa...");

		try {
			establecimiento.obtenerTropa(55);
		} catch (TropaInexistenteException e) {
			e.excErrorTropaInexistente();
			e.printStackTrace();
		}
	}

	@Test
	public void eliminarTropaTest() {
		logger.debug("Estamos en el @Test eliminarTropa...");
		int cantTropasInicial = establecimiento.cantidadTropas();
		establecimiento.eliminarTropa(1);
		int cantTropasFinal = establecimiento.cantidadTropas();

		assertEquals(cantTropasInicial - 1, cantTropasFinal);
		assertFalse(false);
		assertFalse(establecimiento.eliminarTropa(1));

	}

}
