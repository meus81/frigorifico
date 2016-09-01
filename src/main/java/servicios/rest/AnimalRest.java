package servicios.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.tropa.AnimalBean;
import especie.Especie;
import tropa.Animal;
import tropa.Categoria;
import tropa.Tropa;
import servicios.AnimalDAO;
import servicios.CategoriaDAO;
import servicios.EspecieDAO;
import servicios.TropaDAO;

@ApplicationPath("/resources")
@Path("/")
public class AnimalRest {

	@POST
	@Path("/agregar_animal_a_tropa")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AnimalBean salvarAnimalEnTropa(final AnimalBean animalBean) {

		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.obtenerCategoria(animalBean.getIdCategoria());

		TropaDAO tropaDAO = new TropaDAO();
		Tropa tropa = tropaDAO.obtenerTropa(animalBean.getIdTropa());

		System.out.println(tropa);

		Animal animal = new Animal();

		/*
		 * TODO como hacemos con el numero de garron? porque por un lado tenemos
		 * que el usuario lo puede cambiar y por otro que el sistema le da uno
		 * mayor que el maximo hay que validar que cuando tipea un nuemero de
		 * garron no este dado POR AHOR NO TOMAMOS EL QUE PONE EL USUARIO
		 */
		animal.setTropa(tropa);
		animal.setGarron(animalBean.getGarron());
		animal.setCategoria(categoria);
		animal.setPeso(animalBean.getPeso());
		animal.setCabezaFaenadaEntera(animalBean.isCabezaFaenadaEntera());

		AnimalDAO animalDAO = new AnimalDAO();
		animalDAO.salvarAnimal(animal);
		// Etiqueta etiqueta = new Etiqueta();
		// etiqueta.imprimirEtiquetas(tropa, animal);

		animalBean.setIdAnimal(animal.getIdAnimal());
		return animalBean;
	}

	@GET
	@Path("/obtener_siguiente_garron")
	@Produces(MediaType.APPLICATION_JSON)
	public AnimalBean getGarron() {
		AnimalBean animal = new AnimalBean();
		TropaDAO tropaDAO = new TropaDAO();
		int siguienteGarron = tropaDAO.obtenerSiguienteNumeroDeGarron();
		animal.setGarron(siguienteGarron);
		return animal;
	}

	@GET
	@Path("/verificar_numero_garron_modificado/{nro_garron}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response verificarGarron(@PathParam("nro_garron") int nroGarron) {
		TropaDAO tropaDAO = new TropaDAO();
		boolean garronUtilizado = tropaDAO.verificarNumeroGarronModificado(nroGarron);
		if (garronUtilizado) {
			String json = "{\"result\": \"true\"}";
			return Response.status(200).header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
					.entity(json).build();
		}

		else {
			String json = "{\"result\": \"false\"}";
			return Response.status(200).header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
					.entity(json).build();
		}

	}

}
