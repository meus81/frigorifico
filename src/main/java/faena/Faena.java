package faena;

import java.util.Calendar;
import java.util.GregorianCalendar;

import servicios.ServiciosDatabase;
import servicios.TropaServicioDatabase;
import tropa.Animal;
import tropa.Categoria;
import tropa.Tropa;

public class Faena {

	private Tropa tropa;
	private int numeroDeGarron;
	private TropaServicioDatabase tropaServicio = new TropaServicioDatabase();

	public void inicializarTropa() {
		long numeroTropa = tropaServicio.obtenerSiguienteNroDeTropa();
		tropa = new Tropa();

		tropa.setFechaFaena(new GregorianCalendar().getTime());
		tropa.setNumeroTropa(numeroTropa);

		tropaServicio.salvarTropa(tropa);
		numeroDeGarron = obtenerNumeroGarronPorDia();

	}

	public void imprimirEtiqueta(double peso, Categoria categoria, boolean cabezaAlMedio) {
		Animal animal = new Animal();
		animal.setCategoria(categoria);
		animal.setPeso(peso);
		animal.setGarron(numeroDeGarron);
		numeroDeGarron++;

		tropa.agregarAnimal(animal);
		tropaServicio.actualizar(tropa);

		Etiqueta etiqueta = new Etiqueta();
		etiqueta.imprimirEtiquetas(animal, cabezaAlMedio);
	}

	public void finalizarTropa() {

	}

	public int obtenerNumeroGarronPorDia() {
		ServiciosDatabase sd = new ServiciosDatabase();

		GregorianCalendar fechaDesde = new GregorianCalendar();
		fechaDesde.set(Calendar.HOUR_OF_DAY, 0);
		fechaDesde.set(Calendar.MINUTE, 0);
		fechaDesde.set(Calendar.SECOND, 0);
		fechaDesde.set(Calendar.MILLISECOND, 0);

		GregorianCalendar fechaHasta = new GregorianCalendar();
		fechaHasta.set(Calendar.HOUR_OF_DAY, 23);
		fechaHasta.set(Calendar.MINUTE, 59);
		fechaHasta.set(Calendar.SECOND, 59);
		fechaHasta.set(Calendar.MILLISECOND, 1000);
		int ultimoGarron = sd.obtenerUltimoNumeroGarron(fechaDesde.getTime(), fechaHasta.getTime());

		return ultimoGarron;
	}
}
