package establecimiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import excepciones.CorralNoDisponibleParaGuardarAnimalesException;
import excepciones.MayorCantidadAnimalesQueCapacidadCorralException;
import excepciones.TropaInexistenteException;
import modelo.establecimiento.Establecimiento;
import modelo.tropa.Corral;
import modelo.tropa.DTe;
import modelo.tropa.Libre;
import modelo.tropa.Tropa;
import modelo.tropa.TropaCorral;

public class EstablecimientoTest {
	final static Logger logger = Logger.getLogger(EstablecimientoTest.class);
	private Establecimiento establecimiento;

	@Before
	public void setUp() {
		logger.debug("Estamos inicializando el @Test en el @Before");
		establecimiento = new Establecimiento();

		Corral corral1 = new Corral(1, 20, new Libre());
		Corral corral2 = new Corral(2, 30, new Libre());
		Corral corral3 = new Corral(3, 50, new Libre());

		TropaCorral tropaCorral1 = new TropaCorral();
		tropaCorral1.setCorral(corral1);
		try {
			tropaCorral1.setOcupacion(10);
		} catch (MayorCantidadAnimalesQueCapacidadCorralException e) {
			e.excErrorMayorCantidadAnimalesQueCapaidadEnCorral();
			e.printStackTrace();
		} catch (CorralNoDisponibleParaGuardarAnimalesException e) {
			e.excErrorCorralNoDisponible();
			e.printStackTrace();
		}

		Set<TropaCorral> tropaCorrales1 = new HashSet<TropaCorral>();
		tropaCorrales1.add(tropaCorral1);

		TropaCorral tropaCorral2 = new TropaCorral();
		tropaCorral2.setCorral(corral2);
		try {
			tropaCorral2.setOcupacion(30);
		} catch (MayorCantidadAnimalesQueCapacidadCorralException e) {
			e.excErrorMayorCantidadAnimalesQueCapaidadEnCorral();
			e.printStackTrace();
		} catch (CorralNoDisponibleParaGuardarAnimalesException e) {
			e.excErrorCorralNoDisponible();
			e.printStackTrace();
		}

		TropaCorral tropaCorral3 = new TropaCorral();
		tropaCorral3.setCorral(corral3);
		try {
			tropaCorral3.setOcupacion(25);
		} catch (MayorCantidadAnimalesQueCapacidadCorralException e) {
			e.excErrorMayorCantidadAnimalesQueCapaidadEnCorral();
			e.printStackTrace();
		} catch (CorralNoDisponibleParaGuardarAnimalesException e) {
			e.excErrorCorralNoDisponible();
			e.printStackTrace();
		}

		Set<TropaCorral> tropaCorrales2 = new HashSet<TropaCorral>();
		tropaCorrales2.add(tropaCorral2);
		tropaCorrales2.add(tropaCorral3);

		establecimiento.agregarTropa(new Tropa(1, 10, new Date(), new DTe(34, 15), tropaCorrales1, null));
		establecimiento.agregarTropa(new Tropa(55, 45, new Date(), new DTe(35, 50), tropaCorrales2, null));

	}

	@Test
	public void agregarTropaTest() {
		logger.debug("Estamos en el @Test agregarTropa...");

		Corral corral4 = new Corral(4, 30, new Libre());
		TropaCorral tropaCorral4 = new TropaCorral();
		tropaCorral4.setCorral(corral4);
		try {
			tropaCorral4.setOcupacion(20);
		} catch (MayorCantidadAnimalesQueCapacidadCorralException e) {
			e.excErrorMayorCantidadAnimalesQueCapaidadEnCorral();
			e.printStackTrace();
		} catch (CorralNoDisponibleParaGuardarAnimalesException e) {
			e.excErrorCorralNoDisponible();
			e.printStackTrace();
		}
		Set<TropaCorral> tropaCorrales4 = new HashSet<TropaCorral>();

		int cantidadPrevia = establecimiento.cantidadTropas();
		establecimiento.agregarTropa(new Tropa(2, 20, new Date(), new DTe(100, 100), tropaCorrales4, null));
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
