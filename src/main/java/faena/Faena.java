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
	
	public Tropa getTropa() {
		return tropa;
	}
	
	public void setTropa(Tropa tropa) {
		this.tropa = tropa;
	}
	
	public int getNumeroDeGarron() {
		return numeroDeGarron;
	}
	
	public void setNumeroDeGarron(int numeroDeGarron) {
		this.numeroDeGarron = numeroDeGarron;
	}

	public void inicializarFaena() {
		long numeroTropa = tropaServicio.obtenerSiguienteNroDeTropa();
		tropa = new Tropa();

		tropa.setFechaFaena(new GregorianCalendar().getTime());
		tropa.setNumeroTropa(numeroTropa);

		tropaServicio.salvarTropa(tropa);
		numeroDeGarron = obtenerUltimoGarronDelDia();

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
		etiqueta.imprimirEtiquetas(tropa, animal, cabezaAlMedio);
	}

	public void finalizarFaena() {
		//TODO no sabemos bien que puede llegar a hacer este metodo. Destruir el objeto tal vez??
	}


	public int obtenerUltimoGarronDelDia() {
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
