package tropa;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import excepciones.CorralNoDisponibleParaGuardarAnimalesException;
import excepciones.MayorCantidadAnimalesQueCapacidadCorralException;
import modelo.especie.Especie;
import modelo.especie.Ovino;
import modelo.especie.Porcino;
import modelo.tropa.Corral;
import modelo.tropa.DTe;
import modelo.tropa.Libre;
import modelo.tropa.Ocupado;
import modelo.tropa.Tropa;
import modelo.tropa.TropaCorral;
import servicios.TropaDAO;

public class TropaTest {

	@Test
	public void crearTropaPalco() {
		// No se ingresa DTE
		// No fecha de Ingreso
		// No cantidad de animales
		// No se asigna corral
		// Si fecha de egreso
		Date hoy = new Date();
		Especie especie = new Ovino();
		int numeroDeTropa = 9;

		Tropa tropa = new Tropa(numeroDeTropa, hoy, especie);

		Assert.assertEquals("Numero de tropas DISTINTO", numeroDeTropa, tropa.getNumeroTropa());
		Assert.assertEquals("Las fechas de faena son disntintas", hoy, tropa.getFechaFaena());
		Assert.assertEquals("La especie asignada a la tropa NO es igual", especie.getDescripcion(),
				tropa.getEspecie().getDescripcion());
		Assert.assertTrue(tropa.cantidadAnimales() == 0);
		Assert.assertTrue(tropa.cantidadCorrales() == 0);

		Assert.assertNull(tropa.getDte());
		Assert.assertNull(tropa.getFechaIngreso());
		Assert.assertEquals("La cantidad de animales recibidos NO es 0", tropa.getAnimalesRecibidos(), 0);
	}

	@Test
	public void crearTropaWeb() {
		// No se ingresa fecha de Egreso
		// Si se ingresa DTE
		// Si fecha de Ingreso
		// Si cantidad de animales
		// Se asigna corral

		int numeroTropa = 10;
		int animalesRecibidos = 45;
		Date fechaIngreso = new Date();
		DTe dte = new DTe(134, 45);
		Especie especie = new Porcino();

		Corral corral1 = new Corral(1, 20, new Libre());
		Corral corral2 = new Corral(2, 30, new Libre());

		TropaCorral tropaCorral1 = new TropaCorral();
		tropaCorral1.setCorral(corral1);
		try {
			tropaCorral1.setOcupacion(15);
		} catch (MayorCantidadAnimalesQueCapacidadCorralException e) {
			e.excErrorMayorCantidadAnimalesQueCapaidadEnCorral();
			e.printStackTrace();
		} catch (CorralNoDisponibleParaGuardarAnimalesException e) {
			e.excErrorCorralNoDisponible();
			e.printStackTrace();
		}

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

		Set<TropaCorral> tropaCorrales = new HashSet<TropaCorral>();
		tropaCorrales.add(tropaCorral1);
		tropaCorrales.add(tropaCorral2);

		Tropa tropa = new Tropa(numeroTropa, animalesRecibidos, fechaIngreso, dte, tropaCorrales, especie);

		Assert.assertEquals("Numero de tropas DISTINTO", numeroTropa, tropa.getNumeroTropa());
		Assert.assertEquals("Las fechas de ingreso son disntintas", fechaIngreso, tropa.getFechaIngreso());
		Assert.assertEquals("La especie asignada a la tropa NO es igual", especie.getDescripcion(),
				tropa.getEspecie().getDescripcion());
		Assert.assertTrue(tropa.getAnimalesRecibidos() == animalesRecibidos);
		Assert.assertTrue(tropa.cantidadCorrales() == 2);

		Assert.assertEquals("Los DTes NO son iguales", dte.getNumeroDte(), tropa.getDte().getNumeroDte());
		Assert.assertNull(tropa.getFechaFaena());
		
		for (TropaCorral tc : tropa.getCorrales()){
			Ocupado ocupado = new Ocupado();
			Assert.assertEquals("EL estado del corral1 no quedo en ocupado", ocupado.toString(), tc.getCorral().getEstado().toString());
		}
		
	}

}
