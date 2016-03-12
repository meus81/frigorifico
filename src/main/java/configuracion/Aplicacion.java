package configuracion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.glassfish.jersey.server.ResourceConfig;

public class Aplicacion {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("frigorifico");
	private EntityManager em = emf.createEntityManager();
	private static Aplicacion _instance = null;
	//final ResourceConfig application = new ResourceConfig();
	
	private Aplicacion(){
	}
	
	public static Aplicacion getInstance(){
		if (_instance == null){
			_instance = new Aplicacion();
			
		}
		return _instance;
	}
	
	public EntityManager getEntityManager(){
		return _instance.em;
	}
	
	public void closeEntityManagerFactory(){
		_instance.emf.close();
	}
}
