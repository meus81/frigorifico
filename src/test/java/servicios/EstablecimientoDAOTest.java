package servicios;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import com.sun.research.ws.wadl.Application;

import configuracion.Aplicacion;
import modelo.establecimiento.Establecimiento;

@PersistenceContext(name = "frigorifico-test")
public class EstablecimientoDAOTest {

	private static Logger logger = Logger.getLogger(EstablecimientoDAOTest.class.getName());
	private static Connection connection;

	@BeforeClass
	public static void setUp() throws Exception {
		
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
	}

	@AfterClass
	public static void tearDown() throws Exception {
		logger.info("Shuting Hibernate JPA layer.");
		Aplicacion.closeEntityManagerFactoryForTest();
	}

	@Test
	public void salvarYobtenerEstablecimientoDAOTest() {
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

		EstablecimientoDAO etablecimeintoDAO = new EstablecimientoDAO();
		etablecimeintoDAO.salvarEstablecimiento(capiangos);
		Establecimiento establecimientoDesdeLaBBDD = etablecimeintoDAO.obtenerEstablecimiento(1);

		// System.out.println("RESULTADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" +
		// establecimientoDesdeLaBBDD.getNombre());
		// System.out.println(capiangos.getNombre());

		Assert.assertTrue(establecimientoDesdeLaBBDD.getNombre().equals(capiangos.getNombre()));
		/*
		 * TODO: agregar asserts para que compare el resto de los atributos del
		 * objeto
		 */
	}

	@Test
	public void obtenerEstablecimientoInexistenteDAOTest() {
		EstablecimientoDAO es = new EstablecimientoDAO();
		Establecimiento e = es.obtenerEstablecimiento(120);
		Assert.assertNull("El establecimiento que estas pidiendo existe, por eso no es null y el test falla", e);
	}

	public void actualizarEstablecimientoTest() {

	}
}
