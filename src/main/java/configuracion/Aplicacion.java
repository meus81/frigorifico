package configuracion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
