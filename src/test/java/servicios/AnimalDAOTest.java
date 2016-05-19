package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import configuracion.Aplicacion;
import modelo.especie.Especie;
import modelo.establecimiento.Establecimiento;
import modelo.tropa.Animal;
import modelo.tropa.Categoria;
import modelo.tropa.Procedencia;
import modelo.tropa.Tropa;
import modelo.tropa.TropaReservada;

public class AnimalDAOTest {

	private static Tropa tropa = null;
	private static Logger logger = Logger.getLogger(AnimalDAOTest.class.getName());
	private static Connection connection;

	@BeforeClass
	public static void setUp() {
		try {
			logger.info("Startingemory HSQL database for unit tests");
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:mem:unit-testing-jpa", "sa", "");
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail("Exception during HSQL database startup.");
		}
		try {
			logger.info("BuildingEntityManager for unit tests");
			Aplicacion.setEntityManagerFactoryForTest();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail("Exception during JPA EntityManager instanciation.");
		}
		
		EstablecimientoDAO es = new EstablecimientoDAO();
		Establecimiento establecimiento = es.obtenerEstablecimiento(1);
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

		ProcedenciaDAO procedenciaDAO = new ProcedenciaDAO();
		Procedencia procedencia = procedenciaDAO.obtenerProcedencia(1);

		TropaReservadaDAO treservadaDAO = new TropaReservadaDAO();
		TropaReservada treservada = treservadaDAO.obtenerTropaReservadaPorProcedenciaYanioActual(procedencia);

		EspecieDAO especieDAO = new EspecieDAO();
		Especie especie = especieDAO.obtenerEspecie(2);

		Tropa tropa1 = new Tropa();
		tropa1.setEstablecimiento(establecimiento);
		tropa1.setAnimalesRecibidos(75);
		tropa1.setNumeroTropa(treservada.obtenerSiguienteNroDeTropa());
		tropa1.setFechaIngreso(new GregorianCalendar().getTime());
		tropa1.setFechaFaena(new GregorianCalendar().getTime());
		tropa1.setEspecie(especie);

		TropaDAO trDAO = new TropaDAO();
		trDAO.salvarTropa(tropa1);

		tropa = trDAO.obtenerTropaPorNroTropa(tropa1.getNumeroTropa());
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		logger.info("Shuting Hibernate JPA layer.");
		Aplicacion.closeEntityManagerFactoryForTest();
	}

	@Test
	public void salvatYobtenerAnimalDAOTest() {
		CategoriaDAO cs = new CategoriaDAO();
		Categoria categoria = cs.obtenerCategoria(1);

		TropaDAO tropaDAO = new TropaDAO();

		Animal animal1 = new Animal();
		animal1.setGarron(tropaDAO.obtenerSiguienteNumeroDeGarron());
		animal1.setPeso(250);
		animal1.setCategoria(categoria);
		animal1.setTropa(tropa);

		AnimalDAO animalDAO = new AnimalDAO();
		animalDAO.salvarAnimal(animal1);
		Animal animalBBDD = animalDAO.obtenerAnimalPorTropaYGarron(tropa, animal1.getGarron());

		Assert.assertEquals("El numero de garron NO COINCIDEEEEE!!!!", animal1.getGarron(), animalBBDD.getGarron());
	}
	
	public void obtenerAnimalesPorTropaTest(){
		
	}
}
