package servicios.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bean.tropa.AnimalBean;
import modelo.tropa.Animal;
import modelo.tropa.Categoria;
import modelo.tropa.Tropa;
import servicios.AnimalDAO;
import servicios.CategoriaDAO;
import servicios.TropaDAO;

@ApplicationPath("/resources")
@Path("/")
public class AnimalRest {

	@POST
	@Path("/agregar_animal_a_tropa")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AnimalBean salvarAnimalEnTropa (final AnimalBean animalBean){
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.obtenerCategoria(animalBean.getIdCategoria());
		
		TropaDAO tropaDAO = new TropaDAO();
		Tropa tropa = tropaDAO.obtenerTropa(animalBean.getIdTropa());
		
		Animal animal = new Animal();
		
		/*TODO como hacemos con el numero de garron?
		 * porque por un lado tenemos que el usuario lo puede cambiar
		 * y por otro que el sistema le da uno mayor que el maximo
		 * hay que vlidar que cuando tipea un nuemero de garron 
		 * no este dado
		 * POR AHOR NO TOMAMOS EL QUE PONE EL USUARIO
		 * */
		animal.setGarron(tropaDAO.obtenerSiguienteNumeroDeGarron());
		animal.setPeso(animalBean.getPeso());
		animal.setCategoria(categoria);
		animal.setTropa(tropa);
		
		AnimalDAO animalDAO = new AnimalDAO();
		animalDAO.salvarAnimal(animal);
		
		animalBean.setIdAnimal(animal.getIdAnimal());
		return animalBean;
	}
}
