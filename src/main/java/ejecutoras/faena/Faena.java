package ejecutoras.faena;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modelo.especie.Especie;
import modelo.establecimiento.Establecimiento;
import modelo.tropa.Animal;
import modelo.tropa.Categoria;
import modelo.tropa.Procedencia;
import modelo.tropa.Tropa;
import modelo.tropa.TropaReservada;
import servicios.AnimalDAO;
import servicios.EstablecimientoDAO;
import servicios.TropaDAO;
import servicios.TropaReservadaDAO;

public class Faena {


	private int numeroDeGarron;
	private TropaDAO tropaServicio = new TropaDAO();
	private TropaReservadaDAO tropaReservadaDAO = new TropaReservadaDAO();
	private int ultimoNroTropaReservada;
	
	public int getNumeroDeGarron() {
		return numeroDeGarron;
	}
	
	public void setNumeroDeGarron(int numeroDeGarron) {
		this.numeroDeGarron = numeroDeGarron;
	}

	public void inicializarFaena(Procedencia procedencia, Especie especie) {
		EstablecimientoDAO establecimientoServicioDatabase = new EstablecimientoDAO();
		Establecimiento establecimiento = establecimientoServicioDatabase.obtenerEstablecimiento(1);
		TropaReservada tropaReservada = tropaReservadaDAO.obtenerTropaReservadaPorProcedenciaYanioActual(procedencia);
		
		ultimoNroTropaReservada = tropaReservada.obtenerSiguienteNroDeTropa();
		Tropa tropa = (new Tropa());
		tropa.setAnimales(new ArrayList<Animal>());
		tropa.setEstablecimiento(establecimiento);		
		tropa.setFechaFaena(new GregorianCalendar().getTime());
		tropa.setEspecie(especie);
		tropa.setNumeroTropa(ultimoNroTropaReservada);

		//establecimiento.agregarTropa(tropa);
		/*Averiguar por que con la sentencia de abajo no se guarda la tropa
		 * tener en cuenta que:
		 * -> a la tropa le seteamos el establecimiento
		 * -> no agregamos la tropa a la coleccion de tropas del establecimiento 
		 */
		//establecimientoServicioDatabase.actualizarEstablecimiento(establecimiento);
		
		
		//TODO averiguar como hacerlo en una sola transaccion
		tropaServicio.salvarTropa(tropa);
		tropaReservadaDAO.actualizar(tropaReservada);
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
		AnimalDAO animalServicioDatabase = new AnimalDAO();
		animalServicioDatabase.salvarAnimal(animal);
		
		Etiqueta etiqueta = new Etiqueta();
		etiqueta.imprimirEtiquetas(tropa, animal, cabezaAlMedio);
	}

	public void finalizarFaena() {
		//TODO no sabemos bien que puede llegar a hacer este metodo. Destruir el objeto tal vez??
	}


	public int obtenerUltimoGarronDelDia() {
		TropaDAO tropaDAO = new TropaDAO();

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
		int ultimoGarron = tropaDAO.obtenerUltimoNumeroGarronDelDia();

		return ultimoGarron;
	}
}
