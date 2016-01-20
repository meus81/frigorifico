package faena;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import establecimiento.Establecimiento;
import servicios.AnimalServicioDatabase;
import servicios.EstablecimientoServicioDatabase;
import servicios.ServiciosDatabase;
import servicios.TropaReservadaServicioDatabase;
import servicios.TropaServicioDatabase;
import tropa.Animal;
import tropa.Categoria;
import tropa.Procedencia;
import tropa.Tropa;
import tropa.TropaReservada;

public class Faena {


	private int numeroDeGarron;
	private TropaServicioDatabase tropaServicio = new TropaServicioDatabase();
	private TropaReservadaServicioDatabase tropaReservadaServicio = new TropaReservadaServicioDatabase();
	private int ultimoNroTropaReservada;
	
	public int getNumeroDeGarron() {
		return numeroDeGarron;
	}
	
	public void setNumeroDeGarron(int numeroDeGarron) {
		this.numeroDeGarron = numeroDeGarron;
	}

	public void inicializarFaena(Procedencia procedencia) {
		EstablecimientoServicioDatabase establecimientoServicioDatabase = new EstablecimientoServicioDatabase();
		Establecimiento establecimiento = establecimientoServicioDatabase.obtenerEstablecimiento(1);
		TropaReservada tropaReservada = tropaReservadaServicio.obtenerSiguienteNroDeTropa(procedencia);
		
		ultimoNroTropaReservada = tropaReservada.getUltimaTropa();
		Tropa tropa = (new Tropa());
		tropa.setAnimales(new ArrayList<Animal>());
		tropa.setEstablecimiento(establecimiento);		
		tropa.setFechaFaena(new GregorianCalendar().getTime());
		tropa.setNumeroTropa(ultimoNroTropaReservada);

		//establecimiento.agregarTropa(tropa);
		/*Averiguar por que con la sentencia de abajo no se guarda la tropa
		 * tener en cuenta que:
		 * -> a la tropa le seteamos el establecimiento
		 * -> no agregamos la tropa a la coleccion de tropas del establecimiento 
		 */
		//establecimientoServicioDatabase.actualizarEstablecimiento(establecimiento);
		
		
		//FALTA SALVAR actualizar tropaReservada con su ultimo numero
		tropaReservadaServicio.actualizar(tropaReservada);
		tropaServicio.salvarTropa(tropa);
		numeroDeGarron = obtenerUltimoGarronDelDia();
	}

	public void imprimirEtiqueta(double peso, Categoria categoria, boolean cabezaAlMedio) {
		Tropa tropa = tropaServicio.obtenerTropaPorNroTropa(ultimoNroTropaReservada);
	
		System.out.println("la ultima tropa guardada fue: " + tropa.getNumeroTropa());
		
		Animal animal = new Animal();
		animal.setCategoria(categoria);
		animal.setPeso(peso);
		animal.setGarron(numeroDeGarron);
		animal.setTropa(tropa);
		numeroDeGarron++;
//
//		//tropaServicio.actualizar(this.getTropa());
		AnimalServicioDatabase animalServicioDatabase = new AnimalServicioDatabase();
		animalServicioDatabase.salvarAnimal(animal);
		
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
