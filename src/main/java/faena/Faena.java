package faena;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import establecimiento.Establecimiento;
import servicios.EstablecimientoServicioDatabase;
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
		//TODO Si la tropa se creo antes de faenar no se debe crear una nueva tropa, 
		// se debe actualizar
		// Como se sabe que se debe actualizar un tropa existente? porque el 
		// usuario al momento de faenar ingresa el numero de tropa
		
		EstablecimientoServicioDatabase establecimientoServicioDatabase = new EstablecimientoServicioDatabase();
		Establecimiento establecimiento = establecimientoServicioDatabase.obtenerEstablecimiento(1);
				
		long numeroTropa = tropaServicio.obtenerSiguienteNroDeTropa();
		this.setTropa(new Tropa());
		this.getTropa().setAnimales(new ArrayList<Animal>());
				
		this.getTropa().setFechaFaena(new GregorianCalendar().getTime());
		this.getTropa().setNumeroTropa(numeroTropa);

		establecimiento.agregarTropa(this.getTropa());
		establecimientoServicioDatabase.actualizarEstablecimiento(establecimiento);
		numeroDeGarron = obtenerUltimoGarronDelDia();

	}

	public void imprimirEtiqueta(double peso, Categoria categoria, boolean cabezaAlMedio) {
		Animal animal = new Animal();
		animal.setCategoria(categoria);
		animal.setPeso(peso);
		animal.setGarron(numeroDeGarron);
		numeroDeGarron++;

		this.getTropa().agregarAnimal(animal);
		tropaServicio.actualizar(this.getTropa());

		Etiqueta etiqueta = new Etiqueta();
		etiqueta.imprimirEtiquetas(this.getTropa(), animal, cabezaAlMedio);
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
