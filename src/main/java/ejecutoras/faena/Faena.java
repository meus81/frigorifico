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
	private TropaDAO tropaDAO = new TropaDAO();
	private TropaReservadaDAO tropaReservadaDAO = new TropaReservadaDAO();
	private int ultimoNroTropaReservada;
	
	public void inicializarFaena(Procedencia procedencia, Especie especie) {
		EstablecimientoDAO establecimientoServicioDatabase = new EstablecimientoDAO();
		Establecimiento establecimiento = establecimientoServicioDatabase.obtenerEstablecimiento(1);
		TropaReservada tropaReservada = tropaReservadaDAO.obtenerTropaReservadaPorProcedenciaYanioActual(procedencia);
		
		ultimoNroTropaReservada = tropaReservada.obtenerSiguienteNroDeTropa();
		Tropa tropa = new Tropa();
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
		tropaDAO.salvarTropa(tropa);
		tropaReservadaDAO.actualizar(tropaReservada);
	}

	public void imprimirEtiqueta(double peso, Categoria categoria, boolean cabezaAlMedio) {
		Tropa tropa = tropaDAO.obtenerTropaPorNroTropa(ultimoNroTropaReservada);
			
//		System.out.println("la ultima tropa guardada fue: " + tropa.getNumeroTropa());
		
		Animal animal = new Animal();
		animal.setCategoria(categoria);
		animal.setPeso(peso);
		animal.setGarron(tropaDAO.obtenerSiguienteNumeroDeGarron());
		animal.setTropa(tropa);

//		//tropaServicio.actualizar(this.getTropa());
		AnimalDAO animalServicioDatabase = new AnimalDAO();
		animalServicioDatabase.salvarAnimal(animal);
		
		Etiqueta etiqueta = new Etiqueta();
		etiqueta.imprimirEtiquetas(tropa, animal);
	}

	public void finalizarFaena() {
		//TODO no sabemos bien que puede llegar a hacer este metodo. Destruir el objeto tal vez??
	}
}
