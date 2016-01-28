package servicios;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.especie.Especie;
import modelo.establecimiento.Establecimiento;
import modelo.tropa.Animal;
import modelo.tropa.Procedencia;
import modelo.tropa.Tropa;
import modelo.tropa.TropaReservada;

public class TropaDAOTest {
	private Establecimiento establecimiento = null;

	@Before
	public void setUp() {
		EstablecimientoDAO es = new EstablecimientoDAO();
		establecimiento = es.obtenerEstablecimiento(1);

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
			establecimiento = capiangos;
		}
	}

	@Test
	public void salvarYobtenerTropaDAOTest() {
		ProcedenciaDAO procedenciaDAO = new ProcedenciaDAO();
		Procedencia procedencia = procedenciaDAO.obtenerProcedencia(1);

		TropaReservadaDAO treservadaDAO = new TropaReservadaDAO();
		TropaReservada treservada = treservadaDAO.obtenerTropaReservadaPorProcedenciaYanioActual(procedencia);

		EspecieDAO especieDAO = new EspecieDAO();
		Especie especie = especieDAO.obtenerEspecie(2);

		Tropa tropa1 = new Tropa();
		tropa1.setEstablecimiento(establecimiento);
		tropa1.setAnimalesRecibidos(100);
		tropa1.setNumeroTropa(treservada.obtenerSiguienteNroDeTropa());
		tropa1.setFechaIngreso(new GregorianCalendar(2016, 01, 24, 8, 30, 00).getTime());
		tropa1.setFechaFaena(new GregorianCalendar(2016, 01, 25, 15, 20, 10).getTime());
		tropa1.setEspecie(especie);

		TropaDAO trDAO = new TropaDAO();
		trDAO.salvarTropa(tropa1);
		Tropa tropaBBDD = trDAO.obtenerTropaPorNroTropa(tropa1.getNumeroTropa());

		Assert.assertEquals("Los numeros de tropa NO COINCIDEN!!!!!!!", tropa1.getNumeroTropa(),
				tropaBBDD.getNumeroTropa());

		/*
		 * TODO: agregar los assert para las demas propiedades del objeto tropa1
		 * y tropaBBDD
		 */
	}

	@Test
	public void obtenerUltimoGarronDeUnDiaDeterminadoTest() {
		Random random = new Random();

		List<Tropa> tropas = establecimiento.getTropas();
		int index = random.nextInt(tropas.size());
		Tropa randomTropa = tropas.get(index);

		Calendar cal = Calendar.getInstance();
		cal.setTime(randomTropa.getFechaFaena());
		GregorianCalendar fecha = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE));

		int maxNroTropa = 0;
		Tropa tropaSeleccionada = null;
		for (Tropa tropa : establecimiento.getTropas()) {
			Calendar calTropa = Calendar.getInstance();
			calTropa.setTime(tropa.getFechaFaena());
			GregorianCalendar fechaTropa = new GregorianCalendar(calTropa.get(Calendar.YEAR),
					calTropa.get(Calendar.MONTH), calTropa.get(Calendar.DATE));
			if ((fechaTropa.get(Calendar.YEAR) == fecha.get(Calendar.YEAR))
					&& (fechaTropa.get(Calendar.MONTH) == fecha.get(Calendar.MONTH))
					&& (fechaTropa.get(Calendar.DATE) == fecha.get(Calendar.DATE))) {
				if (tropa.getNumeroTropa() > maxNroTropa) {
					maxNroTropa = tropa.getNumeroTropa();
					tropaSeleccionada = tropa;
				}
			}
		}
		int maxGarron = 0;
		for (Animal a : tropaSeleccionada.getAnimales()) {
			if (a.getGarron() > maxGarron) {
				maxGarron = a.getGarron();
			}
		}

		TropaDAO tropaDAO = new TropaDAO();
		// System.out.println(
		// "El ultimo Garron del dia " + fecha + "es: " +
		// tropaDAO.obtenerUltimoGarronDeUnDiaDeterminado(fecha));
		// System.out.println("El numero de tropa seleccionado al azar es: " +
		// randomTropa.getNumeroTropa());
		// System.out.println("El numero de tropa mayor del dia: " +
		// tropaSeleccionada.getNumeroTropa());
		// System.out.println("El ultimo numero de garron asignado para ese dia:
		// " + maxGarron);

		Assert.assertEquals(tropaDAO.obtenerUltimoGarronDeUnDiaDeterminado(fecha), maxGarron);
	}
	
	public void obtenerSiguienteNumeroDeGarronTest(){
		
	}
}